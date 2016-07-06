package com.jvanhouteghem.asset;

import java.util.ArrayList;
import java.util.List;

import com.jvanhouteghem.enumeration.EnumCouleur;
import com.jvanhouteghem.launcher.Config;

public class Mastermind4j {
	
	// ---------------------------------------------------------------------------------
	
	ArrayList listCombinaisonATrouver = new ArrayList();
	
	// -------------------------------- Get / Set --------------------------------------

	public ArrayList getlistCombinaisonATrouver() {
		return listCombinaisonATrouver;
	}
	
	public void affichelistCombinaisonATrouver(){
		System.out.print("-- Mode triche : ");
		for (int i = 0 ; i < listCombinaisonATrouver.size() ; i++){
			System.out.print(listCombinaisonATrouver.get(i) + " ");
		}
		System.out.println();
	}
	
	public String CombinaisonATrouverToString(){
		String result = "";
		for (int i = 0 ; i < listCombinaisonATrouver.size() ; i++){
			result+=listCombinaisonATrouver.get(i) + " ";
		}
		return result;
	}
	
	// ----------------------------------------------------------------------------------
	
	public void initialize(){
		
		System.out.println("Début de la partie");
		System.out.println("===================");
		
		// Création de la combinaison choisie par l'ordinateur
		creerCombinaisonAleatoire(Config.NIVDIFFICULTE);
		affichelistCombinaisonATrouver();	
	}
	
	public int tryResolve(ArrayList reponseDuJoueur){
		//ArrayList reponseDuJoueur = Generique.askQuestion();
		
		// Comparaison de la réponse avec la combinaison de l'ordinateur
		ArrayList reponseResultatComparaison = comparerCombinaisonExacte(reponseDuJoueur);
		//Generique.afficheArrayListContenu(reponse);
		
		// Analyse du nombre de bonnes réponses
		int nbTrueValue = Generique.countNumberOfWantedValue(reponseResultatComparaison, true);
		System.out.println("Nombre de bonnes réponses : " + nbTrueValue);
		/*
		// Analyse du nombre de presque bonnes réponses
		int nbAlmostTrueValue = comparerCombinaisonPresque(reponseDuJoueur);
		System.out.println("Nombre de (presque) bonnes réponses : " + nbAlmostTrueValue);
		System.out.println("===================");
		
		// Fin de la partie si le nombre de réponse correspond
		if (nbTrueValue == Config.NIVDIFFICULTE){
			System.out.println("       Gagné !     ");
			System.out.println("===================");
			//partie = false;
		}*/
		
		return nbTrueValue;
	}
	
	// ----------------------------------------------------------------------------------
	
	public ArrayList creerCombinaisonAleatoire(int nbCombinaison){
		
		for (int i = 0 ; i < nbCombinaison ; i++){
			int tmpRandom = Generique.getRandomWithLimit(0,3);
			String couleurChoisie = EnumCouleur.getCouleurById(tmpRandom);
			listCombinaisonATrouver.add(couleurChoisie);
		}
		return listCombinaisonATrouver;
	}
	
	// Retourne un tableau avec des boolean pour chaque partie de la combinaison
	public ArrayList comparerCombinaisonExacte(ArrayList listCombinaisonAComparer){
		
		ArrayList resultat = new ArrayList();
		
		// Pour chaque valeur cac de listCombinaisonAComparer
		for (int i = 0; i<listCombinaisonAComparer.size() ; i++){
			// Pour chaque valeur cat de listCombinaisonATrouver
			if (listCombinaisonAComparer.get(i).equals(getlistCombinaisonATrouver().get(i))){
				resultat.add(true);
			} 
			else {
				resultat.add(false);
			}
		}
		return resultat;
	}
	
	// Retourne le nombre de valeur mal placées en excluant celles qui sont des valeurs bien placée
	public int comparerCombinaisonPresque(ArrayList listCombinaisonAComparer){
		int result = 0;
		
		// Récupération de la position des positions vraies
		ArrayList exact = comparerCombinaisonExacte(listCombinaisonAComparer);
		
		for (int i = 0; i<listCombinaisonAComparer.size() ; i++){
			if (!(listCombinaisonAComparer.get(i).equals(getlistCombinaisonATrouver().get(i)))){
				
				for (int j = 0 ; j < getlistCombinaisonATrouver().size() ; j++){
					
					if (
						listCombinaisonAComparer.get(i).equals(getlistCombinaisonATrouver().get(j))
						&& 	exact.get(j).equals(false)
						){
							result++;
							break;
					}
				}
			}
		}

		return result;
	}

}