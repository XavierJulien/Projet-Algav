package partie4;

import java.util.ArrayList;

import partie1.Cle;

public class TestMD5{

	public static void main(String[] args){
		MD5 m = new MD5();
		//System.out.println(m.md5("The quick brown fox jumps over the lazy dog".getBytes()));
		//Test a faire sur Shakespeare
		Parser p = new Parser();
		ArrayList<Cle> l = p.read("src/data/Shakespeare/1henryiv.txt");
		System.out.println(l.size());
	}

}
