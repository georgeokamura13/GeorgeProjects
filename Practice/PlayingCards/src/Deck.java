import java.util.ArrayList;
import java.util.Collections;

public abstract class Deck<T extends Card> {

    ArrayList<T> deck;

    public abstract void reset();

    public void shuffle() {
        System.out.println("Shuffling deck... ");
        Collections.shuffle(this.deck);
    }

    public Card draw() {
        Card card = this.deck.remove(0);
        return card;
    }
}
