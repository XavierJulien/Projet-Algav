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
	public boolean inf(Cle c2) {//si cle1.In est différent de cle2.In alors on renvoie directement si this.In < c2.In 
		if(this.getSousCle(0) != c2.getSousCle(0)) 
			return this.getSousCle(0) < c2.getSousCle(0);
		if(this.getSousCle(1) != c2.getSousCle(1))
			return this.getSousCle(1) < c2.getSousCle(1);
		if(this.getSousCle(2) != c2.getSousCle(2))
			return this.getSousCle(2) < c2.getSousCle(2);
		return this.getSousCle(3) < c2.getSousCle(3);
	}
	
	public boolean eg(Cle c2) {//on verifie si tous les entiers des clés sont égaux
		if(this.getSousCle(0) == c2.getSousCle(0)) {
			if(this.getSousCle(1) == c2.getSousCle(1)) {
				if(this.getSousCle(2) == c2.getSousCle(2)) {
					return (this.getSousCle(3) == c2.getSousCle(3));
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		return "["+cle.get(0)+","+cle.get(1)+","+cle.get(2)+","+cle.get(3)+"]";
	}
}
