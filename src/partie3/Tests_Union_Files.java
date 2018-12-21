package partie3;

import java.util.ArrayList;

import partie1.Cle;
import partie1.Parser;

public class Tests_Union_Files {

	public static void main(String[] args) {
		
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		String[] nbcles = {/*"100","200","500","1000","5000","10000","20000",*/"50000"};
		for(int j = 0;j<nbcles.length;j++) {
			for(int i = 1;i<6;i++) {
				filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_"+nbcles[j]+".txt");
			}
		}
		float tps_total_union_files = 0;
		int cpt = 0;
		FileBinomiale fb = new FileBinomiale();
		FileBinomiale fb2 = new FileBinomiale();
		for(String s : filenames) {
			for(String s2 : filenames) {
				if(s.compareTo(s2) ==  0) continue;
				ArrayList<Cle> l = p.read(s);
				ArrayList<Cle> l2 = p.read(s2);
				fb = fb.ConsIter(l);
				fb2 = fb2.ConsIter(l2);
				FileBinomiale res = new FileBinomiale();
				final long startTimeUnion = System.nanoTime();
				res.union(fb, fb2);
				final long endTimeUnion = System.nanoTime();
				tps_total_union_files += endTimeUnion - startTimeUnion;
				cpt++;
				System.out.println("Union de "+s+" et "+s2+" : "+((endTimeUnion - startTimeUnion)/1000000.0));
			}
		}
		System.out.println("Average execution time for union tree: " + ((tps_total_union_files/1000000.0)/cpt));
	}
}
