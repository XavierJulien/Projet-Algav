package partie1;

import java.util.ArrayList;

import partie2.Arbre;

public class MainPartie1 {

	public static void main(String[] args) {
		//Tests
		/*Cle c1 = new Cle(0,1,1,1);
		Cle c2 = new Cle(1,0,0,0);
		Cle c3 = new Cle(0,1,1,1);
		System.out.println("Clé c1 : ["+c1.getSousCle(0)+","+c1.getSousCle(1)+","+c1.getSousCle(2)+","+c1.getSousCle(3)+"]");
		System.out.println("Clé c2 : ["+c2.getSousCle(0)+","+c2.getSousCle(1)+","+c2.getSousCle(2)+","+c2.getSousCle(3)+"]");
		System.out.println("Clé c3 : ["+c3.getSousCle(0)+","+c3.getSousCle(1)+","+c3.getSousCle(2)+","+c3.getSousCle(3)+"]");
		System.out.println("Les clés c1 et c2 sont égales ? "+c1.eg(c2));
		System.out.println("Les clés c1 et c3 sont égales ? "+c1.eg(c3));
		System.out.println("La clé c2 est inférieure à la clé c1 ? "+c2.inf(c1));
		System.out.println("La clé c1 est inférieure à la clé c2 ? "+c1.inf(c2));*/
		//filereader
		Parser p = new Parser();
		ArrayList<Cle> l = p.read("src/data/jeu_1_nb_cles_100.txt");
		System.out.println(l.size());
		Arbre b = new Arbre().ConsIter(l);
		//System.out.println(b.toString());
	}

}
