package partie6;

import java.util.ArrayList;

import partie1.Cle;
import partie1.Parser;
import partie2.Tableau;
import partie3.FileBinomiale;

public class Question6_14 {

	public static void main(String[] args) {
	
		FileBinomiale fb = new FileBinomiale();
		Tableau t = new Tableau();
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		for(int j = 0;j<200;j++) {
			for(int i = 1;i<6;i++) {
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_1000.txt");
			}
		}
		float tps_total_files = 0;
		float tps_total_tableau = 0;
		int cpt = 0;
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			fb = fb.ConsIter(l);
			t = t.ConsIter(l);
			Cle min = new Cle(999999999,999999999,999999999,999999999);
			final long startTimeFile = System.nanoTime();
			fb.Ajout(min);
			final long endTimeFile = System.nanoTime();
			final long startTimeTableau = System.nanoTime();
			t.Ajout(min);
			final long endTimeTableau = System.nanoTime();
			tps_total_files += endTimeFile - startTimeFile;
			tps_total_tableau += endTimeTableau - startTimeTableau;
			cpt++;
			System.out.println(s+" \n file : "+((endTimeFile - startTimeFile)/1000000.0)+"\n tableau : "+((endTimeTableau - startTimeTableau)/1000000.0));
		}
		
		System.out.println("Average execution time for file: " + ((tps_total_files)/1000000.0)/cpt);
		System.out.println("Average execution time for table: " + ((tps_total_tableau)/1000000.0)/cpt);
	}

}