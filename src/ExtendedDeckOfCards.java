
public class ExtendedDeckOfCards {

	public static void main(String[] args) {
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        Card[] deck = new Card[suits.length * ranks.length];
        int cardIndex = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[cardIndex++] = new Card(rank, suit);
            }
        }
        java.util.Random random = new java.util.Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        Player[] players = {
            new Player("Player 1"),
            new Player("Player 2"),
            new Player("Player 3"),
            new Player("Player 4")
        };
        for (int player = 0; player < 4; player++) {
            for (int card = 0; card < 9; card++) {
                players[player].cardQueue.enqueue(deck[player * 9 + card]);
            }
            players[player].cardQueue.sortByRank();
        }
        for (Player player : players) {
            System.out.println("\n" + player.name + " cards:");
            player.cardQueue.printCards();
        }
    }
}
