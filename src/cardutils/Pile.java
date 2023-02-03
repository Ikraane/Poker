package cardutils;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    ArrayList<Card> pile = null;
    public Pile(){
        pile = new ArrayList<Card>();
    }
    public int getSize(){
        return pile.size();
    }
    public void clear(){
        pile.clear();
    }
    public boolean add(Card c){
        return pile.add(c);
    }
    public void add(List<Card> cards){
        pile.addAll(cards);
    }
    public Card get(int position){
        return pile.get(position);
    }
    //The code is borrowed from https://www.tabnine.com/code/java/methods/java.util.List/copyOf
    public List<Card> getCards(){
        return List.copyOf(pile);
    }
    //The code is borrowed from https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
    public Card remove(int position){
        return pile.remove(position);
    }
    public boolean remove(Card c){
        return pile.remove(c);
    }
    public boolean contains(Card c){
        return pile.contains(c);
    }
    public boolean remove(List<Card> cards){
        return pile.removeAll(cards);
    }
    //The code is borrowed from https://gist.github.com/suufi/5d5cc454d641ab2ae43ecb0eb0035503
    public int noOfSuits(Suit suit){
        int nrS = 0;
        for (Card card : pile) {
            if (card.getSuit() == suit) {
                nrS++;
            }
        }
        return nrS;
    }
    public int noOfRank(Rank rank){
        int nrR = 0;
        for (Card card : pile) {
            if (card.getRank() == rank) {
                nrR++;
            }
        }
        return nrR;
    }

    @Override
    public String toString(){
        String result = "\n " + pile;
        return result;
    }
}
