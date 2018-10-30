import java.util.ArrayList;

import partie1.Cle;
import partie2.Arbre;
import partie2.Noeud;

public class test {

	public static void main(String[] args) {
		
		Cle c1 = new Cle(0,0,0,1);
		Cle c2 = new Cle(0,0,1,0);
		Cle c3 = new Cle(0,0,1,1);
		Cle c4 = new Cle(0,1,0,0);
		Cle c5 = new Cle(0,1,0,1);
		Cle c6 = new Cle(0,1,1,0);
		Cle c7 = new Cle(0,1,1,1);
		Noeud n1 = new Noeud(c1,null,null,null);
		Noeud n2 = new Noeud(c2,n1,null,null);
		Noeud n3 = new Noeud(c3,n1,null,null);
		Noeud n4 = new Noeud(c4,n2,null,null);
		Noeud n5 = new Noeud(c5,n2,null,null);
		Noeud n6 = new Noeud(c6,n3,null,null);
		Noeud n7 = new Noeud(c7,n3,null,null);
		n1.setFilsG(n3);
		n1.setFilsD(n2);
		n2.setFilsG(n4);
		n2.setFilsD(n5);
		n3.setFilsG(n7);
		n3.setFilsD(n6);

		Arbre a = new Arbre(n1,7);
		// Check SupprMin
		//System.out.println(a.getLastNode().getCle().toString());
		//a.SupprMin();
		//System.out.println("racine"+a.getRacine().getCle().toString());
		//System.out.println("sous-racie"+a.getRacine().getFilsD().getCle().toString());
		//System.out.println(a.getLastNode().getCle().toString());
		
		// Check Ajout
		// a.Ajout(new Cle(1,0,0,0));
		
		// Check ConsIter
		ArrayList<Cle> lc = new ArrayList<Cle>();
		lc.add(c1);
		lc.add(c2);
		lc.add(c3);
		Arbre a2 = new Arbre().ConsIter(lc);
		System.out.println(a2.toString());
		//Arbre a2= new Arbre(new Noeud(new Cle(1,0,0,0),null,null,null),1);
		//Arbre b = a.Union(a, a2);
	}

}
