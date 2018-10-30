package partie2;

import partie1.Cle;

public class Noeud {
	
	private Cle c;
	private Noeud pere;
	private Noeud filsG;
	private Noeud filsD;
	
	public Noeud(Cle c,Noeud pere,Noeud filsG,Noeud filsD) {
		this.c = c;
		this.pere = pere;
		this.filsG = filsG;
		this.filsD = filsD;
	}
	
	public Noeud(Cle c) {
		this.c = c;
		pere = null;
		filsG = null;
		filsD = null;
	}
	
	public Cle getCle() {return c;}
	
	public Noeud getPere() {return pere;}
	public Noeud getFilsG() {return filsG;}
	public Noeud getFilsD() {return filsD;}

	public void setFilsG(Noeud filsG) {this.filsG = filsG;}
	public void setFilsD(Noeud filsD) {this.filsD = filsD;}
	public void setPere(Noeud pere) {this.pere = pere;}
	public void setC(Cle temp) {c = temp;}
	
	

	public void redescente() {//algorithme r�cursif qui �change les cl�s vers le bas tant qu'on as un fils plus petit que soit
		System.out.println("l'element en cours est "+c.toString());
		if(filsD == null) {
			System.out.println("On cherche a remplacer le filsG "+filsG.getCle().toString());
			Cle current = c;
			Cle cFilsG = filsG.getCle();
			if(cFilsG.inf(current)) {
				Cle temp = current;
				c = cFilsG;
				filsG.setC(temp);
				System.out.println("mon nouveau current :"+c.toString());
				System.out.println("mon nouveau filsG"+filsG.getCle().toString());
			}
		}else {
			Cle current = c;
			Cle cFilsG = filsG.getCle();
			Cle cFilsD = filsD.getCle();
			if(cFilsG.inf(cFilsD)) {
				if(cFilsG.inf(current)) {
					System.out.println("On cherche a remplacer le filsG "+filsG.getCle().toString());
					Cle temp = current;
					c = cFilsG;
					filsG.setC(temp);
					if(filsG != null)
						System.out.println("mon nouveau current :"+c.toString());
						System.out.println("mon nouveau filsG"+filsG.getCle().toString());
						filsG.redescente();
				}
			}else {
				if(cFilsD.inf(current)) {
					System.out.println("On echange avec le filsD "+filsD.getCle().toString());
					Cle temp = current;
					c = cFilsD;
					filsD.setC(temp);
					if(filsD != null)
						System.out.println("mon nouveau current :"+c.toString());
						System.out.println("mon nouveau filsD"+filsD.getCle().toString());
						filsD.redescente();
				}
			}
		}
	}

	public String toString() {
		if(this.getFilsG() == null) {
			return "[ Cle : "+this.getCle().toString()+", filsG : vide, filsD : vide]";
		}else {
			if(this.getFilsD() == null) {
				return "[ Cle : "+this.getCle().toString()+", filsG : "+this.getFilsG().toString()+", filsD : vide]"; 
			}else {
				return "[ Cle : "+this.getCle().toString()+", filsG : "+this.getFilsG().toString()+", filsD"+this.getFilsD().toString()+"]";	
			}
		}
	}
	/*public String toString() {
		return c.toString();
	}*/
}
