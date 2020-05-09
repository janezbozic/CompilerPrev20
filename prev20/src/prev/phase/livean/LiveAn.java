package prev.phase.livean;

import prev.data.mem.*;
import prev.data.asm.*;
import prev.phase.*;
import prev.phase.asmgen.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Vector;

/**
 * Liveness analysis.
 */
public class LiveAn extends Phase {

	public LiveAn() {
		super("livean");
	}

	public void analysis() {

		HashMap<MemLabel, AsmInstr> labels = new HashMap<>();

		for (Code code : AsmGen.codes) {
			for (int i = 0; i < code.instrs.size(); i++){
				AsmInstr instr = code.instrs.get(i);
				if (instr instanceof AsmLABEL){
					labels.put(((AsmLABEL)instr).label, code.instrs.get(i+1));
				}
			}
		}

		for (Code code : AsmGen.codes) {
			boolean zanka = true;
			while (zanka) {
				zanka = false;
				for (int i = 0; i < code.instrs.size(); i++){
					AsmInstr instr = code.instrs.get(i);

					HashSet<MemTemp> oldIn = instr.in();
					HashSet<MemTemp> oldOut = instr.out();

					HashSet<MemTemp> out = instr.out();
					HashSet<MemTemp> in = new HashSet<MemTemp>(instr.uses());

					out.removeAll(instr.defs());
					in.addAll(out);
					instr.addInTemps(in);

					out.clear();
					out.addAll(instr.defs());
					Vector<AsmInstr> nexts = new Vector<>();

					if (instr.jumps() != null) {
						for (int j = 0; j<instr.jumps().size(); j++)
							if (labels.get(instr.jumps().get(j)) != null)
								nexts.add(labels.get(instr.jumps().get(j)));
						if (instr.uses() != null && code.instrs.size() > i+1){
							nexts.add(code.instrs.get(i+1));
						}
					}
					else {
						if (code.instrs.size() > i+1)
							nexts.add(code.instrs.get(i+1));
					}

					for (AsmInstr nextIn: nexts){
						out.addAll(nextIn.in());
					}

					instr.addOutTemp(out);

					if (!(in.containsAll(oldIn) && oldIn.containsAll(in) && out.containsAll(oldOut) && oldOut.containsAll(out))){
						zanka = true;
					}
				}
			}
		}

	}

	public void log() {
		if (logger == null)
			return;
		for (Code code : AsmGen.codes) {
			logger.begElement("code");
			logger.addAttribute("entrylabel", code.entryLabel.name);
			logger.addAttribute("exitlabel", code.exitLabel.name);
			logger.addAttribute("tempsize", Long.toString(code.tempSize));
			code.frame.log(logger);
			logger.begElement("instructions");
			for (AsmInstr instr : code.instrs) {
				logger.begElement("instruction");
				logger.addAttribute("code", instr.toString());
				logger.begElement("temps");
				logger.addAttribute("name", "use");
				for (MemTemp temp : instr.uses()) {
					logger.begElement("temp");
					logger.addAttribute("name", temp.toString());
					logger.endElement();
				}
				logger.endElement();
				logger.begElement("temps");
				logger.addAttribute("name", "def");
				for (MemTemp temp : instr.defs()) {
					logger.begElement("temp");
					logger.addAttribute("name", temp.toString());
					logger.endElement();
				}
				logger.endElement();
				logger.begElement("temps");
				logger.addAttribute("name", "in");
				for (MemTemp temp : instr.in()) {
					logger.begElement("temp");
					logger.addAttribute("name", temp.toString());
					logger.endElement();
				}
				logger.endElement();
				logger.begElement("temps");
				logger.addAttribute("name", "out");
				for (MemTemp temp : instr.out()) {
					logger.begElement("temp");
					logger.addAttribute("name", temp.toString());
					logger.endElement();
				}
				logger.endElement();
				logger.endElement();
			}
			logger.endElement();
			logger.endElement();
		}
	}
}
