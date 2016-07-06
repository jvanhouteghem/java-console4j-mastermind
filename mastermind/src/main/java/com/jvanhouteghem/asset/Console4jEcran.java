package com.jvanhouteghem.asset;

import java.util.Arrays;

public class Console4jEcran {
	
	// todo virer turnIndexPrincipal et turnIndexSecondary et les transformer en input
	
	// --------- variable ----------
	
	int turnIndexPrincipal;
	int turnIndexSecondary;
	
	// --------- getter setter ----------
	
	public int getTurnIndexPrincipal() {
		return turnIndexPrincipal;
	}

	public void setTurnIndexPrincipal(int turnIndexPrincipal) {
		this.turnIndexPrincipal = turnIndexPrincipal;
	}

	public int getTurnIndexSecondary() {
		return turnIndexSecondary;
	}

	public void setTurnIndexSecondary(int turnIndexSecondary) {
		this.turnIndexSecondary = turnIndexSecondary;
	}
	
	// --------- methodes ----------

	/*public String showPlayer(){
		return printTurnHeader() + printBoardGameHeader()+printHandHeader();
	}*/

	public String printTurnHeader(int cartesRestantesPioche){
		String outputLine1 = "##############################################";
		String outputLine2 = "############       TOUR  " +  getTurnIndexPrincipal() + "." + getTurnIndexSecondary() + "      ############";
		//String outputLine2 = "####### TOUR  " +  getTurnIndexPrincipal() + "." + getTurnIndexSecondary() + " ####### SCORE = 112  ########";
		String outputLine3 = "#########   Cartes restantes : " + cartesRestantesPioche + "   ##########";
		//String outputLine3 = "############     SCORE : 800      ############";
		return outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n";
	}
	
	public String printBoardGameHeader(){
		String outputLine1 = "==============================================";
		String outputLine2 = "############   PLATEAU DE JEU :   ############";
		String outputLine3 = "==============================================";
		return outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n";
	}
	
	public String printHandHeader(){
		String outputLine1 ="==============================================";
		String outputLine2 ="############     VOTRE MAIN :     ############";
		String outputLine3 ="==============================================";
		return outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n";
	}
	
	public String printAide(){
		// TODO faire tableau
		/*String outputLine1 ="==============================================";
		String outputLine2 ="############        AIDE          ############";
		String outputLine3 ="==============================================";
		String outputLine4 = "      Liste des commandes disponibles : \n";
		String outputLine5 = "start pour démarrer a partie.";
		String outputLine6 = "Choisissez la carte dans votre main (de 0 à 6) et le numéro du paquet (de 1 à 4), exemple 1,1";
		String outputLine7 = "p ou pioche pour piocher des cartes.";
		return outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n"+outputLine4+"\n"+outputLine5+"\n"+outputLine6+"\n"+outputLine7+"\n";*/
		
		String outputLine1 ="==============================================";
		String outputLine2 ="############        AIDE          ############";
		String outputLine3 ="==============================================";
		String outputLine4 = "      Liste des commandes disponibles : \n";
		return outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n"+outputLine4+"\n";
	}

	/*public void perduSys(){
		System.out.println("          _____             _      ");
		System.out.println("         |  __ \\           | |      ");
		System.out.println("         | |__) |__ _ __ __| |_   _ ");
		System.out.println("         |  ___/ _ \\ '__/ _` | | | |");
		System.out.println("         | |  |  __/ | | (_| | |_| |");
		System.out.println("         |_|   \\___|_|  \\__,_|\\__,_|	");
	} */
	
	public String perdu(int input){
		String outputLine1 = "          _____             _      ";
		String outputLine2 = "         |  __ \\           | |      ";
		String outputLine3 = "         | |__) |__ _ __ __| |_   _ ";
		String outputLine4 = "         |  ___/ _ \\ '__/ _` | | | |";
		String outputLine5 = "         | |  |  __/ | | (_| | |_| |";
		String outputLine6 = "         |_|   \\___|_|  \\__,_|\\__,_|	";
		String outputLine7 = "         Il reste " + input  + " cartes.";
		String outputLine8 = "";
		String outputLine9 = "     (start pour redémarrer une partie.)";
		return "\n"+"\n"+"\n"+outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n"+outputLine4+"\n"+outputLine5+"\n"+outputLine6+"\n"+outputLine7+"\n"+outputLine8+"\n"+outputLine9+"\n";
	} 
	
	/*public void gagne(){
		System.out.println("	  _____                     __");
		System.out.println("	 / ____|                   /_/ ");
		System.out.println("	| |  __  __ _  __ _ _ __   ___ ");
		System.out.println("	| | |_ |/ _` |/ _` | '_ \\ / _ \\");
		System.out.println("	| |__| | (_| | (_| | | | |  __/");
		System.out.println("	 \\_____|\\__,_|\\__, |_| |_|\\___|");
		System.out.println("	               __/ |           ");
		System.out.println("	              |___/  ");
	}*/
	
