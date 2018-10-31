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
	
	public Noeud getPereFirstNullNode() {
		String path = toBinary(nbElem+1);
		String pathPere = path.substring(0, path.length()-1);
		System.out.println("fils : "+path+",pere : "+pathPere);
		Noeud node = racine;
		for(char c : pathPere.toCharArray()) {
			if(c == '0') {
				node = node.getFilsG();
			}
			if(c == '1') {
				node = node.getFilsD();
			}
		}
		return node;
	}
	                                 
	public ArrayList<Cle> ParcoursPrefixe(Noeud n) {
		ArrayList<Cle> ln = new ArrayList<Cle>();
		ln.add(n.getCle());
		if (n.getFilsG() != null)
		    ln.addAll(ParcoursPrefixe(n.getFilsG()));
		if (n.getFilsD() != null)
		    ln.addAll(ParcoursPrefixe(n.getFilsD()));
		return ln;
	    }
	
	public void SupprMin() { //Supprimer la racine en O(log n)
		Noeud last = getLastNode();
		Noeud pere = last.getPere();
		//on met � jour les refs sur les entourants du dernier element
		last.setFilsG(racine.getFilsG());
		last.setFilsD(racine.getFilsD());
		last.setPere(null);
		//on met � jour le fils supprim� du pere
		if(pere.getFilsD() == null) {
			pere.setFilsG(null);
		}else {
			pere.setFilsD(null);
		}
		//on refait descendre le noeud pour equilibrer l'arbre
		//System.out.println("la racine est "+last.getCle().toString());
		racine = last;
		last.redescente();
		nbElem--;
	}
	
	public void Ajout(Cle c) { //Ajout parmi les noeud en O(log n)
		//On va chercher le pere
		Noeud pere = getPereFirstNullNode();
		//System.out.println(pere.getCle().toString());
		if(pere.getFilsG()==null) {
			pere.setFilsG(new Noeud(c,pere,null,null));
		}else {
			pere.setFilsD(new Noeud(c,pere,null,null));
		}
		nbElem++;
	}
	
	public Arbre ConsIter(ArrayList<Cle> l) { // Cons en O(n)
		ArrayList<Noeud> listNode = new ArrayList<Noeud>();
		//premier parcours pour créer la liste de noeuds
		for(int i = 0;i<l.size();i++){
			listNode.add(new Noeud(l.get(i)));
		}
		int size = listNode.size();
		//deuxième parcours pour faire les relations de parentés entre les noeuds
		for(int i = 0;i<size;i++) {
			System.out.println(listNode.get(i).getCle().toString());
			if(((i*2)+1)<size)
				listNode.get(i).setFilsG(listNode.get((i*2)+1));
			if(((i*2)+2)<size)
			listNode.get(i).setFilsD(listNode.get((i*2)+2));
			if(i != 0)
			listNode.get(i).setPere(listNode.get((i-1)/2));
		}
		System.out.println(size);
		for(int i = (size/2)-1;i>=0;i--){
			listNode.get(i).redescente();
		}
		
		return new Arbre(listNode.get(0),listNode.size());
	}
	
	public Arbre Union(Arbre a1, Arbre a2) {// Union en O(n + m)
		ArrayList<Cle> la1 = ParcoursPrefixe(a1.getRacine());
		ArrayList<Cle> la2 = ParcoursPrefixe(a2.getRacine());
		ArrayList<Cle> la = new ArrayList<Cle>(la1);
		la.addAll(la2);
		Arbre a = ConsIter(la);
		System.out.println(a.toString());
		//ParcoursPrefixeRedescente(a.getRacine());
		return a;
	}
	
	public String toString() {
		return "["+racine.getCle().toString()+","+racine.getFilsG().toString()+","+racine.getFilsD().toString()+"]";
		
	}
}
