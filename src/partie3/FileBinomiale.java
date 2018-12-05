package partie3;

import java.util.ArrayList;

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
			if(a.degre()< size){
				index = i;
				size = a.degre();
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
	
	
}