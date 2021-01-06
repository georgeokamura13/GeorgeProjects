import java.util.ArrayList;

public class BlackJackDeck extends Deck{

    public BlackJackDeck() {
        reset();
    }

    @Override
    public void reset() {
        this.deck = new ArrayList<Card>();
        this.deck.add(new BlackJackcard(Suit.CLUB, 1));
        this.deck.add(new BlackJackcard(Suit.CLUB, 2));
        this.deck.add(new BlackJackcard(Suit.CLUB, 3));
        this.deck.add(new BlackJackcard(Suit.CLUB, 4));
        this.deck.add(new BlackJackcard(Suit.CLUB, 5));
        this.deck.add(new BlackJackcard(Suit.CLUB, 6));
        this.deck.add(new BlackJackcard(Suit.CLUB, 7));
        this.deck.add(new BlackJackcard(Suit.CLUB, 8));
        this.deck.add(new BlackJackcard(Suit.CLUB, 9));
        this.deck.add(new BlackJackcard(Suit.CLUB, 10));
        this.deck.add(new BlackJackcard(Suit.CLUB, 11));
        this.deck.add(new BlackJackcard(Suit.CLUB, 12));
        this.deck.add(new BlackJackcard(Suit.CLUB, 13));
        this.deck.add(new BlackJackcard(Suit.SPADE, 1));
        this.deck.add(new BlackJackcard(Suit.SPADE, 2));
        this.deck.add(new BlackJackcard(Suit.SPADE, 3));
        this.deck.add(new BlackJackcard(Suit.SPADE, 4));
        this.deck.add(new BlackJackcard(Suit.SPADE, 5));
        this.deck.add(new BlackJackcard(Suit.SPADE, 6));
        this.deck.add(new BlackJackcard(Suit.SPADE, 7));
        this.deck.add(new BlackJackcard(Suit.SPADE, 8));
        this.deck.add(new BlackJackcard(Suit.SPADE, 9));
        this.deck.add(new BlackJackcard(Suit.SPADE, 10));
        this.deck.add(new BlackJackcard(Suit.SPADE, 11));
        this.deck.add(new BlackJackcard(Suit.SPADE, 12));
        this.deck.add(new BlackJackcard(Suit.SPADE, 13));
        this.deck.add(new BlackJackcard(Suit.HEART, 1));
        this.deck.add(new BlackJackcard(Suit.HEART, 2));
        this.deck.add(new BlackJackcard(Suit.HEART, 3));
        this.deck.add(new BlackJackcard(Suit.HEART, 4));
        this.deck.add(new BlackJackcard(Suit.HEART, 5));
        this.deck.add(new BlackJackcard(Suit.HEART, 6));
        this.deck.add(new BlackJackcard(Suit.HEART, 7));
        this.deck.add(new BlackJackcard(Suit.HEART, 8));
        this.deck.add(new BlackJackcard(Suit.HEART, 9));
        this.deck.add(new BlackJackcard(Suit.HEART, 10));
        this.deck.add(new BlackJackcard(Suit.HEART, 11));
        this.deck.add(new BlackJackcard(Suit.HEART, 12));
        this.deck.add(new BlackJackcard(Suit.HEART, 13));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 1));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 2));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 3));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 4));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 5));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 6));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 7));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 8));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 9));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 10));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 11));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 12));
        this.deck.add(new BlackJackcard(Suit.DIAMOND, 13));

        this.shuffle();
    }
}
