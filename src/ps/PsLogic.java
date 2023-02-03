package ps;

import cardutils.Card;
import cardutils.Pile;
import cardutils.Deck;

import java.util.ArrayList;
import java.util.List;

public class PsLogic implements IPsLogic {

    private Card nextCard = null;
    private Deck gameDeck;
    private ArrayList<Pile> piles;
    //Pile pile = new Pile();

    public PsLogic() {
        gameDeck = new Deck();
        piles = new ArrayList<Pile>(5);
        for (int i = 0; i < 5; i++) {
            piles.add(new Pile());
        }
    }

    @Override
    public void initNewGame() {

        gameDeck.fill();
        //gameDeck.shuffleCards();
        for (Pile pile : piles) {
            pile.clear();
        }
        gameDeck.shuffleCards();
    }

    @Override
    public Card pickNextCard() throws IllegalStateException {
        nextCard = null;
        if (nextCard != null) throw new IllegalStateException("\n two cards"); {
            //System.out.println(gameDeck);
            nextCard = gameDeck.dealCard();
            //System.out.println(getCardCount());
            //System.out.println(nextCard);
            return nextCard;
        }
    }

    @Override
    public void addCardToPile(int n) throws IllegalStateException {

        if (nextCard == null) throw new IllegalStateException("Card not picked"); {
            piles.get(n).add(nextCard);
            //System.out.println(piles);
        }
    }

    @Override
    public boolean isGameOver() {
        if (getCardCount() >= 25) {
            return true;
        }
        return false;
    }

    @Override
    public int getCardCount() {
        return (52 - gameDeck.getSize());
    }

    @Override
    public List<Pile> getPiles() {
        //System.out.println("get piles");
        return List.copyOf(piles);
    }

    @Override
    public int getPoints() {
        PokerCombo combo;
        int points = 0;
        for (Pile pile: piles) {
            combo = PokerHands.getPokerCombo(pile);
            points = points + combo.getValue();
        }
        return points;
    }
}
