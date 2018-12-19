package partie1;

import java.util.ArrayList;

import partie1.Cle;
import partie1.Parser;
import partie2.Arbre;
import partie2.Tableau;

public class Tests {

	public static void main(String[] args) {
	
		Arbre b = new Arbre();
		Tableau t = new Tableau();
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		String[] nbcles = {"100","200","500","1000","5000","10000","20000","50000"};
		for(int j = 0;j<nbcles.length;j++) {
			for(int i = 1;i<6;i++) {
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_"+nbcles[j]+".txt");
			}
		}
		float tps_total_arbre = 0;
		float tps_total_tableau = 0;
		int cpt = 0;
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeArbre = System.nanoTime();
			b.ConsIter(l);
			final long endTimeArbre = System.nanoTime();
			tps_total_arbre += endTimeArbre - startTimeArbre;
			cpt++;
			System.out.println(s+" : "+((endTimeArbre - startTimeArbre)/1000000.0));
		}
		System.out.println();
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeTableau = System.nanoTime();
			t.ConsIter(l);
			final long endTimeTableau = System.nanoTime();
			tps_total_tableau += endTimeTableau - startTimeTableau;
			cpt++;
			System.out.println(s+" : "+((endTimeTableau - startTimeTableau)/1000000.0));
		}
		System.out.println("Average execution time for tree: " + ((tps_total_arbre/1000000.0)/cpt));
		System.out.println("Average execution time for table: " + ((tps_total_tableau/1000000.0)/cpt));
	}

}