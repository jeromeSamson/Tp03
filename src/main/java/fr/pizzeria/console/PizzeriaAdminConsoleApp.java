package fr.pizzeria.console;

import java.util.Scanner;

import javax.print.attribute.standard.Copies;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// Tableau contenant les pizzas
		String listPizza[][] = new String[4][4];
		//Scanner permettant de récupérer les différentes saisies de l'utilisateur
		Scanner scan = new Scanner(System.in);
		// Entier permettant de sauvegarder la commande saisie par l'utilisateur
		int commande = 0;
		// Nom de la pizza 
		String nom;
		//Code de la pizza
		String code;
		//Prix de la pizza
		int prix;
		
		//Initialisation du tableau de pizza
		listPizza[0] = new String[]{"0","PEP","Péperoni","12.50"};
		listPizza[1] = new String[]{"1","MAR","Margherita","10.0"};
		listPizza[2] = new String[]{"2","REI","Reine","11.50"};
		listPizza[3] = new String[]{"3","FRO","4 Fromages","12.00"};
		//nombre de pizza présent dans le tableau au début du programme
		int nbPizza = listPizza.length;
		// Boucle permettant l'affichage du menu et intégrant les différentes actions suite a la saisie du choix utilisateur.
		// Tant que la commande est différente de 99 on continue d'afficher le menu.
		while(commande != 99){
			//Affichage du menu
			System.out.println("***** Pizzeria Administration ***** \n"+ 
								"1. Lister les pizzas \n" +
								"2. Ajouter une nouvelle pizza\n" +
								"3. Mettre à jour une pizza\n"+
								"4. Supprimer une pizza\n" +
								"99. Sortir	\n");
			//Récupération de l'action souhaiter par l'utilisateur
			commande = scan.nextInt();
			// Action en fonction du choix utilisateur
			switch(commande){
			case(1):
				//Boucle parcourant l'ensemble du tableau de 0 a nbPizza-1
				System.out.println(nbPizza);
				for(int i = 0; i<nbPizza;i++){
						System.out.println("\n"+listPizza[i][0].toString() +" "+ listPizza[i][1].toString() +" "+ listPizza[i][2].toString() +" "+ listPizza[i][3].toString()+"\n");
				}
				break;	
			case(2):
				//  incrémentation du nombre de pizza présent dans le tableau
					nbPizza = nbPizza + 1;
					/* Si nombre de pizza est supérieur à la taille du tableau  alors on augmente la taille du tableau c
					* grace a une copie temporaire du tableau, la  nouvelle initialisation du tableau de pizza et la 
					* recopie du tableau temporaire dans le tableau principal
					*/
					if(nbPizza > listPizza.length){
						
						String[][] listTempPizza = new String[nbPizza][4];
						for(int i = 0; i<nbPizza-1;i++){
							for(int j =0; j<4;j++){
								listTempPizza[i][j] = listPizza[i][j];
							}
						}
						listPizza = new String[nbPizza][4];
						for(int i = 0; i<nbPizza;i++){
							for(int j =0; j<4;j++){
								listPizza[i][j] = listTempPizza[i][j];
							}
						}
						/*
						 * Saisie des informations concernant la nouvelle pizza
						 */
						System.out.println("Veuillez saisir le code");
						code = scan.next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						nom = scan.next();
						System.out.println("Veuillez saisir le prix");
						prix = scan.nextInt();
						listPizza[nbPizza-1] = new String[]{Integer.toString(nbPizza-1),nom,code,Integer.toString(prix)};
						
					}
					/*
					 * Si le nombre de pizza est inférieur a la taille du tableau alors
					 * on ajoute la nouvelle pizza a la fin du tableau
					 */
					else{
						System.out.println("Veuillez saisir le code");
						code = scan.next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						nom = scan.next();
						System.out.println("Veuillez saisir le prix");
						prix = scan.nextInt();
						listPizza[nbPizza-1] = new String[]{Integer.toString(nbPizza-1),nom,code,Integer.toString(prix)};
					}
				
				break;
			case(3):
				/*
				 * On affiche la liste des pizzas
				 */
				System.out.println(nbPizza);
			for(int i = 0; i<nbPizza;i++){
					System.out.println("\n"+listPizza[i][0].toString() +" "+ listPizza[i][1].toString() +" "+ listPizza[i][2].toString() +" "+ listPizza[i][3].toString()+"\n");
			}
			/*
			 * L'utilisateur saisi le code de la pizza à modifier
			 * On recherche l'indice de la pizza dans le tableau 
			 * On demande la saisie de nouvelles informations sur
			 * la pizza.
			 * On modifie la pizza et on quitte la boucle.
			 */
				System.out.println("Veuillez saisir le code de la pizza a modifier : \n");
				code = scan.next();
				for(int i = 0; i<nbPizza;i++){
					if(code.equals(listPizza[i][1])){
						System.out.println("\n"+listPizza[i][0].toString() +" "+ listPizza[i][1].toString() +" "+ listPizza[i][2].toString() +" "+ listPizza[i][3].toString()+"\n");
						System.out.println("Veuillez saisir le code :");
						code = scan.next();
						System.out.println("Veuillez saisir le nom :");
						nom = scan.next();
						System.out.println("Veuillez saisir le prix :");
						prix = scan.nextInt();
						listPizza[i][1]=code;
						listPizza[i][2]=nom;
						listPizza[i][3]=Integer.toString(prix);
						break;
					}
				}
				System.out.println("Modification effectué\n");			
				
				break;
			case(4):
				/*
				 * On affiche la liste des pizzas supprimable
				 */
				System.out.println(nbPizza);
			for(int i = 0; i<nbPizza;i++){
					System.out.println("\n"+listPizza[i][0].toString() +" "+ listPizza[i][1].toString() +" "+ listPizza[i][2].toString() +" "+ listPizza[i][3].toString());
			}
			/*
			 * On parcour l'ensemble du tableau jusqu'àtrouver
			 * la pizza a supprimé. 
			 * Puis on décale les pizza situées a droite 
			 * de la pizza a supprimé.
			 * On quitte la boucle de décalage a droite
			 * On décrémente le nombre de pizza
			 * et on quitte la boucle de recherche;
			 */
			System.out.println("Veuillez saisir le code de la pizza a supprimer : \n");
			code = scan.next();
			for(int i = 0; i<nbPizza;i++){
				if(code.equals(listPizza[i][1].toString())){
					for(int j =i;j<nbPizza;j++){
						if(listPizza[j+1].equals(null)){
							break;
						}else{
							listPizza[j][1]=listPizza[j+1][1];
							listPizza[j][2]=listPizza[j+1][2];
							listPizza[j][3]=listPizza[j+1][3];
						}
						
					}
						nbPizza--;
						break;
					}
				}
				System.out.println("Suppression effectué\n");			
				break;
			case(99):
				break;
			default:
				break;
			}

	}System.out.println("Au revoir");}

}
