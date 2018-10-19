package partie2;

import java.util.ArrayList;
import java.util.List;

import partie1.Cle;

public class Tableau {

	public List<Cle> tab;
	public Tableau(ArrayList<Cle> l) {
		tab = l;
	}
	
	public Cle getElem(int index) {
		return tab[index];
	}
	
	public Cle getFG(int index) {
		try {
			return tab[2*index+1];
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le noeud n'as pas de fils");
			return null;
		}
	}
	public Cle getFD(int index) {
		try {
			return tab[2*index+2];
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le noeud n'as pas de fils");
			return null;
		}
	}
	public void SupprMin() {
		
	}
	
	public void Ajout(Cle c) {
		
	}
	
	public void ConsIter(ArrayList<Cle> l) {
		
	}
	
	public Tableau Union(Tableau t1, Tableau t2) {
		return new Tableau(new Cle[0]);
	}
}
