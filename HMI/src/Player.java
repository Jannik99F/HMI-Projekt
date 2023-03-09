public class Player implements Comparable<Player> {
    private int score;
    private String name;

    public Player() {}

    public Player(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Player player) {
        return Integer.compare(player.getScore(), this.score);
    }
}
