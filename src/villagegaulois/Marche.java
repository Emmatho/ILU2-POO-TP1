package villagegaulois;

import java.util.Iterator;

import personnages.Gaulois;

public class Marche {
	
	private Etal[] etals;
	private int nbEtals;
	
	public Marche(int nbEtals) {
		this.nbEtals = nbEtals;
		this.etals = new Etal[nbEtals];
		for (int i=0 ; i < nbEtals ; i++) {
			etals[i] = new Etal();
		}
	}
	
	public void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduits) {
		etals[indiceEtal].occuperEtal(vendeur, produit, nbProduits);
	}
	
	public int trouverEtalLibre() {
		for (int i=0 ; i < nbEtals ; i++) {
			if (!etals[i].isEtalOccupe()) {
				return 0;
			}
		}
		return -1;
	}
	
	 public Etal[] trouverEtals(String produit) {
		 int nbSol = 0;
		 Etal[] solution = new Etal[nbEtals];
		 for (int i=0 ; i < nbEtals ; i++) {
			 if (etals[i].isEtalOccupe() && etals[i].contientProduit(produit)) {
				 solution[nbSol] = etals[i];
				 nbSol++;
			 }
		 }
		 return solution;
	 }
	 
	 public Etal trouverVendeur(Gaulois gaulois) {
		 for (int i=0 ; i < nbEtals ; i++) {
			 if (etals[i].getVendeur() == gaulois) {
				 return etals[i];
			 }
		 }
		 return null;
	 }
	 
	 public String afficherMarche() {
		 int etalsVides = 0;
		 String marche = "Voici l'�tat du march� :\n";
		 for (int i=0 ; i < nbEtals ; i++) {
			 if (!etals[i].isEtalOccupe()) {
				 etalsVides ++;
			 } else {
				 marche = marche + etals[i].afficherEtal() + "\n";
			 }
		 }
		 marche = marche +  "Il reste " + etalsVides + " �tals non utilis�s dans le march�.\n";
		 return marche;
	 }
}
