import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //ClickPage clickPage = new ClickPage();


        // Test Methode

        FileHandler fileHandler = new FileHandler();
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(100, "Max"));
        players.add(new Player(200, "Moritz"));
        players.add(new Player(300, "Maximilian"));
        players.add(new Player(400, "Elias"));
        players.add(new Player(500, "Johannes"));
        fileHandler.sort(players);
        fileHandler.write(players, "HMI/src/scores.txt");
        ArrayList<Player> stuff = fileHandler.readFile("HMI/src/scores.txt");
        for (Player player : stuff) {
            System.out.println(player.getScore() + " " + player.getName());
        }



    }

}