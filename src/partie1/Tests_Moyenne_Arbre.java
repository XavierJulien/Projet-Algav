package partie1;

import java.util.ArrayList;

import partie2.Arbre;

public class Tests_Moyenne_Arbre {

	

	public static void main(String[] args) {
	
		Arbre b = new Arbre();
		Arbre b2 = new Arbre();
		
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		for(int i = 1;i<6;i++) {
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_500.txt");
		}
		//float tps_total_arbre = 0;
		float tps_total_union_arbres = 0;
		int cpt = 0;
		//ArrayList<Arbre> list_arbres = new ArrayList<>();
	
		/*for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeArbre = System.nanoTime();
			b.ConsIter(l);
			final long endTimeArbre = System.nanoTime();
			tps_total_arbre += endTimeArbre - startTimeArbre;
			cpt++;
			System.out.println(s+" : "+((endTimeArbre - startTimeArbre)/1000000000.0));
			list_arbres.add(b);
		}*/
		for(String s : filenames) {
			for(String s2 : filenames) {
				if(s.compareTo(s2) ==  0) continue;
				ArrayList<Cle> l = p.read(s);
				ArrayList<Cle> l2 = p.read(s2);
				b = b.ConsIter(l);
				b2 = b2.ConsIter(l2);
				Arbre res = new Arbre();
				final float startTimeUnion = System.nanoTime();
				res.Union(b, b2);
				final float endTimeUnion = System.nanoTime();
				tps_total_union_arbres += endTimeUnion - startTimeUnion;
				cpt++;
				System.out.println("Union de "+s+" et "+s2+" : "+((endTimeUnion - startTimeUnion)));
			}
		}
		//System.out.println("Average execution time for tree: " + ((tps_total_arbre)/1000000.0)/cpt);
		System.out.println("Average execution time for tree: " + ((tps_total_union_arbres)/1000000.0)/cpt);
	}

}