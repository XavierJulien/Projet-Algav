package partie1;

import java.util.ArrayList;

import partie2.Tableau;

public class Tests_Union_Tableaux {

	public static void main(String[] args) {
		
		float tps_total_union_tableaux = 0;
		int cpt = 0;
		Tableau t = new Tableau();
		Tableau t2 = new Tableau();
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		String[] nbcles = {/*"100","200","500","1000","5000","10000","20000",*/"50000"};
		for(int j = 0;j<nbcles.length;j++) {
			for(int i = 1;i<6;i++) {
				filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_"+nbcles[j]+".txt");
			}
		}
		
		for(String s : filenames) {
			for(String s2 : filenames) {
				if(s.compareTo(s2) ==  0) continue;
				ArrayList<Cle> l = p.read(s);
				ArrayList<Cle> l2 = p.read(s2);
				t = t.ConsIter(l);
				t2 = t2.ConsIter(l2);
				Tableau res = new Tableau();
				final long startTimeUnion = System.nanoTime();
				res.Union(t, t2);
				final long endTimeUnion = System.nanoTime();
				tps_total_union_tableaux += endTimeUnion - startTimeUnion;
				cpt++;
				System.out.println("Union de "+s+" et "+s2+" : "+((endTimeUnion - startTimeUnion)/1000000.0));
			}
		}
		System.out.println("Average execution time for union tree: " + ((tps_total_union_tableaux/1000000.0)/cpt));
	}
}
