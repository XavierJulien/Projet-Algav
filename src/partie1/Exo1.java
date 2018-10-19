package partie1;

public final class Exo1 {

	public final static boolean inf(Cle c1, Cle c2) {
		//si cle1.In est différent de cle2.In alors on renvoie directement si
		//c1.In < c2.In 
		if(c1.getSousCle(0) != c2.getSousCle(0)) 
			return c1.getSousCle(0) < c2.getSousCle(0);
		if(c1.getSousCle(1) != c2.getSousCle(1))
			return c1.getSousCle(1) < c2.getSousCle(1);
		if(c1.getSousCle(2) != c2.getSousCle(2))
			return c1.getSousCle(2) < c2.getSousCle(2);
		return c1.getSousCle(3) < c2.getSousCle(3);
	}
	
	public final static boolean eg(Cle c1, Cle c2) {
		//on verifie si tous les entiers des clés sont égaux
		if(c1.getSousCle(0) == c2.getSousCle(0)) {
			if(c1.getSousCle(1) == c2.getSousCle(1)) {
				if(c1.getSousCle(2) == c2.getSousCle(2)) {
					return (c1.getSousCle(3) == c2.getSousCle(3));
				}
			}
		}
		return false;
	}
}
