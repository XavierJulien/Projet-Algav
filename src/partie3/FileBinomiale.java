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
		int size = 0;
		for(int i = 0;i < arbres.size();i++){
			ArbreB a = arbres.get(i);
			if(a.getSize()< size){
				index = i;
				size = a.getSize();
			}
		}
		return arbres.get(index);
	}

	public FileBinomiale reste(){
		ArrayList<ArbreB> copy = arbres;
		copy.remove(this.minDeg());
		return new FileBinomiale(copy);
	}

	public FileBinomiale ajoutMin(ArbreB a){
		ArrayList<ArbreB> copy = arbres;
		copy.add(a);
		return new FileBinomiale(copy);
	}

	public FileBinomiale SupprMin() {
		FileBinomiale res = new FileBinomiale();
		int index = 0;
		Cle max = arbres.get(0).getC();
		for(int i = 1;i<arbres.size();i++) {
			if(arbres.get(i).getC().inf(max)) {
				index = i;
				max = arbres.get(i).getC();
			}
		}
		if(arbres.get(index).degre() == 0) {
			arbres.remove(index);
		}else {
			FileBinomiale f = arbres.get(index).decapite();
			//union
		}
		return res;
	}

	public void Ajout(Cle c) {
		//union 
	}

	public FileBinomiale ConsIter(ArrayList<Cle> cles) {
		FileBinomiale fb = new FileBinomiale();
		int size = cles.size();
		String tb = Integer.toBinaryString(size);
		System.out.println(tb);
		int lastsize = 0;
		for(int i = tb.length()-1;i>=0;i--) {
			if(tb.charAt(i) == '1') {
				System.out.println("index :"+tb.indexOf(tb.charAt(i)));
				int sizearb = (int) Math.pow(2, tb.indexOf(tb.charAt(i)));
				System.out.println("sizearb :"+sizearb+"\n lastsize : "+lastsize);
				List<Cle> c = cles.subList(lastsize, sizearb+lastsize);
				ArbreB a = new ArbreB().toArbreB(c);
				lastsize+= sizearb;
				fb.getArbres().add(a);
			}
		}
		return fb;
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