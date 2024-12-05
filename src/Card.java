
public class Card {
	String rank;
    String suit;
    Card next;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.next = null;
    }

}
