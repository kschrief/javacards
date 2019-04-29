package deck;

import exceptions.BadParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Deck {
    private static Logger log = LoggerFactory.getLogger(Deck.class);
    public List<Card> cards;

    public Deck(boolean shuffled) throws BadParameterException {
        cards = new ArrayList<>();

        int counter = 0;

        for (Card.Suit suit : Card.Suit.values()) {
            for (int i = 0; i <= 13; i++, counter++) {
                cards.add(new Card(i, suit));
            }
        }

        if (shuffled) {
            shuffle();
        }
    }

    public boolean isValid() {
        if (cards == null || cards.size() != 52) {
            return false;
        }

        Map<Card.Suit, List<Card>> suits = new HashMap<>();

        for (Card card: cards) {
            if (!suits.containsKey(card.getSuit())) {
                suits.put(card.getSuit(), new ArrayList<>());
            }

            suits.get(card.getSuit()).add(card);
        }

        for (Map.Entry<Card.Suit, List<Card>> organizedSuit : suits.entrySet()) {
            Card.Suit tempSuit = organizedSuit.getKey();
            List<Card> cardsOfSuit = organizedSuit.getValue();

            if (cardsOfSuit == null || cardsOfSuit.size() != 13) {
                log.error("Suit " + tempSuit.name() + " does not contain 13 cards");
                return false;
            }

            Card[] organizedCards = new Card[13];

            for (Card card : cardsOfSuit) {
                if (organizedCards[card.getValue() - 1] != null) {
                    log.error("Suit " + tempSuit.name() + " contains duplicate: " + card.getValue());
                    return false;
                }

                organizedCards[card.getValue() - 1] = card;
            }
        }

        return true;
    }

    public void shuffle() {
        if (cards == null) {
            return;
        }

        Collections.shuffle(cards);
    }
}
