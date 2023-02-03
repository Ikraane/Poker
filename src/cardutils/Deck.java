package cardutils;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> theCards;
//The code for Deck is borrowed from https://codereview.stackexchange.com/questions/128398/deck-of-cards-design
    public Deck() {
        theCards = new ArrayList<Card>();
        fill();
        shuffleCards();
    }

    public int getSize() {
        return theCards.size();
    }

    //The code for dealCard is borrowed from https://ycpcs.github.io/cs201-fall2016/assign/assign04javadoc/edu/ycp/cs201/cards/Pile.html#Pile()
   public Card dealCard() {
        if (!theCards.isEmpty()) {
            return theCards.remove(0);
        }
        return null;
    }

    public void shuffleCards() {
        Collections.shuffle(theCards);
    }

    public void fill() {
        theCards.clear();
        for (Rank rank: Rank.values()) {
            for (Suit suit: Suit.values()) {
                theCards.add(new Card(rank, suit));
            }
        }

    }

    public String toString() {
        String result = "Cards remaining in deck: " + theCards;
        return result;
    }

}
