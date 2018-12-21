package partie1;

import java.util.ArrayList;

import partie1.Cle;
import partie1.Parser;
import partie2.Tableau;

public class Tests_Moyenne_Tableau {

	public static void main(String[] args) {

		float tps_total_tableau = 0;
		int cpt = 0;
		Tableau t = new Tableau();
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		
		for(int j = 0;j<200;j++) {
			for(int i = 1;i<6;i++) {
				filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_100.txt");//changer le nombre de clés
			}
		}

		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeTableau = System.nanoTime();
			t = t.ConsIter(l);
			final long endTimeTableau = System.nanoTime();
			tps_total_tableau += endTimeTableau - startTimeTableau;
			cpt++;
			System.out.println(s+" : "+((endTimeTableau - startTimeTableau)/1000000.0));
		}
		
		System.out.println("Average execution time for table: " + ((tps_total_tableau/1000000.0)/cpt));
	}

}