package partie1;

import java.util.ArrayList;
import java.util.List;

public class Cle {
	
	public List<Integer> cle;
	public Cle(int i1, int i2, int i3, int i4) {
		cle = new ArrayList<Integer>(4);
		cle.add(i1);
		cle.add(i2);
		cle.add(i3);
		cle.add(i4);
	}
	public int getSousCle(int index) {return cle.get(index);}
	public int size() {return cle.size();}
}
