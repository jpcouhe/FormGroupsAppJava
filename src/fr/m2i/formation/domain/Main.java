package fr.m2i.formation.domain;

import fr.m2i.formation.model.ListPersonne;

import java.util.Arrays;
import java.util.Scanner;



        public class Main {
            public static void main(String[] args) {

                ListPersonne maList = new ListPersonne();


                int nombreDePersonnes = 0;
                int nombreDePersonneDansTableau = 0;


                Scanner sc = new Scanner(System.in);
                System.out.println("Combien de personnes voulez vous disperser en groupe? ");
                nombreDePersonnes = sc.nextInt();



                // Je crée la Liste Chainée

                while (nombreDePersonnes != 0) {

                    System.out.println("Veuillez indiquer le nom de la " + (nombreDePersonneDansTableau + 1 ) + " personne");
                    String name = sc.next();
                    maList.add(name);

                    nombreDePersonnes--;
                    nombreDePersonneDansTableau++;
                }




                // Je fais les groupes
                //Tant qu'il y a des personnes dans la liste chainée
                int nombreDeGroupe = 0;



                while (nombreDePersonneDansTableau != 0) {

                    int nombrePersonneDansGroupe;

                    //Je définis la taille du groupe que je veux

                    System.out.println("De quelle taille est le " + (nombreDeGroupe+1) + " groupe que vous voulez former?");
                    System.lineSeparator();
                    System.out.println("il reste " + nombreDePersonneDansTableau + " personnes dans la liste");
                    nombrePersonneDansGroupe = sc.nextInt();



                    String[] groupe = new String[nombrePersonneDansGroupe];

                    //Je remplis mon groupe

                    int nbAlea;

                    for (int i = 0; i < nombrePersonneDansGroupe; i++) {

                        //Je génére un nombre alétoire pour pouvoir piocher au hasard un nom dans ma liste
                        nbAlea = (int) (Math.random() * nombreDePersonneDansTableau);

                        //Je récupère le nom
                        groupe[i] = maList.getOnePersonne(nbAlea);

                        //Je supprime la personne de la liste chainée
                        maList.delete(nbAlea);
                        nombreDePersonneDansTableau--;
                    }


                    nombreDeGroupe++;
                    // J'affiche la réponse
                    System.out.println("Le groupe est : " + Arrays.toString(groupe));


                    //Question pour inviter l'utilisateur a continuer ou quitter le programme. Ne fonctionne pas//
                    //-----------------------------------------------------------------------------------------//
            /*
            if(nombreDePersonneDansTableau !=0){
                System.out.println("Voulez-vous former un groupe supplémentaire? (Y/N)");
                String answerQUestions = sc.next();


                if(answerQUestions == "N") {
                    answer = false;
                }else{
                    answer = true;
                }
                System.out.println(answer);
            }*/



                }}}
