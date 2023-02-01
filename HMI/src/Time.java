import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

public class Time extends Thread{
    JLabel timeLabel = new JLabel();
    static int value = 1;
    static JButton[] buttons;
    JLabel scoreLabel;
    JButton startButton;
    JScrollPane scrollPane;
    JTextField nameInput;
    Time(JLabel timeLabel, JLabel scoreLabel ,JButton[] buttons, JButton startButton, JScrollPane scrollPane, JTextField nameInput){
        this.timeLabel = timeLabel;
        this.buttons = buttons;
        this.scoreLabel = scoreLabel;
        this.startButton = startButton;
        this.scrollPane = scrollPane;
        this.nameInput = nameInput;
    }
    Time(){}
    public void run() {
        setValue(1);

        for(int i = 10; i >= 0; i--){
            setTime(i);
            sleep(1000);
            if(i == 15){
                setValue(2);
            }
            if(i == 1){
                timeLabel.setVisible(false);
                buttons[0].setVisible(false);
                buttons[1].setVisible(false);
                buttons[2].setVisible(false);
                buttons[3].setVisible(false);
                scoreLabel.setVisible(false);
                startButton.setVisible(true);
                scrollPane.setVisible(true);
                nameInput.setVisible(true);

                //replaces whitespace char with underscore
                String nameCorrected = nameInput.getText();
                nameCorrected = nameCorrected.replaceAll(" ", "_");
                //https://stackoverflow.com/questions/9461306/how-to-change-spaces-to-underscore-and-make-string-case-insensitive

                ArrayList<Player> playerList = FileHandler.readFile("HMI/src/scores.txt");
                int score = Integer.parseInt(scoreLabel.getText());

                try {
                    FileHandler.write(playerList, score, nameCorrected, "HMI/src/scores.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Main.readScoresFromFile();
                setValue(0);
                ButtonsListener.score = 0;
            }
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
    public static void setValue(int x) {
        value = x;
    }
    public void setTime(int x) {
        timeLabel.setText("" + x);
    }
    public static int getValue(){
        return value;
    }

    public static JButton getButton(int x){
        return buttons[x];
    }

}
