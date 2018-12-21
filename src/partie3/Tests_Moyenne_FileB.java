package partie3;

import java.util.ArrayList;

import partie1.Cle;
import partie1.Parser;

public class Tests_Moyenne_FileB {

	public static void main(String[] args) {
	
		FileBinomiale fb = new FileBinomiale();
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		String[] nbcles = {/*"100","200","500","1000","5000","10000","20000",*/"50000"};
		for(int j = 0;j<200;j++) {
			for(int i = 1;i<6;i++) {
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_"+nbcles[0]+".txt");
			}
		}
		float tps_total_arbre = 0;
		int cpt = 0;
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeFile = System.nanoTime();
			fb.ConsIter(l);
			final long endTimeFile = System.nanoTime();
			tps_total_arbre += endTimeFile - startTimeFile;
			cpt++;
			System.out.println(s+" : "+((endTimeFile - startTimeFile)/1000000.0));
		}
		System.out.println("Average execution time for tree: " + ((tps_total_arbre)/100000.0)/cpt);
	}

}