package com.jvanhouteghem.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.jvanhouteghem.asset.AsciiTable4j;
import com.jvanhouteghem.asset.Console4jModel;
import com.jvanhouteghem.asset.Generique;
import com.jvanhouteghem.asset.Mastermind4j;
import com.jvanhouteghem.enumeration.EnumCouleur;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		
		Mastermind4j m = new Mastermind4j();
		
		System.out.println("D�but de la partie");
		System.out.println("===================");
		
		// Cr�ation de la combinaison choisie par l'ordinateur
		m.creerCombinaisonAleatoire(Config.NIVDIFFICULTE);
		m.affichelistCombinaisonATrouver();
		
		// Lancement de la partie
		boolean partie = true;
		while (partie == true){
			// Demande de la r�ponse du joueur
			ArrayList reponseDuJoueur = Generique.askQuestion();
			
			// Comparaison de la r�ponse avec la combinaison de l'ordinateur
			ArrayList reponseResultatComparaison = m.comparerCombinaisonExacte(reponseDuJoueur);
			//Generique.afficheArrayListContenu(reponse);
			
			// Analyse du nombre de bonnes r�ponses
			int nbTrueValue = Generique.countNumberOfWantedValue(reponseResultatComparaison, true);
			System.out.println("Nombre de bonnes r�ponses : " + nbTrueValue);
			
			// Analyse du nombre de presque bonnes r�ponses
			int nbAlmostTrueValue = m.comparerCombinaisonPresque(reponseDuJoueur);
			System.out.println("Nombre de (presque) bonnes r�ponses : " + nbAlmostTrueValue);
			System.out.println("===================");
			
			// Fin de la partie si le nombre de r�ponse correspond
			if (nbTrueValue == Config.NIVDIFFICULTE){
				System.out.println("       Gagn� !     ");
				System.out.println("===================");
				partie = false;
			}
		*/
		// ============================ AVEC CONSOLE4J =========================
		
		Console4jModel c4j = new Console4jModel();
        c4j.initialize();

		
	}
}
