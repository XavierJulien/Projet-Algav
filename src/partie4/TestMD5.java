package partie4;

import java.util.ArrayList;

import partie1.Cle;
import partie3.FileBinomiale;

public class TestMD5{

	public static void main(String[] args){
		MD5 m = new MD5();
		System.out.println(m.md5("The quick brown fox jumps over the lazy dog".getBytes()));
		//Test a faire sur Shakespeare
		ParserMD5 p = new ParserMD5();
		ArrayList<Cle> l = p.read("src/data/Shakespeare/1henryiv.txt");
		FileBinomiale fb = new FileBinomiale();
		fb = fb.ConsIter(l);
		System.out.println(fb.getArbres().size());
	}

}
