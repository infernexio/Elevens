import java.util.List;
import java.util.ArrayList;
/**
 * @author - Sohail Shaik
 * @Date - Apr 8, 2020
 * @Assignment - Deck.java
 */

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class SSDeck {
	
	/*Questions
	 * 1.) a deck has-a card there is a has a reletionship
	 * 2.)this deck contains 2 cards
	 * 3.)  a - String[] ranks = {"2","3","4","5","6","7","8","10","jack", "queen", "king","ace"};
	 * 		b - String[] suits = {"spades", "hearts", "diamonds", "clubs"};
	 * 		c - int[] pointValues = {2,3,4,5,6,7,8,9,10,10,10,10,11};
	 * 4.) order doesn't matter 
	 */

	/**
	 * cards contains all the cards in the deck.
	 */
	private List<SSCard> cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int numNotDealt;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public SSDeck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<SSCard>();
		for(int i = 0; i < ranks.length; i++) {
			for(int j = 0; j < suits.length; j++) {
			cards.add(new SSCard(ranks[i], suits[j], values[i]));
			}
		}
		numNotDealt = cards.size();
		
		shuffle();
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		if(numNotDealt == 0) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return numNotDealt;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public SSCard deal() {
		if(!isEmpty()) {
			SSCard cr = cards.remove(numNotDealt-1);
			numNotDealt--;
			return cr;
		}else {
			return null;
		}
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "Num not dealt = " + numNotDealt + "\nUndealt cards: \n";

		for (int k = numNotDealt - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((numNotDealt - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= numNotDealt; k--) {
			rtn = rtn + cards.get(k);
			if (k != numNotDealt) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}