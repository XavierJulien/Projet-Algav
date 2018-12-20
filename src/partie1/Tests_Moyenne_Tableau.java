package partie1;

import java.util.ArrayList;

import partie2.Tableau;

public class Tests_Moyenne_Tableau {

	public static void main(String[] args) {
	
		Tableau b = new Tableau();
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		for(int i = 1;i<6;i++) {
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_50000.txt");
		}
		float tps_total_tableau = 0;
		int cpt = 0;
		ArrayList<Tableau> list_tableau = new ArrayList<>();
	
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			float startTimeTableau = System.nanoTime();
			b.ConsIter(l);
			float endTimeTableau = System.nanoTime();
			tps_total_tableau += endTimeTableau - startTimeTableau;
			cpt++;
			System.out.println(s+" : "+((endTimeTableau - startTimeTableau)/1000000000.0));
			list_tableau.add(b);
		}
		/*for(int i = 0;i<list_tab.size()-1;i++) {
			for(int j = 1;j<list_tab.size();j++) {
				System.out.println(list_tab.get(i).getTaille());
				float startTimeUnion = System.nanoTime();
				Tableau temp = new Tableau().Union(list_tab.get(i), list_tab.get(j));
				float endTimeUnion = System.nanoTime();
				System.out.println("temps : "+((endTimeUnion-startTimeUnion)/1000000000.0));
			}
		}*/
		System.out.println("Average execution time for tree: " + ((tps_total_tableau)/1000000000.0)/cpt);
	}

}