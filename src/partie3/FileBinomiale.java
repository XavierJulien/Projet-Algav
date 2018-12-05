package partie3;

import java.util.ArrayList;

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
	
	public void SupprMin() {
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
	private void consolider(ArrayList<ArbreB> arbres) {
		int n = arbres.size();
		if(n>0) {
			ArrayList<ArbreB> res = new ArrayList<ArbreB>();
			
			for(int i = 0;i< arbres.size();i++) {
				for(int j = i+1;i<arbres.size();i++) {
					if (arbres.get(j).getSize() == arbres.get(i).getSize()) {
						arbres.add(arbres.get(i).Union2Tid(arbres.get(j)));
						arbres.remove(j);
						arbres.remove(i);
						break;
					}
				}
			}
			this.arbres = res;
		}
	}
	
	
}