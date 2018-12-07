package partie1;

import java.util.ArrayList;

import partie2.Arbre;
import partie2.Tableau;

public class MainPartie1 {

	public static void main(String[] args) {
	
		Arbre b = new Arbre();
		Tableau t = new Tableau();
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		for(int i = 1;i<6;i++) {
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_10000.txt");
		}
		long tps_total_arbre = 0;
		long tps_total_tableau = 0;
		int cpt = 0;
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeArbre = System.currentTimeMillis();
			b.ConsIter(l);
			final long endTimeArbre = System.currentTimeMillis();
			final long startTimeTableau = System.currentTimeMillis();
			t.ConsIter(l);
			final long endTimeTableau = System.currentTimeMillis();
			tps_total_arbre += endTimeArbre - startTimeArbre;
			tps_total_tableau += endTimeTableau - startTimeTableau;
			cpt++;
		}
		System.out.println("Average execution time for tree: " + (tps_total_arbre/cpt));
		System.out.println("Average execution time for table: " + (tps_total_tableau/cpt));
	}

}