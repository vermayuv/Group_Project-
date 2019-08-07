package ca.sheridancollege.project;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String p2Name = new String();
        String p1Name = new String();
        Scanner in = new Scanner(System.in);

        Game game = new Game("UNO");

        // asking for the player names
        while (p1Name.equalsIgnoreCase(p2Name)) { //this will check the unique id of the player
            System.out.println("Enter player 1 name: ");
            p1Name = in.nextLine();

            System.out.println("-------------------------------------------");
            System.out.println("Enter Player 2 name: ");
            p2Name = in.nextLine();

            System.out.println("-------------------------------------------");
        }
        Player p1 = new Player(p1Name);
        game.addPlayer(p1);
        Player p2 = new Player(p2Name);
        game.addPlayer(p2);

        game.createMainDeck();// creating the main deck for the game

        /*for (int i = 0; i < game.getDeck().size(); i++) {     //this waas used to print the cards of the main deck
            System.out.println(game.getDeck().get(i));
                }
         */
        System.out.println("size of main deck is :" + game.getDeck().size());
        System.out.println("-------------------------------------------");

        game.deal();// this method assigns the cards to all players present in the player list

        Collections.shuffle(game.getDeck()); //this shuffles the cards that left in main deck after giving to the players
        
        /* for (Player p : game.getPlayers()) {   //this method was used to print the cards given to all the players
            System.out.println("Player " + p.getPlayerID() + "'s cards : ");
            System.out.println(p.getCards());

            System.out.println("------------------------------------------------");
        }*/
        
        
        System.out.println("------------starting card thrown automatically-----------------");
        System.out.println(game.firstCard()); //first card thrown by the computer and stored in thrown array and removed from main deck

        System.out.println("------------------------------------------------");
        System.out.println("card in thrown list : " + game.getThrown().size()); //shows the last card thrown from the thrown ArrayList 
        
        /* for (Card c : game.getThrown()) {
            System.out.println(c);
        }*/
        System.out.println("------------------------------------------------");
        
        while (game.determineWinner() == null) { //this method will execute the game until any player in the player arraylist
            
            game.cardToThrow(p1); // the maethod that prompt the player 1 to throw the card 
            // this method also checks wether player has any valid card if no it give the card from the remaining deck

            System.out.println("----------------------------------------------------------");
            System.out.println("----------------target card-------------------------------");
            System.out.println(game.getThrown().get(game.getThrown().size() - 1));
            
            //this method checks for any special cards thrown by the last player
            game.speicalCheck(game.getThrown().get(game.getThrown().size() - 1), p2, p1);
            
            System.out.println("------------------------------------------------");
            
            // System.out.println("card in thrown lsit" + game.getThrown().size());
           
           //this method was used to ensure that every card thrown is added to the thrown ArrayList 
            /* for (Card c : game.getThrown()) {
                System.out.println(c);
            }*/
            System.out.println("------------------------------------------------");

            game.cardToThrow(p2);
            System.out.println("----------------------------------------------------------");
            System.out.println("----------------target card-------------------------------");
            System.out.println(game.getThrown().get(game.getThrown().size() - 1));
            game.speicalCheck(game.getThrown().get(game.getThrown().size() - 1), p1, p2);
            System.out.println("------------------------------------------------");
            
            
            //System.out.println("card in thrown lsit" + game.getThrown().size());
            /* for (Card c : game.getThrown()) {
                System.out.println(c);
            }*/

            System.out.println("------------------------------------------------");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");

        System.out.println("---------------------------" + game.determineWinner().getPlayerID() + "-------------------------");
    }
}
