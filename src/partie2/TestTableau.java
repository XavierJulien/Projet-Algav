package partie2;
import java.util.ArrayList;

import partie1.Cle;

public class TestTableau {

	public static void main(String[] args) {
		
		//Construction de l'arbre a1
		Cle c1 = new Cle(0,0,0,1);
		Cle c2 = new Cle(0,0,1,0);
		Cle c3 = new Cle(0,0,1,1);
		Cle c4 = new Cle(0,1,0,0);
		Cle c5 = new Cle(0,1,0,1);
		Cle c6 = new Cle(0,1,1,0);
		Cle c7 = new Cle(0,1,1,1);
		/*
		ArrayList<Cle> lc1 = new ArrayList<Cle>();
		lc1.add(c1);
		lc1.add(c2);
		lc1.add(c3);
		lc1.add(c4);
		lc1.add(c5);
		lc1.add(c6);
		lc1.add(c7);
		Tableau t1 = new Tableau(lc1);*/
		//System.out.println(t1.toString());
		//t1.SupprMin();
		//System.out.println(t1.toString());
		//t1.Ajout(new Cle(0,1,0,0));
		//System.out.println(t1.toString());
		//t1.Ajout(new Cle(1,0,0,0));
		//System.out.println(t1.toString());
		ArrayList<Cle> lc2 = new ArrayList<Cle>();
		lc2.add(c7);
		lc2.add(c6);
		lc2.add(c5);
		lc2.add(c4);
		lc2.add(c3);
		lc2.add(c2);
		lc2.add(c1);
		System.out.println(lc2.toString());
		Tableau t2 = new Tableau().ConsIter(lc2);
		System.out.println(t2.toString());
		/*Construction de l'arbre a2
		Cle c8 = new Cle(1,0,0,0);
		Cle c9 = new Cle(1,0,0,1);
		Cle c10 = new Cle(1,0,1,0);
		ArrayList<Cle> lc2 = new ArrayList<Cle>();
		lc2.add(c10);
		lc2.add(c9);
		lc2.add(c8);
		Tableau t2 = new Tableau(lc2);
		//t2.SupprMin();
		*/
		
	}

}
