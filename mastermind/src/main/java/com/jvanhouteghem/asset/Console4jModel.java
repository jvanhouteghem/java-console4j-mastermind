package com.jvanhouteghem.asset;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JTextPane;

import com.jvanhouteghem.launcher.Config;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JScrollBar;

/**
 * @author vjona
 *
 */
public class Console4jModel {

	private JFrame frame;
	private JTextArea jTextArea;
	private JTextPane textPane;
	private String fenetreActuelleId; // TODO en faire une enum ?
	private Mastermind4j m;
	private String pageActuelle = "accueil";
	private int nbEssaiRestant = Config.NBESSAIRESTANT;
	
	public int getNbEssaiRestant() {
		return nbEssaiRestant;
	}

	public void setNbEssaiRestant(int nbEssaiRestant) {
		this.nbEssaiRestant = nbEssaiRestant;
	}

	public String getPageActuelle() {
		return pageActuelle;
	}

	public void setPageActuelle(String pageActuelle) {
		this.pageActuelle = pageActuelle;
	}

	public Mastermind4j getM() {
		return m;
	}

	public void setM(Mastermind4j m) {
		this.m = m;
	}

	public JTextArea getTxtrTest() {
		return jTextArea;
	}

	public void setTxtrTest(JTextArea txtrTest) {
		this.jTextArea = txtrTest;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}
	
	public String getSaisie(){
		return getTextPane().getText().replace("\n", "").replace("\r", "");
	}

	/**
	 * Initialize the contents of the frame.
	 * @param gi 
	 * @param ld 
	 * @param ld 
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//frame.setLocation(500, 300);
		//jFrame.setLocationRelativeTo(null);
		
		//frame.setSize(550, 400);
		
		// ------------- Text Input ---------------
		setTextPane(new JTextPane());
		
		getTextPane().setBackground(SystemColor.controlHighlight);
		getTextPane().setBounds(0, 328, 380, 22);
		frame.getContentPane().add(getTextPane());
		
		// Listener
		textPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (e.getKeyCode() == 10){ // le 10 représente la touche entrée
					System.out.println("Saisie : " + getSaisie());
					mapper(getSaisie());
				}
			}
		});

		// ------------- Text Display ---------------
		JTextArea jTextArea = new JTextArea();
		jTextArea.setLineWrap(true);
		jTextArea.setEditable(false);
		jTextArea.setBounds(0, 0, 380, 386);
		frame.getContentPane().add(jTextArea);
		
		setTxtrTest(jTextArea);
		
		frame.setVisible(true);
		
		
		// Format comme console
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
		getTxtrTest().setFont(font);
		
		// premier affichage 
		jTextArea.append(Console4jEcran.startScreen());
		
		frame.setResizable(false);

	}
	
	public void effacerSaisie(){
		textPane.setText("");
	}
	
	public void effacerFenetre(){
		jTextArea.setText("");
	}
	
	public void effacerSaisieEtFenetre(){
		textPane.setText("");
		jTextArea.setText("");
	}
	
	public void modifierFenetreAvecString(String input){
		jTextArea.append(input+ "\n");
	}
	
	public void modifierFenetreAvecArrayList(ArrayList input){
		effacerFenetre();
		for (int i = 0 ; i < input.size() ; i++){
			jTextArea.append(input.get(i)+ "\n");
		}
		effacerSaisie();
	}
	
	// ---------------------------------------------------------
	//                   Mapping et Affichage
	// ---------------------------------------------------------
	
	public void mapper(String input){
		
		if(input.equals("accueil")){
			// afficherAcceuil()
			ecranAccueil();
		}
		
		else if(input.equals("start")){
			// afficherStart()		
			ecranStart(input);
		}
		
		else if(input.equals("aide")){
			// afficherAide()
			ecranAide();
		}
		
		else if (
			getPageActuelle().equals("start")
			&& !(input.equals("triche"))
			// && value correspond a un test v,v,v,v,v
		){ // value n'est ni start ni aide 
			ecranResolve(input);
		}
		
		else if (
				getPageActuelle().equals("start")
				&& input.equals("triche")
				// && value correspond a un test v,v,v,v,v
			){ // value n'est ni start ni aide 
				ecranStartTriche();
			}
		
		/*else if(
				// page actuelle = start
				//&& valeur est une combinaison reconnue
			){
			// afficherReaction()
		}*/
		
