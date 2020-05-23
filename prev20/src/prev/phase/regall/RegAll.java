package prev.phase.regall;

import prev.Compiler;
import prev.data.asm.AsmInstr;
import prev.data.asm.AsmOPER;
import prev.data.asm.Code;
import prev.data.mem.MemTemp;
import prev.phase.Phase;
import prev.phase.asmgen.AsmGen;
import prev.phase.livean.LiveAn;

import java.util.*;

/**
 * Register allocation.
 */
public class RegAll extends Phase {
	
	/** Mapping of temporary variables to registers. */
	public static final HashMap<MemTemp, Integer> tempToReg = new HashMap<MemTemp, Integer>();

	public int R;
	public MemTemp FP = null;

	public RegAll() {
		super("regall");
		R = Integer.parseInt(Compiler.cmdLineArgValue("--num-regs"));
	}

	public void allocate() {

		for (Code code : AsmGen.codes) {
			FP = code.frame.FP;
			HashMap<MemTemp, Vozlisce> graf = new HashMap<>();
			while (true) {
				graf = build(code.instrs);
				HashMap<MemTemp, Vozlisce> modifiedGraf = new HashMap<MemTemp, Vozlisce> (graf);
				Stack<MemTemp> sklad = new Stack<>();
				while (true) {
					simplify(modifiedGraf, sklad);
					if (!spill(modifiedGraf, sklad))
						break;
				}
				Vozlisce defSpill = select(graf, modifiedGraf, sklad);
				if (defSpill != null) {
					code.tempSize += 8;
					long offset = code.tempSize + code.frame.locsSize + 16;
					for (int i = 0; i<code.instrs.size(); i++){
						AsmInstr instr = code.instrs.get(i);
						int x = instr.uses().indexOf(defSpill.temp);
						if (x > -1){
							MemTemp newTemp1 = new MemTemp();
							MemTemp newTemp2 = new MemTemp();
							Vector<MemTemp> v = instr.uses();
							v.set(x, newTemp1);
							AsmOPER ns = new AsmOPER(((AsmOPER) instr).instr(), v, instr.defs(), instr.jumps());
							Vector<MemTemp> newDefs = new Vector<>();
							newDefs.add(newTemp2);
							AsmOPER newNeg = new AsmOPER("NEG `d0,0," + offset, null, newDefs, null);
							Vector<MemTemp> newUses = new Vector<>();
							Vector<MemTemp> newDefs1 = new Vector<>();
							newDefs1.add(newTemp1);
							newUses.add(newTemp2);
							newUses.add(FP);
							AsmOPER newOper = new AsmOPER("LDO `d0,`s0,`s1", newUses, newDefs1, null);
							code.instrs.add(i++, newNeg);
							code.instrs.add(i++, newOper);
							code.instrs.set(i, ns);
							instr = ns;
						}
						x = instr.defs().indexOf(defSpill.temp);
						if (x > -1){
							MemTemp newTemp1 = new MemTemp();
							MemTemp newTemp2 = new MemTemp();
							Vector<MemTemp> v = instr.defs();
							v.set(x, newTemp1);
							AsmOPER ns = new AsmOPER(((AsmOPER) instr).instr(), instr.uses(), v, instr.jumps());
							code.instrs.set(i++, ns);
							Vector<MemTemp> newDefs = new Vector<>();
							newDefs.add(newTemp2);
							AsmOPER newNeg = new AsmOPER("NEG `d0,0," + offset, null, newDefs, null);
							code.instrs.add(i++, newNeg);
							Vector<MemTemp> newUses = new Vector<>();
							newUses.add(newTemp1);
							newUses.add(FP);
							newUses.add(newTemp2);
							AsmOPER newOper = new AsmOPER("STO `s0,`s1,`s2", newUses, null, null);
							code.instrs.add(i, newOper);
						}
					}

					LiveAn l = new LiveAn();
					l.analysis();
					System.out.println(defSpill==null ? "null" : (defSpill.temp + " FP: " + FP.temp));
				}
				else {
					System.out.println(defSpill==null ? "null" : defSpill.temp + " FP: " + FP.temp);;
					break;
				}
			}
			for (MemTemp t: graf.keySet()){
				tempToReg.put(t, graf.get(t).barva);
			}
			tempToReg.put(FP, 253);
		}

	}

