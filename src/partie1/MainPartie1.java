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
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_50000.txt");
		}
		long tps_total_arbre = 0;
		long tps_total_tableau = 0;
		int cpt = 0;
		ArrayList<Arbre> list_arbres = new ArrayList<>();
		ArrayList<Tableau> list_tab = new ArrayList<>();
	
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeArbre = System.currentTimeMillis();
			b = b.ConsIter(l);
			final long endTimeArbre = System.currentTimeMillis();
			final long startTimeTableau = System.currentTimeMillis();
			t = t.ConsIter(l);
			final long endTimeTableau = System.currentTimeMillis();
			tps_total_arbre += endTimeArbre - startTimeArbre;
			tps_total_tableau += endTimeTableau - startTimeTableau;
			cpt++;
			list_arbres.add(b);
			list_tab.add(t);
		}
		for(int i = 0;i<list_tab.size()-1;i++) {
			for(int j = 1;j<list_tab.size();j++) {
				System.out.println(list_tab.get(i).getTaille());
				float startTimeUnion = System.nanoTime();
				Tableau temp = new Tableau().Union(list_tab.get(i), list_tab.get(j));
				float endTimeUnion = System.nanoTime();
				System.out.println("temps : "+((endTimeUnion-startTimeUnion)/1000000000.0));
			}
		}
		System.out.println("Average execution time for tree: " + (tps_total_arbre/cpt));
		System.out.println("Average execution time for table: " + (tps_total_tableau/cpt));
	}

}