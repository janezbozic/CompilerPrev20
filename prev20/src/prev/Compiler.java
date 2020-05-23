package prev;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

import org.antlr.v4.runtime.*;

import prev.common.report.*;
import prev.data.asm.AsmInstr;
import prev.data.asm.AsmLABEL;
import prev.data.asm.Code;
import prev.data.ast.tree.*;
import prev.data.ast.tree.decl.AstFunDecl;
import prev.data.imc.code.stmt.ImcLABEL;
import prev.data.lin.LinDataChunk;
import prev.phase.lexan.*;
import prev.phase.synan.*;
import prev.phase.abstr.*;
import prev.phase.seman.*;
import prev.phase.memory.*;
import prev.phase.imcgen.*;
import prev.phase.imclin.*;
import prev.phase.asmgen.*;
import prev.phase.livean.*;
import prev.phase.regall.*;

/**
 * The compiler.
 */
public class Compiler {

	// COMMAND LINE ARGUMENTS

	/** All valid phases of the compiler. */
	private static final String phases = "none|lexan|synan|abstr|seman|memory|imcgen|imclin|asmgen|livean|regall";

	/** Values of command line arguments. */
	private static HashMap<String, String> cmdLine = new HashMap<String, String>();

	/**
	 * Returns the value of a command line argument.
	 * 
	 * @param cmdLineArgName The name of the command line argument.
	 * @return The value of the specified command line argument or {@code null} if
	 *         the specified command line argument has not been used.
	 */
	public static String cmdLineArgValue(String cmdLineArgName) {
		return cmdLine.get(cmdLineArgName);
	}

	// THE COMPILER'S STARTUP METHOD