	private Vozlisce select(HashMap<MemTemp, Vozlisce> graf, HashMap<MemTemp, Vozlisce> modifiedGraf, Stack<MemTemp> sklad) {

		while (!sklad.empty()){
			MemTemp t = sklad.pop();
			boolean [] barve = new boolean[R];
			Vozlisce v = graf.get(t);
			if (t == FP){
				v.setBarva(253);
				System.out.println("aaaaa");
			}
			else {
				for (MemTemp tSosed : v.modifiedSosedi) {
					Vozlisce sosed = graf.get(tSosed);
					if (sosed.getBarva() > -1 && sosed.temp != FP) {
						barve[sosed.getBarva()] = true;
					}
				}
				for (int i = 0; i < R; i++) {
					if (!barve[i]) {
						v.setBarva(i);
						break;
					}
				}
			}
			if (v.getBarva() > -1){
				modifiedGraf.put(t, v);
				for (MemTemp tempV: v.sosedi){
					Vozlisce tempSosed = modifiedGraf.get(tempV);
					if (tempSosed != null){
						tempSosed.modifiedSosedi.add(t);
						v.modifiedSosedi.add(tempV);
					}
				}
				v.setSpill(false);
			}
			else {
				return v;
			}
		}

		return null;

	}

	private boolean spill (HashMap<MemTemp, Vozlisce> graf, Stack<MemTemp> sklad){

		int index = (int) (Math.random() * (graf.keySet().size()));
		Iterator it = graf.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			index--;
			if (index > -1)
				continue;
			Vozlisce v = (Vozlisce) pair.getValue();
			MemTemp t = (MemTemp) pair.getKey();
			for (MemTemp s: v.modifiedSosedi){
				graf.get(s).removeSosed(t);
			}
			sklad.push(t);
			v.setSpill(true);
			it.remove();

			return true;
		}
		return false;
	}

	private Stack<MemTemp> simplify(HashMap<MemTemp, Vozlisce> graf, Stack<MemTemp> sklad) {
		boolean zanka = true;
		while (zanka) {
			zanka = false;
			Iterator it = graf.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				Vozlisce v = (Vozlisce) pair.getValue();
				MemTemp t = (MemTemp) pair.getKey();
				if (v.modifiedSosedi.size() < R){
					for (MemTemp s: v.modifiedSosedi){
						graf.get(s).removeSosed(t);
					}
					it.remove();
					zanka = true;
					sklad.push(t);
				}
			}
		}

		return sklad;
	}

	public HashMap<MemTemp, Vozlisce> build (Vector<AsmInstr> instrs) {

		HashMap<MemTemp, Vozlisce> vozlisca = new HashMap<>();

		for (int i = 0; i < instrs.size(); i++){
			HashSet<MemTemp> out = instrs.get(i).out();
			for (MemTemp outi: out){
				if (outi != FP) {
					Vozlisce v = vozlisca.get(outi);
					if (v == null) {
						v = new Vozlisce(outi, out);
						vozlisca.put(outi, v);
					} else {
						v.addA(out);
					}
				}
			}
			Vector<MemTemp> def = instrs.get(i).defs();
			for (MemTemp defi: def){
				if (defi != FP) {
					Vozlisce v = vozlisca.get(defi);
					if (v == null) {
						HashSet<MemTemp> h = new HashSet<>(def);
						v = new Vozlisce(defi, h);
						vozlisca.put(defi, v);
					} else {
						v.addA(new HashSet<>(def));
					}
				}
			}
		}

		for (MemTemp t: vozlisca.keySet()){
			vozlisca.get(t).sosedi.remove(FP);
			vozlisca.get(t).removeSosed(FP);
		}

		return vozlisca;
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
				logger.addAttribute("code", instr.toString(tempToReg));
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

class Vozlisce {

	MemTemp temp;
	HashSet <MemTemp> sosedi;
	HashSet <MemTemp> modifiedSosedi;
	boolean spill;
	int barva;

	public Vozlisce (MemTemp t, HashSet<MemTemp> temps){
		temp = t;
		sosedi = new HashSet<>();
		modifiedSosedi = new HashSet<>();
		addA(temps);
		spill = false;
		barva = -1;
	}

	public void dodajModifiedSosede(){
		modifiedSosedi.addAll(sosedi);
	}

	public void addA (HashSet<MemTemp> set){
		sosedi.addAll(set);
		modifiedSosedi.addAll(set);
		sosedi.remove(temp);
		modifiedSosedi.remove(temp);
	}

	public void removeSosed(MemTemp t) {
		modifiedSosedi.remove(t);
	}

	public boolean isSpill() {
		return spill;
	}

	public void setSpill(boolean spill) {
		this.spill = spill;
	}

	public int getBarva() {
		return barva;
	}

	public void setBarva(int barva) {
		this.barva = barva;
	}
}
