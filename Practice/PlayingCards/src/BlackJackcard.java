public class BlackJackcard extends Card{

    public BlackJackcard(Suit suit, int value) {
        super(suit, value);
    }

    @Override
    public int getValue() {
        if(isAce())  {
            return 1;
        }
        else if(isFaceCard()) {
            return 10;
        }

        return super.getValue();
    }

    public boolean isAce() {
        return super.getValue() == 1;
    }

    public boolean isFaceCard() {
        return super.getValue() >= 11 && super.getValue() <= 13;
    }

    public int getMaxValue() {
        if(isAce())  {
            return 11;
        }
        else if(isFaceCard()) {
            return 10;
        }

        return super.getValue();
    }

    public int getMinValue() {
        if(isAce())  {
            return 1;
        }
        else if(isFaceCard()) {
            return 10;
        }

        return super.getValue();
    }
}