	/**
	 * The compiler's startup method.
	 * 
	 * @param args Command line arguments (see {@link prev.Compiler}).
	 */
	public static void main(String[] args) {
		try {
			Report.info("This is PREV'20 compiler:");

			// Scan the command line.
			for (int argc = 0; argc < args.length; argc++) {
				if (args[argc].startsWith("--")) {
					// Command-line switch.
					if (args[argc].matches("--src-file-name=.*")) {
						if (cmdLine.get("--src-file-name") == null) {
							cmdLine.put("--src-file-name", args[argc]);
							continue;
						}
					}
					if (args[argc].matches("--dst-file-name=.*")) {
						if (cmdLine.get("--dst-file-name") == null) {
							cmdLine.put("--dst-file-name", args[argc]);
							continue;
						}
					}
					if (args[argc].matches("--target-phase=(" + phases + "|all)")) {
						if (cmdLine.get("--target-phase") == null) {
							cmdLine.put("--target-phase", args[argc].replaceFirst("^[^=]*=", ""));
							continue;
						}
					}
					if (args[argc].matches("--logged-phase=(" + phases + "|all)")) {
						if (cmdLine.get("--logged-phase") == null) {
							cmdLine.put("--logged-phase", args[argc].replaceFirst("^[^=]*=", ""));
							continue;
						}
					}
					if (args[argc].matches("--xml=.*")) {
						if (cmdLine.get("--xml") == null) {
							cmdLine.put("--xml", args[argc].replaceFirst("^[^=]*=", ""));
							continue;
						}
					}
					if (args[argc].matches("--xsl=.*")) {
						if (cmdLine.get("--xsl") == null) {
							cmdLine.put("--xsl", args[argc].replaceFirst("^[^=]*=", ""));
							continue;
						}
					}
					if (args[argc].matches("--num-regs=.*")) {
						if (cmdLine.get("--num-regs") == null) {
							cmdLine.put("--num-regs", args[argc].replaceFirst("^[^=]*=", ""));
							continue;
						}
					}
					Report.warning("Command line argument '" + args[argc] + "' ignored.");
				} else {
					// Source file name.
					if (cmdLine.get("--src-file-name") == null) {
						cmdLine.put("--src-file-name", args[argc]);
					} else {
						Report.warning("Source file '" + args[argc] + "' ignored.");
					}
				}
			}
			if (cmdLine.get("--src-file-name") == null) {
				throw new Report.Error("Source file not specified.");
			}
			if (cmdLine.get("--dst-file-name") == null) {
				cmdLine.put("--dst-file-name", cmdLine.get("--src-file-name").replaceFirst("\\.[^./]*$", "") + ".mms");
			}
			if (cmdLine.get("--target-phase") == null) {
				cmdLine.put("--target-phase", phases.replaceFirst("^.*\\|", ""));
			}

			// Compilation process carried out phase by phase.
			while (true) {

				// Lexical analysis.
				if (Compiler.cmdLineArgValue("--target-phase").equals("lexan"))
					try (LexAn lexan = new LexAn()) {
						while (lexan.lexer.nextToken().getType() != Token.EOF) {
						}
						break;
					}

				// Syntax analysis.
				try (LexAn lexan = new LexAn(); SynAn synan = new SynAn(lexan)) {
					SynAn.tree = synan.parser.source();
					synan.log(SynAn.tree);
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("synan"))
					break;

				// Abstract syntax tree construction.
				try (Abstr abstr = new Abstr()) {
					Abstr.tree = SynAn.tree.ast;
					AstNode.lock();
					AbsLogger logger = new AbsLogger(abstr.logger);
					Abstr.tree.accept(logger, "Decls");
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("abstr"))
					break;

				// Semantic analysis.
				try (SemAn seman = new SemAn()) {
					Abstr.tree.accept(new NameResolver(), null);
					Abstr.tree.accept(new TypeResolver1(), null);
					Abstr.tree.accept(new TypeResolver2(), null);
					Abstr.tree.accept(new TypeResolver3(), null);
					Abstr.tree.accept(new TypeResolver4(), null);
					Abstr.tree.accept(new TypeResolver5(), null);
					Abstr.tree.accept(new AddrResolver(), null);
					SemAn.declaredAt.lock();
					SemAn.declaresType.lock();
					SemAn.isType.lock();
					SemAn.ofType.lock();
					SemAn.isAddr.lock();
					AbsLogger logger = new AbsLogger(seman.logger);
					logger.addSubvisitor(new SemLogger(seman.logger));
					Abstr.tree.accept(logger, "Decls");
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("seman"))
					break;

				// Memory layout.
				try (Memory memory = new Memory()) {
					Abstr.tree.accept(new MemEvaluator(), null);
					Memory.frames.lock();
					Memory.accesses.lock();
					Memory.strings.lock();
					AbsLogger logger = new AbsLogger(memory.logger);
					logger.addSubvisitor(new SemLogger(memory.logger));
					logger.addSubvisitor(new MemLogger(memory.logger));
					Abstr.tree.accept(logger, "Decls");
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("memory"))
					break;

				// Intermediate code generation.
				try (ImcGen imcgen = new ImcGen()) {
					Abstr.tree.accept(new CodeGenerator(), null);
					ImcGen.exprImc.lock();
					ImcGen.stmtImc.lock();
					AbsLogger logger = new AbsLogger(imcgen.logger);
					logger.addSubvisitor(new SemLogger(imcgen.logger));
					logger.addSubvisitor(new MemLogger(imcgen.logger));
					logger.addSubvisitor(new ImcLogger(imcgen.logger));
					Abstr.tree.accept(logger, "Decls");
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("imcgen"))
					break;

				// Linearization of intermediate code.
				try (ImcLin imclin = new ImcLin()) {
					Abstr.tree.accept(new ChunkGenerator(), null);
					imclin.log();

					//Interpreter interpreter = new Interpreter(ImcLin.dataChunks(), ImcLin.codeChunks());
					//System.out.println("EXIT CODE: " + interpreter.run("_main"));
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("imclin"))
					break;
				
				// Machine code generation.
				try (AsmGen asmgen = new AsmGen()) {
					asmgen.genAsmCodes();
					asmgen.log();
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("acmgen"))
					break;

				// Liveness analysis.
				try (LiveAn livean = new LiveAn()) {
					livean.analysis();
					livean.log();
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("livean"))
					break;

				// Register allocation.
				try (RegAll regall = new RegAll()) {
					regall.allocate();
					regall.log();
				}
				if (Compiler.cmdLineArgValue("--target-phase").equals("regall"))
					break;

				wrapup();

				break;
			}

			Report.info("Done.");
		} catch (Report.Error __) {
			System.exit(1);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static void wrapup() throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter printWriter = new PrintWriter(cmdLineArgValue("--dst-file-name").substring(16));

		printWriter.println("\tLOC	#100");
		printWriter.println("\tGREG	@"); //254 SP
		printWriter.println("R254\tOCTA 0");
		printWriter.println("\tGREG	@"); //253 FP
		printWriter.println("R253\tOCTA 0");
		printWriter.println("\tGREG	@"); //252 HP
		printWriter.println("R252\tOCTA 0");


		printWriter.println("\tGREG	@");
		printWriter.println("PRINT	BYTE	0,0");

		printWriter.println("inCount	IS	#1");
		printWriter.println("InArgs	OCTA	charRead,inCount");
		printWriter.println("charRead	BYTE	0");

		printWriter.println();

		int size = 0;
		boolean first = true;

		for (LinDataChunk d: ImcLin.dataChunks()) {
			if (size > 255 || first){
				printWriter.println("\tGREG	@");
				size = 0;
				first = false;
			}
			if (d != null){
				String decl = d.label.name + "\t" + "OCTA\t" + d.init + ",0";
				printWriter.println(decl);
				size += d.size;
			}
			else{
				String s = d.label.name + "\t" + "OCTA\t";
				for(int i = 0; i < d.size / 8; i++) {
					s += i == 0 ? "0" : ",0";
				}
				size += d.size;
				printWriter.println(s);
			}
		}

		printWriter.println();

		printWriter.println("Main\tSET $0,#0");

		printWriter.println("\tSETH $252,#3000");

		printWriter.println("\tSETH $254,#3FFF");
		printWriter.println("\tINCMH $254,#FFFF");
		printWriter.println("\tINCML $254,#FFFF");
		printWriter.println("\tINCL $254,#FFFF");

		printWriter.println("\tPUSHJ $0,_main");

		printWriter.println("\tTRAP 0,Halt,0");

		printWriter.println();

		for (Code code: AsmGen.codes){

			if (code.frame.label.name.equals("_putChar") || code.frame.label.name.equals("_exit") || code.frame.label.name.equals("_getChar")){
				continue;
			}

			//	oldFP
			printWriter.println(code.frame.label.name + "\tSET $0,$254");
			printWriter.println("\tSETL $1,"+ (code.frame.locsSize + 8));
			printWriter.println("\tSUB $0,$0,$1" );
			printWriter.println("\tSTO $253,$0,0");

			// Save the return address
			printWriter.println("\tSUB $0,$0," + 8);
			printWriter.println("\tGET $2,rJ");
			printWriter.println("\tSTO $2,$0,0");

			// Increase FP and SP
			printWriter.println("\tSET $253,$254");
			printWriter.println("\tSETL $1,"+ (code.frame.size + code.tempSize));
			printWriter.println("\tSUB $254,$254,$1");

			// Jump to body
			printWriter.println("\tJMP " + code.entryLabel.name);

			for (int i = 0; i<code.instrs.size(); i++){
				AsmInstr instr = code.instrs.get(i);
				if(instr instanceof AsmLABEL) {
					AsmLABEL label = (AsmLABEL) instr;
					instr = code.instrs.get(i+1);
					printWriter.println(label.label.name + "\t" + instr.toString(RegAll.tempToReg));
					i++;
				}else {
					printWriter.println("\t" + instr.toString(RegAll.tempToReg));
				}
			}

			printWriter.println(code.exitLabel.name + "\tSTO $0,$253,0");
			printWriter.println("\tSET $0,$253");
			printWriter.println("\tSETL $1,"+ (code.frame.locsSize + 8));
			printWriter.println("\tSUB $0,$0,$1");
			printWriter.println("\tLDO $2,$0,0");

			printWriter.println("\tSET $254,$253");
			printWriter.println("\tSET $253,$2");

			printWriter.println("\tSUB $0,$0," + 8);
			printWriter.println("\tLDO $2,$0,0");
			printWriter.println("\tPUT rJ,$2");

			printWriter.println("\tPOP");

			printWriter.println();
		}

		printWriter.println("_putChar	SET $0,$254");
		printWriter.println("\tADD $0,$0,8");
		printWriter.println("\tLDO $0,$0,0");
		printWriter.println("\tLDA $255,PRINT");
		printWriter.println("\tSTB $0,$255,0");
		printWriter.println("\tTRAP 0,Fputs,StdOut");
		printWriter.println("\tPOP");

		printWriter.println();

		printWriter.println("_getChar	SET $0,$254");
		printWriter.println("\tSET $1,8");
		printWriter.println("\tSUB $0,$0,$1");
		printWriter.println("\tSTO $253,$0,0");
		printWriter.println("\tSUB $0,$0,8");
		printWriter.println("\tGET $1,rJ");
		printWriter.println("\tSTO $1,$0,0");
		printWriter.println("\tSET $253,$254");
		printWriter.println("\tSET $0,16");
		printWriter.println("\tSUB $254,$254,$0");
		printWriter.println("\tLDA	$255,InArgs");
		printWriter.println("\tTRAP 0,Fread,StdIn");
		printWriter.println("\tLDA	$255,charRead");
		printWriter.println("\tLDB	$0,$255,0");
		printWriter.println("\tSTO $0,$253,0");
		printWriter.println("\tSET $0,$253");
		printWriter.println("\tSET $1,8");
		printWriter.println("\tSUB $0,$0,$1");
		printWriter.println("\tLDO $1,$0,0");
		printWriter.println("\tSET $254,$253");
		printWriter.println("\tSET $253,$1");
		printWriter.println("\tSUB $0,$0,8");
		printWriter.println("\tLDO $1,$0,0");
		printWriter.println("\tPUT rJ,$1");
		printWriter.println("\tPOP");

		printWriter.println();

		printWriter.println("_new    LDO    $0,$254,0");
		printWriter.println("\tSTO    $252,$254,0");
		printWriter.println("\tADD    $252,$252,$0");
		printWriter.println("\tPOP");

		printWriter.println();

		printWriter.println("_del    POP");

		printWriter.println();

		printWriter.println("_exit	TRAP 0,Halt,0");

		printWriter.flush();
		printWriter.close();

	}

}
