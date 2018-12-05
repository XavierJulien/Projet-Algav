package partie3;

import java.util.ArrayList;

import partie1.Cle;

public class ArbreB {

	private Cle c;
	private ArrayList<ArbreB> sousarbres;
	
	public ArbreB(){
		this.c = null;
		sousarbres = new ArrayList<ArbreB>();
	}
	public ArbreB(Cle c) {
		this.c = c;
		sousarbres = new ArrayList<ArbreB>();
	}
	//getters
	public ArrayList<ArbreB> getSousarbres() {return sousarbres;}
	public Cle getC() {return c;}
	//setters
	public void setSousarbres(ArrayList<ArbreB> sousarbres) {this.sousarbres = sousarbres;}
	public void setC(Cle c) {this.c = c;}
	
	//primitives
	public Boolean estVide(ArbreB a){
		if(sousarbres.isEmpty() && c == null) {
			return true;
		}else{
			return false;
		}
	}
	
	public int degre(){
		int cpt = 1;
		for(ArbreB ab : sousarbres){
			cpt += ab.degre();
		}
		return cpt;
	}
	
	public ArbreB Union2Tid(ArbreB a){
		if (c.inf(a.getC())){
			ArbreB res =  new ArbreB(c);
			res.getSousarbres().addAll(sousarbres);
			res.getSousarbres().add(a);
			return res;
		}else{
			ArbreB res =  new ArbreB(a.getC());
			res.getSousarbres().addAll(a.getSousarbres());
			res.getSousarbres().add(this);
			return res;
		}
	}
	
	public FileBinomiale decapite(){return new FileBinomiale(sousarbres);}
	
	public FileBinomiale file(){return new FileBinomiale(this);}
	
	public String toString(int i){
		String res = "[Cle : "+c.toString()+", Fils : ";
		int cpt = i;
		if (sousarbres.isEmpty()) return res+"vide ]";
		for(ArbreB fils : sousarbres){
			res += "[Fils "+cpt+": "+fils.toString(cpt++)+"]";
			cpt++;
		}
		return res;
	}
}