		else {
			// Votre saisie n'est pas correcte
			effacerSaisie();
		}

		
	}
	
	public void ecranAccueil(){
		effacerSaisieEtFenetre();
		jTextArea.append(Console4jEcran.startScreen());
		setPageActuelle("accueil");
	}
	
	public void ecranStart(String input){
		effacerSaisieEtFenetre();
		setPageActuelle("start");
		
		// Reset de la valeur en cas de nouvelle partie
		setNbEssaiRestant(Config.NBESSAIRESTANT);
		
		Mastermind4j m = new Mastermind4j();
		setM(m);
		m.initialize();
		// Lancement du modèle et récupération des variables
		// Appel de l'écran avec injection des variables reçues avec le modèle
		//modifierFenetreAvecString(input);
		jTextArea.append(" Démarrage de la partie : \n");
		jTextArea.append(" ---------------------\n");
		jTextArea.append(" Sélectionnez les 5 possibilités séparées par \n des virgules, exemple : v, b, r, v, v\n");
		jTextArea.append(" Les couleurs disponibles sont v,b,r,t\n");
		/*jTextArea.append(" ---------------------\n");
		jTextArea.append("-- Mode triche : ");
		jTextArea.append(m.CombinaisonATrouverToString());*/
	}
	
	public void ecranResolve(String input){
		effacerSaisieEtFenetre();
		// Split la réponse pour pouvoir la comparer plus tard
		List<String> tmpReponseJoueurList = Arrays.asList(input.split(","));
		ArrayList tmpReponseJoueurArrayList = new ArrayList<String>(tmpReponseJoueurList);
		
		int nbTrueValue = getM().tryResolve(tmpReponseJoueurArrayList);
		int nbAlmostValue = getM().comparerCombinaisonPresque(tmpReponseJoueurArrayList);
		
		if (nbTrueValue != Config.NIVDIFFICULTE){
			if (getNbEssaiRestant() != 0){
				jTextArea.append(" Raté\n");
				jTextArea.append(" Vous avez répondu : " + input + "\n");
				jTextArea.append(" Nombre de bonnes réponses : " + String.valueOf(nbTrueValue)+"\n");
				jTextArea.append(" Nombre de (presque) bonnes réponses : " + String.valueOf(nbAlmostValue)+"\n");
				jTextArea.append(" ---------------------\n");
				jTextArea.append(" Il vous reste : " + getNbEssaiRestant() + " essais\n");
				jTextArea.append(" ---------------------\n");
				jTextArea.append(" Saisissez une nouvelle combinaison\n");
				jTextArea.append(" Les couleurs disponibles sont v,b,r,t\n");
				//System.out.println("true : " + nbTrueValue + " -  almost : " + nbAlmostValue);
				/*jTextArea.append(" ---------------------\n");
				jTextArea.append("-- Mode triche : ");
				jTextArea.append(m.CombinaisonATrouverToString());*/
				setNbEssaiRestant(getNbEssaiRestant()-1);
			} else {
				jTextArea.append(" PERDU !\n");
				jTextArea.append(" ---------------------\n");
				jTextArea.append(" Pour rejouer tapez start.\n");
			}
		} else {
			// afficher gagné
			jTextArea.append(Console4jEcran.gagne());
			jTextArea.append("        ---------------------\n");
			jTextArea.append("        Vous avez réussi en " + getNbEssaiRestant() + " essais\n");
			
		}
			// appel de tryresolve
		//sysout de tryresolve
	}
	
	public void ecranStartTriche(){
		effacerSaisie();
		jTextArea.append(" ---------------------\n");
		jTextArea.append("-- Mode triche : ");
		jTextArea.append(m.CombinaisonATrouverToString());
	}
	
	public void ecranAide(){
		effacerSaisieEtFenetre();
		setPageActuelle("aide");
		jTextArea.append(Console4jEcran.showCommandList());
	}
	
	
	

}
