import java.util.ArrayList;

public abstract class Hand<T extends Card> {

    ArrayList<T> cards;
    Deck deck;

    public Hand(Deck deck) {
        this.cards = new ArrayList<T>();
        this.deck = deck;
    }

    public abstract void addCard();

    public void discard(T card) {
        cards.remove(card);
    }

    public void discardAll() {
        cards = new ArrayList<T>();
    }
}