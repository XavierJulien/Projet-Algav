package partie1;

import java.util.ArrayList;

import partie2.Arbre;

public class Tests_Moyenne_Arbre {

	

	public static void main(String[] args) {
		
		float tps_total_arbre = 0;
		int cpt = 0;
		Arbre b = new Arbre();
		Parser p = new Parser();
		ArrayList<Arbre> list_arbres = new ArrayList<>();
		ArrayList<String> filenames = new ArrayList<String>();
		
		for(int j = 0;j<200;j++) {
			for(int i = 1;i<6;i++) {
				filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_100.txt");//changer le nombre de clés
			}
		}
		
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeArbre = System.nanoTime();
			b.ConsIter(l);
			final long endTimeArbre = System.nanoTime();
			tps_total_arbre += endTimeArbre - startTimeArbre;
			cpt++;
			System.out.println(s+" : "+((endTimeArbre - startTimeArbre)/1000000000.0));
			list_arbres.add(b);
		}
		System.out.println("Average execution time for tree: " + ((tps_total_arbre)/1000000.0)/cpt);
	}

}