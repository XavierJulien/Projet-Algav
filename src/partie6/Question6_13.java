package partie6;

import java.io.File;
import java.util.ArrayList;

import partie4.ParserMD5;


public class Question6_13{

	public static void main(String[] args){

		ParserMD5 p = new ParserMD5();
		String repoName = "src/data/Shakespeare/";
		File repo = new File(repoName);
		String[] res = repo.list();
		ArrayList<String> l_distinct_md5 = new ArrayList<>();
		ArrayList<String> l_distinct_word = new ArrayList<>();
		
		for(int i = 0;i<res.length;i++) {
			System.out.println(repoName+res[i]);
			ArrayList<String> l = p.read(repoName+res[i]);
			ArrayList<String> l_md5 = p.readMD5(repoName+res[i]);
			for(int j = 0;j<l_md5.size();j++) {
				if(!l_distinct_word.contains(l.get(j)))	l_distinct_word.add(l.get(j));
				if(!l_distinct_md5.contains(l_md5.get(j))) l_distinct_md5.add(l_md5.get(j));
			}
		}
		System.out.println("nb collisions : "+(l_distinct_word.size()-l_distinct_md5.size()));
	}

}
