
package ca.sheridancollege.project;

import java.util.Arrays;

public class Card 
{
    public enum Color{ RED, YELLOW, GREEN ,BLUE , BLACK};
    public enum Value{ZERO, ONE, TWO, THREE, FOUR, FIVE,SIX, SEVEN, EIGHT,NINE,SKIP,REVERSE,DRAW_TWO,DRAW_FOUR,WILDCARD};

    private final Color color;
    private final Value value;

    
    public Card(Color color, Value value){
        this.color = color;
        this.value = value;
    }
    
    public Color getColor(){
        return this.color;
    }
    public Value getValue(){
        return this.value;
    }
    
    
    @Override
    public String toString(){
     return color+"_"+value;

    }
}
