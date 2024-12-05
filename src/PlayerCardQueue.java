
public class PlayerCardQueue {
	Card head;
    int size;

    void enqueue(Card card) {
        if (head == null) {
            head = card;
        } else {
            Card current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = card;
        }
        size++;
    }

    Card dequeue() {
        if (head == null) return null;
        Card temp = head;
        head = head.next;
        size--;
        return temp;
    }

    void sortByRank() {
        String[] rankOrder = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        if (head == null || head.next == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            Card current = head;
            Card prev = null;
            
            while (current.next != null) {
                int currentRankIndex = getRankIndex(current.rank, rankOrder);
                int nextRankIndex = getRankIndex(current.next.rank, rankOrder);
                
                if (currentRankIndex > nextRankIndex) {
                    // Swap cards
                    Card temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    
                    if (prev == null) {
                        head = temp;
                    } else {
                        prev.next = temp;
                    }
                    
                    swapped = true;
                    prev = temp;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    private int getRankIndex(String rank, String[] rankOrder) {
        for (int i = 0; i < rankOrder.length; i++) {
            if (rankOrder[i].equals(rank)) return i;
        }
        return -1;
    }

    void printCards() {
        Card current = head;
        while (current != null) {
            System.out.println(current.rank + " of " + current.suit);
            current = current.next;
        }
    }

}
