
public class Player {
	String name;
    PlayerCardQueue cardQueue;

    Player(String name) {
        this.name = name;
        this.cardQueue = new PlayerCardQueue();
    }

}
