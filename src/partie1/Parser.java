package partie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	
	public Parser() {
	}
	public int nblignes = 0;
	public ArrayList<Cle> read(String filename) {
		ArrayList<Cle> l = new ArrayList<Cle>();
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line=br.readLine()) != null) {
				//System.out.println(line);
				Cle c = decoder(line);
				l.add(c);
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