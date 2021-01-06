import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackcard> {

    public BlackJackHand(BlackJackDeck deck) {
        super(deck);
    }

    public int score() {
        int result = 0;

        ArrayList<Integer> possibleScores = possiblesScores();
        for(Integer possibleScore : possibleScores) {
            if(possibleScore <= 21) {
                if(possibleScore > result) {
                    result = possibleScore;
                }
            }
        }

        // if no result less than or equal to 21 was found
        if(result == 0) {
            result = Integer.MAX_VALUE;
            for(Integer possibleScore : possibleScores) {
                if(possibleScore < result) {
                    result = possibleScore;
                }
            }
        }

        return result;
    }

    private ArrayList<Integer> possiblesScores() {

        ArrayList<Integer> possibleScores = new ArrayList<Integer>();
        possibleScores.add(new Integer(0));

        for(BlackJackcard card : cards) {
            if(card.isAce()) {
                ArrayList<Integer> possibleScoresClone = new ArrayList<Integer>();
                for(Integer possibleScore : possibleScores) {
                    int cardValue = 1;
                    int possibleScorevalue = possibleScore.intValue();
                    possibleScoresClone.add(cardValue + possibleScorevalue);
                }
                possibleScores = possibleScoresClone;

                possibleScoresClone = new ArrayList<Integer>();
                for(Integer possibleScore : possibleScores) {
                    int cardValue = 10;
                    int possibleScorevalue = possibleScore.intValue();
                    possibleScoresClone.add(possibleScorevalue);
                    possibleScoresClone.add(cardValue + possibleScorevalue);
                }
                possibleScores = possibleScoresClone;
            }
            else {
                ArrayList<Integer> possibleScoresClone = new ArrayList<Integer>();
                for(Integer possibleScore : possibleScores) {
                    int cardValue = card.getValue();
                    int possibleScorevalue = possibleScore.intValue();
                    possibleScoresClone.add(cardValue + possibleScorevalue);
                }
                possibleScores = possibleScoresClone;
            }
        }

        return possibleScores;
    }

    @Override
    public void addCard() {
        BlackJackcard newCard = (BlackJackcard) this.deck.draw();
        cards.add(newCard);
    }
}
