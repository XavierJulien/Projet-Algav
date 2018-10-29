package partie2;

import java.util.ArrayList;

import partie1.Cle;

public class Arbre {

	private Noeud racine;
	private int nbElem;
	public Arbre(Noeud racine, int nbElem) {
		this.racine = racine;
		this.nbElem = nbElem;
	}
	
	public Arbre() {
		racine = null;
		nbElem = 0;
	}
	
	public Noeud getRacine() {return racine;}
	
	public int getNbElem() {return nbElem;}
	
	public String toBinary(int n) {
		String bin = Integer.toBinaryString(n);
		if(bin.length() == 1) {
			return bin;//pas de bit de poids fort a retirer
		}else {
			return Integer.toBinaryString(n).substring(1); //retire le bit de poids fort
		}
	}
	public Noeud getLastNode() {
		String path = toBinary(nbElem);
		Noeud node = racine;
		for(char c : path.toCharArray()) {
			if(c == '0') {
				node = node.getFilsG();
			}
			if(c == '1') {
				node = node.getFilsD();
			}
		}
		return node;
	}
	
	public void SupprMin() { //Supprimer la racine en O(log n)
		Noeud last = getLastNode();
		Noeud pere = last.getPere();
		//on met à jour les refs sur les entourants du dernier element
		last.setFilsG(racine.getFilsG());
		last.setFilsD(racine.getFilsD());
		last.setPere(null);
		//on met à jour le fils supprimé du pere
		if(pere.getFilsD() == null) {
			pere.setFilsG(null);
		}else {
			pere.setFilsD(null);
		}
		//on refait descendre le noeud pour equilibrer l'arbre
		System.out.println("la racine est "+last.getCle().toString());
		racine = last;
		last.redescente();
		nbElem--;
	}
	
	public void Ajout(Cle c) { //Ajout parmi les noeud en O(log n)
		nbElem++;
		
		
	}
	
	public void ConsIter(ArrayList<Cle> l) { // Cons en O(n)
		
	}
	
	public Tableau Union(Tableau t1, Tableau t2) {// Union en O(n + m)
		return null;
	}
	
}
