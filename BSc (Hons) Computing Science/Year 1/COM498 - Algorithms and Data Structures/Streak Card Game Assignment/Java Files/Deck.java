import java.util.Random;

public class Deck {

    private static final int NUMCARDS = 52;
    private final Card[] CARDS = new Card[52];
    private int cardIndex;

    public Deck() {
        for (int thisCard = 0; thisCard < NUMCARDS; thisCard++) {
            this.CARDS[thisCard] = new Card(thisCard % 13, thisCard / 13);
        }
        this.cardIndex = NUMCARDS - 1;
        // THIS IS A DEBUG MESSAGE
        // System.out.println("\nThese are the cards in the deck before being shuffled.");
        // for (int i = 0; i < NUMCARDS; i++) System.out.println(i + ": " + this.CARDS[i]);
        this.shuffle();
        // THIS IS A DEBUG MESSAGE
        // System.out.println("\nThese are the cards in the deck after being shuffled.");
        // for (int i = 0; i < NUMCARDS; i++) System.out.println(i + ": " + this.CARDS[i]);
    }

    private void shuffle() {
        int index;
        Card temp;

        // THIS IS A DEBUGGING MESSAGE
        // System.out.println("\nBeginning Card Shuffle:");

        Random random = new Random();
        for (int i = this.CARDS.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = this.CARDS[index];
            // THIS IS A DEBUGGING MESSAGE
            // System.out.println("Card at Position: "+ index + " (" + this.CARDS[index] + ") has been selected to be swapped with card at position: " + i + "(" + this.CARDS[i] + ")");
            this.CARDS[index] = this.CARDS[i];
            this.CARDS[i] = temp;
        }
    }

    public Card deal() {
        // THIS IS A DEBUG MESSAGE
        // System.out.println("\nThe card dealt was: " + this.CARDS[this.cardIndex]);
        return this.CARDS[this.cardIndex--];
    }



    /* Redundant implementation of ListChain in the Deck Class
    private final ListChain<Card> CARDS = new ListChain<Card>();
    private int cardIndex = 52;

    public Deck() {
        for (int thisCard = 0; thisCard < 52; thisCard++) {
            this.CARDS.add(new Card(thisCard % 13, thisCard / 13));
        }
        this.shuffle();
    }

    private void shuffle() {
        int index;
        Card temp;

        Random random = new Random();
        for (int i = this.CARDS.getLength(); i > 0; i--) {
            index = 1+ random.nextInt(i + 1);
            temp = this.CARDS.getEntry(index);

            this.CARDS.replace(index, this.CARDS.getEntry(i));
            this.CARDS.replace(i, temp);
        }
    }

    public Card deal() {
        return this.CARDS.getEntry(this.cardIndex--);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        for (int i = 1; i <= 52; i++) {
            System.out.println(i + ": " + deck.deal());
        }

    }
     */
}