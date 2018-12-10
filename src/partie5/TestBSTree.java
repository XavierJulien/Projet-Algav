package partie5;

import java.util.ArrayList;

import partie1.Cle;

public class TestBSTree {

	public static void main(String[] args) {
		Cle c0 = new Cle(0,0,0,0);
		Cle c1 = new Cle(0,0,0,1);
		Cle c2 = new Cle(0,0,1,0);
		Cle c3 = new Cle(0,0,1,1);
		Cle c4 = new Cle(0,1,0,0);
		Cle c5 = new Cle(0,1,0,1);
		Cle c6 = new Cle(0,1,1,0);
		Cle c7 = new Cle(0,1,1,1);
		Cle c8 = new Cle(1,0,0,0);
		Cle c9 = new Cle(1,0,0,1);
		ArrayList<Cle> c = new ArrayList<>();
		c.add(c2);
		c.add(c1);
		c.add(c0);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.add(c7);
		c.add(c8);
		c.add(c9);
		
		BSTree b = new BSTree(c.get(0));

	}

}
