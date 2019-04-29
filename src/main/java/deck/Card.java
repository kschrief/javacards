package deck;

import exceptions.BadParameterException;

public class Card {
    private Suit suit;
    private int value;

    public Card(int value, Suit suit) throws BadParameterException {

        if (value < 1 || value > 13) {
            throw new BadParameterException("Invalid card value. Must be between 0-13");
        }

        if (suit == null) {
            throw new BadParameterException("Must provide valid Suite");
        }

        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    enum Suit {
        Heart("Red"), Spade("Red"), Club("Black"), Diamond("Black");

        private String value;

        private Suit(String color) {
            this.value = color;
        }

        public String getColor() {
            return value;
        }
    }
}
