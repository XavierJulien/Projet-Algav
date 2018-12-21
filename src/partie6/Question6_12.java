package partie6;

import java.io.File;
import java.util.ArrayList;

import partie1.Cle;
import partie4.ParserMD5;
import partie5.AVLTree;

public class Question6_12{

	public static void main(String[] args){
		//Tests Basiques
		//MD5 m = new MD5();
		//System.out.println(m.md5("The quick brown fox jumps over the lazy dog".getBytes()));
		//Test a faire sur Shakespeare
		ParserMD5 p = new ParserMD5();
		String repoName = "src/data/Shakespeare/";
		File repo = new File(repoName);
		String[] res = repo.list();
		ArrayList<Cle> l_cle = new ArrayList<>();
		ArrayList<String> l_distinct_word = new ArrayList<>();
		
		for(int i = 0;i<res.length;i++) {
			System.out.println(repoName+res[i]);
			ArrayList<String> l_md5 = p.readMD5(repoName+res[i]);
			for(int j = 0;j<l_md5.size();j++) {
				if(!l_distinct_word.contains(l_md5.get(j))) {
					l_distinct_word.add(l_md5.get(j));
					l_cle.add(p.decoder(l_md5.get(j)));
				}
			}
		}
		AVLTree avl = new AVLTree(l_cle.get(0));
		
		for(int i = 1;i<l_cle.size();i++) {
			avl = avl.ajout(avl, l_cle.get(i));
		}
		//donner la clé que vous chercher , si c'est en md5 , alors faire avl.recherche(avl, l_cle.get(p.decoder(m.md5("phrase à entrer"))))
		System.out.println(avl.recherche(avl, l_cle.get(10000)));
	}

}
