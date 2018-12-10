package partie5;

import partie1.Cle;

public class BSTree {
	
	private Cle c;
	private BSTree fGauche;
	private BSTree fDroit;
	
	public BSTree(Cle c) {
		this.c = c;
		fGauche = null;
		fDroit = null;
	}
	
	public Cle getC() {
		return c;
	}
	public BSTree getfGauche() {
		return fGauche;
	}
	public BSTree getfDroit() {
		return fDroit;
	}
	public void setC(Cle c) {
		this.c = c;
	}
	public void setfGauche(BSTree fGauche) {
		this.fGauche = fGauche;
	}
	public void setfDroit(BSTree fDroit) {
		this.fDroit = fDroit;
	}
	
	public boolean recherche(BSTree b, Cle k) {
		if(b==null) return false;
		if (b.getC().equals(k)) {
			return true;
		}else {
			if(c.inf(k)) {
				recherche(b.getfGauche(), k);
			}else {
				recherche(b.getfDroit(), k);
			}
		}
		return false;
	}
}
