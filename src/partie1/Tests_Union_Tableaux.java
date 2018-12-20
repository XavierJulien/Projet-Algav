package partie1;

import java.util.ArrayList;

import partie2.Tableau;

public class Tests_Union_Tableaux {

	public static void main(String[] args) {
		
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		String[] nbcles = {"100","200","500","1000","5000","10000","20000","50000"};
		for(int j = 0;j<nbcles.length;j++) {
			for(int i = 1;i<6;i++) {
				filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_"+nbcles[j]+".txt");
			}
		}
		float tps_total_union_arbres = 0;
		int cpt = 0;
		Tableau b = new Tableau();
		Tableau b2 = new Tableau();
		for(String s : filenames) {
			for(String s2 : filenames) {
				if(s.compareTo(s2) ==  0) continue;
				ArrayList<Cle> l = p.read(s);
				ArrayList<Cle> l2 = p.read(s2);
				b = b.ConsIter(l);
				b2 = b2.ConsIter(l2);
				Tableau res = new Tableau();
				final long startTimeUnion = System.nanoTime();
				res.Union(b, b2);
				final long endTimeUnion = System.nanoTime();
				tps_total_union_arbres += endTimeUnion - startTimeUnion;
				cpt++;
				System.out.println("Union de "+s+" et "+s2+" : "+((endTimeUnion - startTimeUnion)/1000000.0));
			}
		}
		System.out.println("Average execution time for union tree: " + ((tps_total_union_arbres/1000000.0)/cpt));
	}
}
