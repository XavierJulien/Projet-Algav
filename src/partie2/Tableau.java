package partie2;

import java.util.ArrayList;
import java.util.List;

import partie1.Cle;

public class Tableau {

	//variables 
	public List<Cle> tab;
	
	//Constructeur
	public Tableau(ArrayList<Cle> l) {
		tab = l;
	}
	
	public Cle getElem(int index) {
		return tab.get(index);
	}
	
	public int getTaille() {return tab.size();}
	
	public Cle getFG(int index) {
		try {
			return tab.get(2*index+1);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le noeud n'as pas de fils");
			return null;
		}
	}
	public Cle getFD(int index) {
		try {
			return tab.get(2*index+2);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le noeud n'as pas de fils");
			return null;
		}
	}
	public void SupprMin() { //Supprimer le minimum en O(log n)
		
	}
	
	public void Ajout(Cle c) { //Ajout parmi les cles en O(log n)
		tab.add(c);
		
	}
	
	public void ConsIter(ArrayList<Cle> l) { // Cons en O(n)
		
	}
	
	public Tableau Union(Tableau t1, Tableau t2) {// Union en O(n + m)
		return null;
	}
	public void remontee(Tableau t) {
		int pos =  t.getTaille();
		Cle c2 = t.getElem(pos-1);
		
		
	}
}
