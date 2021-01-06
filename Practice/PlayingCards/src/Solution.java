import java.util.Scanner;

public class Solution {

    private enum gameOutcome {
        WIN,
        TIE,
        LOSE
    }

    private static void deal(BlackJackHand hand, BlackJackHand dealerHand) {
        // Deal out initial cards
        hand.addCard();
        dealerHand.addCard();
        hand.addCard();
        dealerHand.addCard();

        for(BlackJackcard card : hand.cards) {
            System.out.println("Cards in hand are currently: " + card);
        }
        System.out.println("One of the Cards in Dealer's hand is currently: " + dealerHand.cards.get(0));

        System.out.println("Your Black Jack score is: " + hand.score());
    }

    private static void printResults(BlackJackHand hand, BlackJackHand dealerHand, gameOutcome result) {

        System.out.println("\n---- RESULTS: ----");
        for(BlackJackcard card : hand.cards) {
            System.out.println("Cards in hand are currently: " + card);
        }
        for(BlackJackcard card : dealerHand.cards) {
            System.out.println("Cards in Dealer's hand are currently: " + card);
        }

        System.out.println("Your Black Jack score is: " + hand.score());
        System.out.println("Dealer's Black Jack score is: " + dealerHand.score());

        if(result == gameOutcome.WIN) {
            System.out.println("You win!");
        }
        else if(result == gameOutcome.LOSE) {
            System.out.println("You lose!");
        }
        else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {

        String playAgain;

        do {
            gameOutcome result = gameOutcome.TIE;

            BlackJackDeck deck = new BlackJackDeck();
            BlackJackHand hand = new BlackJackHand(deck);
            BlackJackHand dealerHand = new BlackJackHand(deck);

            deal(hand, dealerHand);

            if(hand.score() == 21) {
                System.out.println("21!");
                result = gameOutcome.WIN;
            }
            else if(dealerHand.score() == 21) {
                System.out.println("Dealer 21!");
                result = gameOutcome.LOSE;
            }

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String answer = "Y";

            while(answer.equalsIgnoreCase("Y") && result == gameOutcome.TIE) {
                System.out.println("Do you wish to draw again (Y/N): ");
                answer = myObj.nextLine();  // Read user input

                if (answer.equalsIgnoreCase("Y")) {

                    hand.addCard();

                    for (BlackJackcard card : hand.cards) {
                        System.out.println("Cards in hand are currently: " + card);
                    }
                    System.out.println("One of the Cards in Dealer's hand is currently: " + dealerHand.cards.get(0));
                    System.out.println("Your Black Jack score is: " + hand.score());

                    if(hand.score() > 21) {
                        System.out.println("Bust!");
                        result = gameOutcome.LOSE;
                    }
                    else if(hand.score() == 21) {
                        System.out.println("21!");
                        result = gameOutcome.WIN;
                    }
                }
            }

            if(result == gameOutcome.TIE) {
                int dealerScore = dealerHand.score();
                while(dealerScore <= 16) {
                    dealerHand.addCard();

                    dealerScore = dealerHand.score();
                    if(dealerScore > 21) {
                        System.out.println("Dealer Bust!");
                        result = gameOutcome.WIN;
                        break;
                    }
                    else if(dealerScore == 21) {
                        System.out.println("Dealer 21!");
                        result = gameOutcome.LOSE;
                        break;
                    }
                }

                if(dealerHand.score() < 21) {
                    if(hand.score() < dealerHand.score()) {
                        result = gameOutcome.LOSE;
                    }
                    else if(hand.score() > dealerHand.score()) {
                        result = gameOutcome.WIN;
                    }
                    else {
                        result = gameOutcome.TIE;
                    }
                }
            }


            printResults(hand, dealerHand, result);

            myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Do you wish to play again (Y/N): ");
            playAgain = myObj.nextLine();  // Read user input

        } while(playAgain.equalsIgnoreCase("Y"));

    }
}
