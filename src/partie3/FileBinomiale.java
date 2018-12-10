package partie3;

import java.util.ArrayList;
import java.util.List;

import partie1.Cle;

public class FileBinomiale {

	private ArrayList<ArbreB> arbres;
	private int size;
	public FileBinomiale() {
		arbres = new ArrayList<ArbreB>();
		size = 0;
	}
	public FileBinomiale(ArrayList<ArbreB> sousarbres) {
		this.arbres = sousarbres;
		size = sousarbres.size();
	}
	public FileBinomiale(ArbreB arbreB) {
		arbres = new ArrayList<ArbreB>();
		arbres.add(arbreB);
		size = 1;
	}
	//getters
	public ArrayList<ArbreB> getArbres() {
		return arbres;
	}
	public int getSize() {
		return size;
	}

	//primitives
	public boolean estVide(){return arbres.isEmpty();}

	public ArbreB minDeg(){
		int index = 0;
		int degre = arbres.get(0).degre();
		for(int i = 1;i < arbres.size();i++){
			ArbreB a = arbres.get(i);
			if(a.degre() < degre){
				index = i;
				degre = a.degre();
			}
		}
		return arbres.get(index);
	}

	public FileBinomiale reste(FileBinomiale f){
		ArrayList<ArbreB> copy = f.getArbres();
		copy.remove(f.minDeg());
		return new FileBinomiale(copy);
	}

	public FileBinomiale ajoutMin(ArbreB a,FileBinomiale f){
		ArrayList<ArbreB> copy = f.getArbres();
		copy.add(a);
		return new FileBinomiale(copy);
	}

	public FileBinomiale SupprMin() {
		int index = 0;
		Cle max = arbres.get(0).getC();
		for(int i = 1;i<arbres.size();i++) {
			if(arbres.get(i).getC().inf(max)) {
				index = i;
				max = arbres.get(i).getC();
			}
		}
		if(arbres.get(index).degre() == 0) {
			return new FileBinomiale(arbres.remove(index));
		}else {
			FileBinomiale f = arbres.get(index).decapite();
			arbres.remove(index);
			return union(f,new FileBinomiale(arbres));
		}
	}

	public void Ajout(Cle c) {
		union(this,new FileBinomiale(new ArbreB(c)));
	}

	public FileBinomiale ConsIter(ArrayList<Cle> cles) {
		FileBinomiale fb = new FileBinomiale();
		String tb = Integer.toString(cles.size(), 2);
		int lastsize = 0;
		for(int i = tb.length()-1;i>=0;i--) {
			if(tb.charAt(i) == '1') {
				int sizearb = (int) Math.pow(2, tb.length()-1-i);
				List<Cle> c = cles.subList(lastsize, sizearb+lastsize);
				ArbreB a = new ArbreB().toArbreB(c);
				lastsize+= sizearb;
				fb.getArbres().add(0,a);
			}
		}
		return fb;
	}

	
	public FileBinomiale union(FileBinomiale f1, FileBinomiale f2) {
		return uFret(f1,f2,new ArbreB());
		
	}
	
	private FileBinomiale uFret(FileBinomiale f1, FileBinomiale f2, ArbreB a) {
		if(a.estVide()) {
			if(f1.estVide()) return f2;
			if(f2.estVide()) return f1;			
			
			ArbreB t1 = f1.minDeg();
			ArbreB t2 = f2.minDeg();
			if(t1.degre() < t2.degre()) return ajoutMin(t1, union(reste(f1),f2));
			if(t2.degre() < t1.degre()) return ajoutMin(t1, union(reste(f2),f1));
			if(t1.degre() == t2.degre()) return uFret(reste(f1), reste(f2), a.Union2Tid(t1, t2));
		}else {
			if(f1.estVide()) return union(a.file(), f2);
			if(f2.estVide()) return union(a.file(), f1);
			
			ArbreB t1 = f1.minDeg();
			ArbreB t2 = f2.minDeg();
			if(a.degre() < t1.degre() && a.degre() < t2.degre()) return ajoutMin(a, union(f1, f2));
			if(a.degre() == t1.degre() && a.degre() == t2.degre()) return ajoutMin(a, uFret(reste(f1), reste(f2), a.Union2Tid(t1, t2)));
			if(a.degre() == t1.degre() && a.degre() < t2.degre()) return uFret(reste(f1), f2, a.Union2Tid(t1, a));
			if(a.degre() < t1.degre() && a.degre() == t2.degre()) return uFret(reste(f2), f1, a.Union2Tid(t2, a));
			
		}
		return null;
	}
	/*public void SupprMin() {
		int index = 0;
		Cle max = new Cle(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
		for(int i =0; i<arbres.size();i++) {
			if(arbres.get(i).getC().inf(max)) {
				index = i;
			}
		}
		if(arbres.get(index).degre() == 1) {
			arbres.remove(index);
		}else {
			FileBinomiale f = arbres.get(index).decapite();
			this.arbres.addAll(f.arbres);
			consolider(arbres);
		}
	}
	 */

	public String toString() {
		String res = "File : <";
		for(ArbreB b : this.arbres) {
			res += "[ArbreB : "+b.toString()+"]";
		}
		return res;
	}
}