package partie3;

import java.util.ArrayList;

import partie1.Cle;
import partie1.Parser;

public class Tests_Moyenne_Union_File {

	

	public static void main(String[] args) {
	
		FileBinomiale fb = new FileBinomiale();
		//Arbre b2 = new Arbre();
		
		Parser p = new Parser();
		ArrayList<String> filenames = new ArrayList<String>();
		for(int i = 1;i<6;i++) {
			filenames.add("src/data/cles_alea/jeu_"+i+"_nb_cles_50000.txt");
		}
		
		float tps_total_FileBin = 0;
		int cpt = 0;
		ArrayList<FileBinomiale> list_files = new ArrayList<>();
	
		for(String s : filenames) {
			ArrayList<Cle> l = p.read(s);
			final long startTimeFile = System.nanoTime();
			fb = fb.ConsIter(l);
			final long endTimeFile = System.nanoTime();
			tps_total_FileBin += endTimeFile - startTimeFile;
			cpt++;
			System.out.println(s+" : "+((endTimeFile - startTimeFile)/1000000000.0));
			list_files.add(fb);
		}
		/*for(String s : filenames) {
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
				System.out.println("Union de "+s+" et "+s2+" : "+((endTimeUnion - startTimeUnion)/1000000.0));
			}
		}*/
		System.out.println("Average execution time for tree: " + ((tps_total_FileBin)/1000000.0)/cpt);
		//System.out.println("Average execution time for tree: " + ((tps_total_union_arbres)/1000000.0)/cpt);
	}

}