package partie5;

import partie1.Cle;

public class AVLTree {
	
	private Cle c;
	private AVLTree fGauche;
	private AVLTree fDroit;
	private int height;
	
	public AVLTree(Cle c) {
		this.c = c;
		fGauche = null;
		fDroit = null;
		height = 1;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Cle getC() {
		return c;
	}
	public AVLTree getfGauche() {
		return fGauche;
	}
	public AVLTree getfDroit() {
		return fDroit;
	}
	public void setC(Cle c) {
		this.c = c;
	}
	public void setfGauche(AVLTree fGauche) {
		this.fGauche = fGauche;
	}
	public void setfDroit(AVLTree fDroit) {
		this.fDroit = fDroit;
	}
	
	public AVLTree ajout(AVLTree a,Cle c) {
		if(a == null) return new AVLTree(c);
		if(a.getC().inf(c)) {
			a.setfDroit(ajout(a.getfDroit(),c));
		}else {
			if(!a.getC().equals(c)) {
				a.setfGauche(ajout(a.getfGauche(),c));	
			}else {
				return a;
			}
		}
		a.setHeight(a.getHeight()+1);
		return a;
	}

	public boolean recherche(AVLTree b, Cle k) {
		if(b==null) return false;
		if (b.getC().equals(k)) {
			return true;
		}else {
			if(c.inf(k)) {
				return recherche(b.getfGauche(), k);
			}else {
				return recherche(b.getfDroit(), k);
			}
		}
	}
}
