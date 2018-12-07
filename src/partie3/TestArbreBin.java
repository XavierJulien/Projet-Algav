package partie3;

import java.util.ArrayList;

import partie1.Cle;

public class TestArbreBin {

	public static void main(String[] args) {
		//Test structure
		/*Cle c0 = new Cle(0,0,0,0);
		Cle c1 = new Cle(0,0,0,1);
		Cle c2 = new Cle(0,0,1,0);
		Cle c3 = new Cle(0,0,1,1);
		Cle c4 = new Cle(0,1,0,0);
		Cle c5 = new Cle(0,1,0,1);
		Cle c6 = new Cle(0,1,1,0);
		Cle c7 = new Cle(0,1,1,1);
		ArbreB b0 = new ArbreB(c0);
		ArbreB b1 = new ArbreB(c1);
		ArbreB b2 = new ArbreB(c2);
		ArbreB b3 = new ArbreB(c3);
		ArbreB b4 = new ArbreB(c4);
		ArbreB b5 = new ArbreB(c5);
		ArbreB b6 = new ArbreB(c6);
		ArbreB b7 = new ArbreB(c7);
		b0.getSousarbres().add(b1);
		b0.getSousarbres().add(b2);
		b0.getSousarbres().add(b4);
		b2.getSousarbres().add(b3);
		b4.getSousarbres().add(b5);
		b4.getSousarbres().add(b6);
		b6.getSousarbres().add(b7);
		System.out.println(b0.toString(1));
		System.out.println(b0.degre());
		System.out.println(b4.degre());*/
		
		//Test Union
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
		c.add(c0);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.add(c7);
		c.add(c8);
		c.add(c9);
		FileBinomiale fb = new FileBinomiale().ConsIter(c);
		System.out.println(fb.toString());
		/*ArbreB b0 = new ArbreB(c0);
		ArbreB b1 = new ArbreB(c1);
		ArbreB b2 = new ArbreB(c2);
		ArbreB b3 = new ArbreB(c3);
		ArbreB b4 = new ArbreB(c4);
		ArbreB b5 = new ArbreB(c5);
		ArbreB b6 = new ArbreB(c6);
		ArbreB b7 = new ArbreB(c7);
		b0.getSousarbres().add(b1);
		b0.getSousarbres().add(b2);
		b2.getSousarbres().add(b3);
		
		b4.getSousarbres().add(b5);
		b4.getSousarbres().add(b6);
		b6.getSousarbres().add(b7);
		ArbreB uni = b0.Union2Tid(b4);
		System.out.println(uni.degre());
		System.out.println(uni.toString(1));*/
		
	}

}
