package partie4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import partie1.Cle;

public class ParserMD5 {
	
	public ParserMD5() {
	}
	private MD5 m = new MD5();
	public int nblignes = 0;
	public ArrayList<String> readMD5(String filename) {
		ArrayList<String> l = new ArrayList<>();
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line=br.readLine()) != null) {
				String line_key = m.md5(line.getBytes());
				l.add(line_key);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public ArrayList<String> read(String filename) {
		ArrayList<String> l = new ArrayList<>();
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line=br.readLine()) != null) {
				l.add(line);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public Cle decoder(String line) {
		String s = line.substring(2);
		while(s.length()<32) {
			s = "0"+s;
		}
		String s1,s2,s3,s4;
		int i1,i2,i3,i4;
		Cle c = null;
			s1 = s.substring(0, 7);
			s2 = s.substring(8, 15);
			s3 = s.substring(16, 23);
			s4 = s.substring(24, 31);
			i1 = Integer.decode("0x"+s1);
			i2 = Integer.decode("0x"+s2);
			i3 = Integer.decode("0x"+s3);
			i4 = Integer.decode("0x"+s4);
			
			c = new Cle(i1, i2, i3, i4);
			return c;
	}
}