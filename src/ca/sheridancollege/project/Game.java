package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final String gameName;
    private ArrayList<Player> players;
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> thrown = new ArrayList<>();
    public Card lastCard;
    private boolean canThrow;

    public boolean flag = false;

    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList();
    }

    public String getGameName() {
        return gameName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public ArrayList<Card> getThrown() {
        return this.thrown;
    }

    //adding player to player array list 
    public boolean addPlayer(Player player) {
        for (Player p : players) {
            if ((p.getPlayerID()).equals(player.getPlayerID())) {
                return flag;
            }
        }
        players.add(player);
        return flag = true;
    }

    //creating main deck 
    public ArrayList<Card> createMainDeck() {
        
        for (Card.Color col : Card.Color.values()) {
            if (!(col == Card.Color.BLACK)) {
                for (Card.Value val : Card.Value.values()) {
                    if (val == Card.Value.DRAW_FOUR || val == Card.Value.WILDCARD) {
                        break;
                    } else {
                        Card c = new Card(col, val);
                        getDeck().add(c);
                    }
                }
            } else {
                for (int w = 0; w < 8; w++) {
                    col = Card.Color.BLACK;
                    Card.Value card;
                    if (w % 2 == 0) {
                        card = Card.Value.DRAW_FOUR;
                    } else {
                        card = Card.Value.WILDCARD;
                    }
                    Card c = new Card(col, card);
                    getDeck().add(c);
                }
            }
        }

        return getDeck();
    }

//assigning the cars to players
    public void deal() {
        for (Player p : players) {
            for (int i = 0; i < 7; i++) {
                int j = (int) (Math.random() * getDeck().size());
                p.addCards(getDeck().get(j));
                getDeck().remove(j);
            }

        }
    }

    //throwing the first card by computer 
    public Card firstCard() {
        int j = (int) (Math.random() * getDeck().size());
        Card comp_card = getDeck().get(j);
        if (!(((comp_card.getValue()).equals(Card.Value.DRAW_FOUR))||((comp_card.getValue()).equals(Card.Value.WILDCARD))||((comp_card.getValue()).equals(Card.Value.DRAW_TWO))||((comp_card.getValue()).equals(Card.Value.SKIP))||((comp_card.getValue()).equals(Card.Value.REVERSE)))) {
            lastCard = comp_card;
            addCardToThrown(lastCard);
            return comp_card;
        } else {
            
            return this.firstCard();
        }
    }

    //add thrown cards to thrown list
    public void addCardToThrown(Card card) {
        getThrown().add(card);
    }

    //check the availability of card
    public void cardToThrow(Player p) {

        int no = 1;
        //display list only
        System.out.println(p.getPlayerID() + " select the card ");
        for (Card c : p.getCards()) {
            System.out.println(no++ + " : " + c);
        }
        System.out.println("----------------------------------------------------");
        // check for the card in the list if present return true
        for (Card c : p.getCards()) {
            if (((c.getColor()).equals(lastCard.getColor())) || ((c.getValue()).equals(lastCard.getValue()))) 
            {
                canThrow = true;
                break;
            }
            else {
                canThrow= false;
            }
        }
        // if true show the matching cards
        if (canThrow) {
            System.out.println(" you can throw only these");
            for (Card c : p.getCards()) {
                int throwable = p.getCards().indexOf(c) + 1;
                if (((c.getColor()).equals(lastCard.getColor())) || ((c.getValue()).equals(lastCard.getValue()))) {
                    System.out.println(throwable + " : " + c);
                }

            }
            Scanner in = new Scanner(System.in);
            int index = in.nextInt();
            lastCard = p.getCards().get(index - 1);
            addCardToThrown(lastCard);
            p.getCards().remove(index - 1);

        } else {
            //should add card to the list if not present

            System.out.println("----------------you have no card to throw-----------------");
            System.out.println("you have drawn a card from the deck");
            p.getCards().add(deck.get(deck.size() - 1));
            System.out.println(p.getCards().size());

        }

    }

    public Player determineWinner() {
        Player winner = null;
        for (Player p : players) {
            if (p.getCards().isEmpty()) {
                winner = p;
            }
        }
        return winner;
    }
public void speicalCheck(Card lastCard, Player nonActivePlayer,Player activePlayer) {
        switch (lastCard.getValue()) {
            case DRAW_TWO:
                for (int i = 0; i < 2; i++) {
                    
                    nonActivePlayer.addCards(deck.get(deck.size() - 1));
                    deck.remove(deck.size() - 1);
                   
                }   cardToThrow(activePlayer); break;
            case SKIP:
                cardToThrow(activePlayer);
                break;
            case REVERSE:
                cardToThrow(activePlayer);
                break;
             case DRAW_FOUR:
                for (int i = 0; i < 4; i++) {
                    nonActivePlayer.addCards(deck.get(deck.size() - 1));
                    deck.remove(deck.size() - 1);
                }  cardToThrow(activePlayer); break;
                 
            default:
                break;
        }

    }
  

}
