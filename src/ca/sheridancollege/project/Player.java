
package ca.sheridancollege.project;

import java.util.ArrayList;

public class Player 
{
    private String playerID; 
    private ArrayList<Card> pCards = new ArrayList<>();
   
    public Player(String name)
    {
        playerID= name;
    }
    
    public String getPlayerID() 
    {
        return playerID;
    }

    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    public void addCards(Card card){
        pCards.add(card);
    }
  
    public ArrayList<Card> getCards(){
        return pCards;
    }
    
     public boolean equals(Player p1) {
        return this.playerID==p1.getPlayerID();
    }
}
