package partie3;

import java.util.ArrayList;
import java.util.List;

import partie1.Cle;

public class ArbreB {

	private Cle c;
	private ArrayList<ArbreB> sousarbres;
	private int size;
	
	public ArbreB(){
		this.c = null;
		sousarbres = new ArrayList<ArbreB>();
		this.size = 0;
	}
	public ArbreB(Cle c) {
		this.c = c;
		sousarbres = new ArrayList<ArbreB>();
		this.size = 1;
	}
	//getters
	public ArrayList<ArbreB> getSousarbres() {return sousarbres;}
	public Cle getC() {return c;}
	//setters
	public void setSousarbres(ArrayList<ArbreB> sousarbres) {this.sousarbres = sousarbres;}
	public void setC(Cle c) {this.c = c;}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	//primitives
	public Boolean estVide(ArbreB a){
		if(size == 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public int degre(){return sousarbres.size();}
	
	public ArbreB Union2Tid(ArbreB a,ArbreB b){
		if (b.getC().inf(a.getC())){
			ArbreB res =  new ArbreB(b.getC());
			res.getSousarbres().add(0, a);
			res.getSousarbres().addAll(b.getSousarbres());
			return res;
		}else{
			ArbreB res =  new ArbreB(a.getC());
			res.getSousarbres().add(0, b);
			res.getSousarbres().addAll(a.getSousarbres());
			return res;
		}
	}
	
	public FileBinomiale decapite(){return new FileBinomiale(sousarbres);}
	
	public FileBinomiale file(){return new FileBinomiale(this);}
	
	public String toString(){
		String res = "[Cle : "+c.toString()+", Fils : ";
		if (sousarbres.isEmpty()) return res+"vide ]";
		for(ArbreB fils : sousarbres){
			res += fils.toString();
		}
		return res+"]";
	}
	
	public ArbreB toArbreB(List<Cle> cles) {
		if(cles.size() == 1) {
			return new ArbreB(cles.get(0));
		}else {
			int size = cles.size()/2;
			return new ArbreB().Union2Tid(toArbreB(cles.subList(0, size)),toArbreB(cles.subList(size, cles.size())));
		}
	}
}
