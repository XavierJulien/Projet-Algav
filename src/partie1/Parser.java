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
	
	public ArrayList<Cle> read(String filename) {
		ArrayList<Cle> l = new ArrayList<Cle>();
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line=br.readLine()) != null) {
				System.out.println(line.length());
				String s1 = line.substring(2, 9);
				String s2 = line.substring(10, 17);
				String s3 = line.substring(18, 25);
				String s4 = line.substring(26, 33);
				int i1 = Integer.decode("0x"+s1);
				int i2 = Integer.decode("0x"+s2);
				int i3 = Integer.decode("0x"+s3);
				int i4 = Integer.decode("0x"+s4);
				Cle c = new Cle(i1, i2, i3, i4);
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
}
