package partie5;

import partie1.Cle;

public class AVLTree {

	private Cle c;
	private AVLTree filsG;
	private AVLTree pere;
	private AVLTree filsD;

	public AVLTree(Cle c) {
		this.c = c;
		filsG = null;
		filsD = null;
	}

	//getters and setters
	public Cle getC() {return c;}
	public AVLTree getfilsG() {return filsG;}
	public AVLTree getfilsD() {return filsD;}
	public AVLTree getPere() {return pere;}
	public void setC(Cle c) {this.c = c;}
	public void setPere(AVLTree pere) {this.pere = pere;}
	public void setfilsG(AVLTree filsG) {this.filsG = filsG;}
	public void setfilsD(AVLTree filsD) {this.filsD = filsD;}

	public int getHeight() {
		if(this.getfilsD() == null && this.getfilsG() == null) {
			return 1;
		}
		if(this.getfilsD() == null && this.getfilsG() != null) {
			return 1 + filsG.getHeight();
		}
		if(this.getfilsG() == null && this.getfilsD() != null) {
			return 1 + filsD.getHeight();
		}else {
			return 1 + Math.max(filsG.getHeight(), filsD.getHeight());
		}
	}

	public int height(AVLTree a) {//dans les cas ou l'on as un fils null
		if(a == null) return 0;
		return a.getHeight();
	}
	public AVLTree ajout(AVLTree a,Cle k) throws CleExistanteException {
		if(a.getC().inf(k)) {
			if(a.getfilsD() != null) {
				a.setfilsD(ajout(a.getfilsD(),k));
			}else {
				AVLTree temp = new AVLTree(k);
				temp.setPere(a);
				a.setfilsD(temp);

			}
		}else {
			if(!a.getC().equals(k)) {
				if(a.getfilsG() != null) {
					a.setfilsG(ajout(a.getfilsG(),k));
				}else {
					AVLTree temp = new AVLTree(k);
					temp.setPere(a);
					a.setfilsG(temp);
				}
			}else {
				throw new CleExistanteException("Cle Déja existante");
			}
		}
		while((height(a.getfilsG()) - height(a.getfilsD()) >1)
				||(height(a.getfilsD()) - height(a.getfilsG()) >1)) {
			if((height(a.getfilsG()) - height(a.getfilsD())) > 1) {
				a = rotationDroite(a);

			}
			if((height(a.getfilsD()) - height(a.getfilsG())) > 1) {
				a = rotationGauche(a);
			}
		}
		return a;
	}

	private AVLTree rotationGauche(AVLTree a) {
		AVLTree newR = a.getfilsD();
		AVLTree newFG = a;
		if(newR.getfilsG() == null) {
			newFG.setfilsD(null);
		}else {
			newFG.setfilsD(newR.getfilsG());
		}
		if(newR.getfilsG() != null)
			newR.getfilsG().setPere(newFG);
		newR.setfilsG(newFG);
		newR.setPere(newFG.getPere());
		newFG.setPere(newR);
		return newR;
	}

	private AVLTree rotationDroite(AVLTree a) {
		AVLTree newR = a.getfilsG();
		AVLTree newFD = a;
		if(newR.getfilsD() == null) {
			newFD.setfilsG(null);
		}else {
			newFD.setfilsG(newR.getfilsD());
		}
		if(newR.getfilsD() != null)
			newR.getfilsD().setPere(newFD);
		newR.setfilsD(newFD);

		newR.setPere(newFD.getPere());
		newFD.setPere(newR);
		return newR;
	}

	public boolean recherche(AVLTree b, Cle k) {
		if(b==null) return false;
		if (b.getC().equals(k)) {
			System.out.println("trouvé ! ");
			return true;
		}else {
			System.out.println(b.getC().toString());
			System.out.println(k.toString());
			if(b.getC().inf(k)) {
				System.out.println(" je vais voir mon filsD");
				return recherche(b.getfilsD(), k);
			}else {
				System.out.println(" je vais voir mon filsG");
				return recherche(b.getfilsG(), k);
			}
		}
	}

	public String toString() {
		if(filsD != null && filsG != null) {
			return "[ Cle : "+c+",FilsG : "+filsG.toString()+",FilsD : "+filsD.toString()+"]";
		}
		if(filsD == null && filsG != null) {
			return "[ Cle : "+c+",FilsG : "+filsG.toString()+",FilsD : vide]";
		}
		if(filsD != null && filsG == null) {
			return "[ Cle : "+c+",FilsG : vide,FilsD : "+filsD.toString()+"]";
		}else {
			return "[ Cle : "+c+",FilsG : vide,FilsD : vide]";
		}
	}
}
