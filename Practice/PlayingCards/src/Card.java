/**
 * What does each card have? A suit and a numerical value.
 * Let's assume Ace is 1, Jack is 11, Queen is 12, and King is 13
 */
public class Card {

    private Suit suit;
    private int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String result = "";
        switch(this.value) {
            case 1:
                result += "Ace";
                break;
            case 11:
                result += "Jack";
                break;
            case 12:
                result += "Queen";
                break;
            case 13:
                result += "King";
                break;
            default:
                result += String.valueOf(this.value);
                break;

        }

        result += " of ";

        switch(this.suit) {
            case SPADE:
                result += "Spades";
                break;
            case CLUB:
                result += "Clubs";
                break;
            case HEART:
                result += "Hearts";
                break;
            case DIAMOND:
                result += "Diamonds";
                break;
        }

        return result;
    }
}
