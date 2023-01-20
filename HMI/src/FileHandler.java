import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    //Einlesen der scores von text file in Arraylist und zurückgeben
    public ArrayList<Player> readFile(String filePath) {
        ArrayList<Player> players = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\) ");//regex um score in klammern und name zu trennen
                int score = Integer.parseInt(parts[0].substring(1));
                String name = parts[1];
                Player player = new Player(score, name);
                players.add(player);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file '" + filePath + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file '" + filePath + "'.");
        }
        return players;
    }
    public static void write(int score, String name, String filePath) throws IOException {
        //File path als "src/scores.txt" übergeben
        //zb Filehandler.write(score, name, "src/scores.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.write("(" + score + ")" + " " + name);//score wird in Klammern gespeichert
        writer.newLine();
        writer.close();
    }

}
