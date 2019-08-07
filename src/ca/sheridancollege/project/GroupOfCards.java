
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;


public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards = new ArrayList<>();
    private int size;
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }
     public ArrayList <Card> getCards() {
        return cards;
    }
   
    public ArrayList<Card> showCards()
    {   
       return cards;}
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    
    public int getSize() {
        return size;
    }

    
    public void setSize(int givenSize) {
        size = givenSize;
    }

    /**
     * @return the cards
     */
   
    
}
