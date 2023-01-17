public class Card{

    private final int RANK, SUIT;

    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card (int r, int s) {
        RANK = r;
        SUIT = s;
    }

    // This will return the String value of the corresponding String[].
    private String getRank() {
        return RANKS[RANK];
    }
    private String getSuit() {
        return SUITS[SUIT];
    }

    // This will return the elements position in the corresponding String[].
    private int getRankValue() { return RANK; }
    private int getSuitValue() { return SUIT; }

    // This is used to print out a Card object, symbols have been included to make it more intuitive.
    private static final String[] RANKS_SYMBOL = {"♧", "♢", "♡", "♤"};
    public String toString() { return RANKS_SYMBOL[getSuitValue()] + " " + getRank() + " of " + getSuit(); }

    public int compareTo(Card otherCard) {
        if (this.getRankValue() > otherCard.getRankValue()) return 1;
        else if (this.getRankValue() < otherCard.getRankValue()) return -1;
        else return 0;
    }

    // This method is used to find if the current card is equal to the value of the card given - 1 in String[] RANK, and will return either true or false depending on the outcome.
    public boolean isStreak(Card otherCard) { return this.getRankValue() == otherCard.getRankValue() - 1; }

    // This method will return the colour of this card.
    private String getColour() {
        if (getSuit().equals("Diamonds") || getSuit().equals("Hearts")) { return "Red"; }
        else return "Black";
    }

    // This method will return true if this card is the same colour of the other card given, false if otherwise.
    public boolean isColourBonus(Card otherCard) { return this.getColour().equals(otherCard.getColour()); }

    // This method will return true if this card is the same suit of the other card given, false if otherwise.
    public boolean isSuitBonus(Card otherCard) { return this.getSuit().equals(otherCard.getSuit()); }
}