	public static String gagne(){
		String outputLine1 = "	  _____                     __";
		String outputLine2 = "	 / ____|                   /_/ ";
		String outputLine3 = "	| |  __  __ _  __ _ _ __   ___ ";
		String outputLine4 = "	| | |_ |/ _` |/ _` | '_ \\ / _ \\";
		String outputLine5 = "	| |__| | (_| | (_| | | | |  __/";
		String outputLine6 = "	 \\_____|\\__,_|\\__, |_| |_|\\___|";
		String outputLine7 = "	               __/ |           ";
		String outputLine8 = "	              |___/  ";
		String outputLine9 = "	Saisissez start pour recommencer.";
		return "\n"+"\n"+"\n"+outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n"+outputLine4+"\n"+outputLine5+"\n"+outputLine6+"\n"+outputLine7+"\n"+outputLine8+"\n"+outputLine9+"\n";
	}
	
	public String startScreen2(){
		String outputLine1 = "       _______ _                   ";
		String outputLine2 = "      |__   __| |                  ";
		String outputLine3 = "         | |  | |__   ___          ";
		String outputLine4 = "         | |  | |_ \\ / _ \\         ";
		String outputLine5 = "         | |  | | | |  __/         ";
		String outputLine6 = "         |_|_ |_| |_|\\___|         ";
		String outputLine7 = "        / ____|                     ";
		String outputLine8 = "       | |  __  __ _ _ __ ___   ___ ";
		String outputLine9 = "       | | |_ |/ _` | '_ ` _ \\ / _ \\";
		String outputLine10 = "       | |__| | (_| | | | | | |  __/";
		String outputLine11 = "        \\_____|\\__,_|_| |_| |_|\\___|";
		String outputLine13 = "       ------------------------------   ";
		String outputLine14 = "           start pour commencer         ";
		String outputLine15 = "            aide pour des infos         ";		
		String outputLine16 = "       ------------------------------   ";
		String outputLine17 = "       @Auteur - Jonathan Vanhouteghem    ";
		return outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n"+outputLine4+"\n"+outputLine5+"\n"+outputLine6+"\n"+outputLine7+"\n"+outputLine8+"\n"+outputLine9+"\n"+outputLine10+"\n"+outputLine11+"\n"+outputLine13+"\n"+outputLine14+"\n"+outputLine15+"\n"+outputLine16 +"\n"+outputLine17;
	}
	
	//http://patorjk.com/software/taag/#p=display&f=Doom&t=Master%0AMind
	public static String startScreen(){
		 String outputLine1 = "        ___  ___          _            ";
		 String outputLine2 = "        |  \\/  |         | |           ";
		 String outputLine3 = "        | .  . | __ _ ___| |_ ___ _ __ ";
		 String outputLine4 = "        | |\\/| |/ _` / __| __/ _ \\ '__|";
		 String outputLine5 = "        | |  | | (_| \\__ \\ ||  __/ |   ";
		 String outputLine6 = "        \\_|  |_/\\__,_|___/\\__\\___|_|   ";
		 String outputLine8 = "        |  \\/  (_)         | |         ";
		 String outputLine9 = "        | .  . |_ _ __   __| |         ";
		String outputLine10 = "        | |\\/| | | '_ \\ / _` |         ";
		String outputLine11 = "        | |  | | | | | | (_| |         ";
		String outputLine12 = "        \\_|  |_/_|_| |_|\\__,_|         ";
		String outputLine13 = "       ------------------------------   ";
		String outputLine14 = "           start pour commencer         ";
		String outputLine15 = "            aide pour des infos         ";		
		String outputLine16 = "       ------------------------------   ";
		String outputLine17 = "       @Auteur - Jonathan Vanhouteghem    ";
		return outputLine1+"\n"+outputLine2+"\n"+outputLine3+"\n"+outputLine4+"\n"+outputLine5+"\n"+outputLine6+"\n"+outputLine8+"\n"+outputLine9+"\n"+outputLine10+"\n"+outputLine11+"\n"+outputLine12+"\n"+outputLine13+"\n"+outputLine14+"\n"+outputLine15+"\n"+outputLine16 +"\n"+outputLine17;
	}
	
	
	/*public String afficherPlateau(Deck4j paquet1, Deck4j paquet2, Deck4j paquet3, Deck4j paquet4){
		AsciiTable4j t = new AsciiTable4j();
		
		// create table
		t.addRow(Arrays.asList("> 1", "> 1", "100 <", "100 <"));
		t.addRow(Arrays.asList(paquet1.getValeurCarte(0).toString(), paquet2.getValeurCarte(0).toString(), paquet3.getValeurCarte(0).toString(), paquet4.getValeurCarte(0).toString()));
			
		// show table
		return t.showTable(10); 
	}*/
	
	public static String showCommandList(){
		AsciiTable4j t = new AsciiTable4j();
		t.addRow(Arrays.asList("Commande", "Informations"));
		t.addRow(Arrays.asList("start", "Démarrage de la partie"));
		//t.addRow(Arrays.asList("r", "Afficher les règles du jeu")); // changer l'ecran d'acceuil pour afficher les règles ?
		t.addRow(Arrays.asList("aide", "Obtenir des informations"));
		//t.addRow(Arrays.asList("q", "Quitter la fenêtre d'aide"));
		t.addRow(Arrays.asList("triche", "Afficher la solution"));
		return t.showTable(4); 
	}
	
}
