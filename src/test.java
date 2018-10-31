import java.util.ArrayList;

import partie1.Cle;
import partie2.Arbre;
import partie2.Noeud;

public class test {

	public static void main(String[] args) {
		
		//Construction de l'arbre a1
		Cle c1 = new Cle(0,0,0,1);
		Cle c2 = new Cle(0,0,1,0);
		Cle c3 = new Cle(0,0,1,1);
		Cle c4 = new Cle(0,1,0,0);
		Cle c5 = new Cle(0,1,0,1);
		Cle c6 = new Cle(0,1,1,0);
		Cle c7 = new Cle(0,1,1,1);
		ArrayList<Cle> lc1 = new ArrayList<Cle>();
		lc1.add(c7);
		lc1.add(c6);
		lc1.add(c5);
		lc1.add(c4);
		lc1.add(c3);
		lc1.add(c2);
		lc1.add(c1);
		Arbre a = new Arbre().ConsIter(lc1);
		System.out.println(a.toString());
		//Construction de l'arbre a2
		Cle c8 = new Cle(1,0,0,0);
		Cle c9 = new Cle(1,0,0,1);
		Cle c10 = new Cle(1,0,1,0);
		ArrayList<Cle> lc2 = new ArrayList<Cle>();
		lc2.add(c10);
		lc2.add(c9);
		lc2.add(c8);
		Arbre a2 = new Arbre().ConsIter(lc2);
		System.out.println(a2.toString());
		a.Union(a, a2);
		// Check SupprMin
		//System.out.println(a.getLastNode().getCle().toString());
		//a.SupprMin();
		//System.out.println("racine"+a.getRacine().getCle().toString());
		//System.out.println("sous-racie"+a.getRacine().getFilsD().getCle().toString());
		//System.out.println(a.getLastNode().getCle().toString());
		
		// Check Ajout
		// a.Ajout(new Cle(1,0,0,0));
		
		// Check ConsIter
		/*ArrayList<Cle> lc = new ArrayList<Cle>();
		lc.add(c4);
		lc.add(c3);
		lc.add(c2);
		lc.add(c1);
		Arbre a2 = new Arbre().ConsIter(lc);
		//Arbre a2= new Arbre(new Noeud(new Cle(1,0,0,0),null,null,null),1);
		Arbre b = a.Union(a, a2);
		//System.out.println(b.toString());*/
	}

}
