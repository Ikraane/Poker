package ps;

import cardutils.*;


public class PokerHands {

    private PokerHands(){

    }
//Part of the code is borrowed from https://gist.github.com/suufi/5d5cc454d641ab2ae43ecb0eb0035503
    // Also from https://github.com/evancoa/Poker-Solitaire/blob/master/PokerHand.java

    public static PokerCombo getPokerCombo(Pile hand) {

        if(four(hand)) {
            return PokerCombo.FOUR;
        }
        else if(flush(hand)){
            return PokerCombo.FLUSH;
        }
        else if(triss(hand)){
            return PokerCombo.TRISS;
        }
        else if(twoPair(hand)){
            return PokerCombo.TWOPAIR;
        }
        else if(pair(hand)) {
            return PokerCombo.PAIR;
        }
        else{
            return PokerCombo.NONE;
        }
    }

    public static boolean twoPair(Pile hand){
        int checkPair = 0;
        for(Rank rank : Rank.values()){
            if(hand.noOfRank(rank) == 2){
                checkPair++;
            }
        }
        if(checkPair == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean pair(Pile hand) {
        for (Rank rank : Rank.values()) {
            if (hand.noOfRank(rank) == 2) {
                return true;
            }
        }
        return false;

    }

    public static boolean four(Pile hand){

        for (int i = 0; i < Rank.values().length; i++) {
            boolean rank = hand.noOfRank(Rank.values()[i]) == 4;
            if (rank) {
                return true;
            }

        }

        return false;
    }

    public static boolean flush(Pile hand) {
        for (Suit suit : Suit.values()) {
            if (hand.noOfSuits(suit) == 5) {
                return true;
            }
        }
        return false;

    }

    public static boolean triss(Pile hand) {
        for (int i = 0; i < Rank.values().length; i++) {
            boolean rank = hand.noOfRank(Rank.values()[i]) == 3;
            if (rank) {
                return true;
            }
        }
        return false;

    }

}