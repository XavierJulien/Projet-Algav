package partie2;

import java.util.ArrayList;

import partie1.Cle;

public class Tableau {

	//variables 
	public ArrayList<Cle> tab;
	
	//Constructeur
	public Tableau(ArrayList<Cle> l) {
		tab = l;
	}
	
	public Tableau() {
		tab = new ArrayList<Cle>();
	}
	
	//getters,setters
	public ArrayList<Cle> getTab(){return tab;}
	public Cle getElem(int index) {return tab.get(index);}
	public int getTaille() {return tab.size();}
	public Cle getFG(int index) {
		try {
			return tab.get(2*index+1);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le noeud n'as pas de fils");
			return null;
		}
	}
	public Cle getFD(int index) {
		try {
			return tab.get(2*index+2);
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le noeud n'as pas de fils");
			return null;
		}
	}
	
	//Méthodes demandés
	public void SupprMin() { //Supprimer le minimum en O(log n)
		Cle min = tab.get(getTaille()-1);
		System.out.println(min.toString());
		tab.set(getTaille()-1,tab.get(0));
		tab.set(0, min);
		tab.remove(getTaille()-1);
		System.out.println("redescente");
		redescente(tab.get(0));
		}
	
	public void Ajout(Cle c) { //Ajout parmi les cles en O(log n)
		tab.add(c);
		int indexFils = tab.size()-1;
		System.out.println("index du dernier élement àjouté :"+indexFils+",indexPere :"+(indexFils-1)/2);
		redescente(tab.get((indexFils-1)/2));	
	}
	
	public Tableau ConsIter(ArrayList<Cle> list) { // Cons en O(n)
		
		tab = list;
		for(int i = (tab.size()/2)-1;i>=0;i--) {
			redescente(tab.get(i));
		}
		return new Tableau(tab);
	}
	
	public Tableau Union(Tableau t1, Tableau t2) {// Union en O(n + m)
		ArrayList<Cle> la1 = ParcoursPrefixe(tab.get(0));
		ArrayList<Cle> la2 = ParcoursPrefixe(tab.get(0));
		ArrayList<Cle> la = new ArrayList<Cle>(la1);
		la.addAll(la2);
		return ConsIter(la);
	}
	
	public void redescente(Cle c) {//algorithme r�cursif qui �change les cl�s vers le bas tant qu'on as un fils plus petit que soit
		int index = tab.indexOf(c);
		int lastindex = tab.size()-1;
		if(index*2+1 <= lastindex   && index*2+2 > lastindex) {
			System.out.println("j'ai qu'un fils gauche");
			Cle current = c;
			Cle cFilsG = tab.get(index*2+1);
			if(cFilsG.inf(current)) {
				Cle temp = current;
				tab.set( index, cFilsG);
				tab.set(index*2+1,temp);
			}
		
		}
		if(index*2+1 < lastindex && index*2+2 <= lastindex) {	
			System.out.println("j'ai deux fils");
			Cle current = c;
			Cle cFilsG = tab.get(index*2+1);
			Cle cFilsD = tab.get(index*2+2);
			if(cFilsG.inf(cFilsD)) {
				if(cFilsG.inf(current)) {
					Cle temp = current;
					tab.set(index, cFilsG);
					tab.set(index*2+1,temp);
						redescente(tab.get(index*2+1));
				}
			}else {
				if(cFilsD.inf(current)) {
					Cle temp = current;
					tab.set(index, cFilsD);
					tab.set(index*2+2,temp);
						redescente(tab.get(index*2+1));
						redescente(tab.get(index*2+2));
				}
			}
		}
	}
	public String toString() {
		String s= "";
		for(int i =0 ;i<getTaille();i++) {
			s += tab.get(i).toString();
		}
		return s;
	}
}
