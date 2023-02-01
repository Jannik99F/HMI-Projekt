import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static JButton startButton = new JButton("Start");
    static JFrame frame = new JFrame("Click Competition");
    static JLabel timeLabel = new JLabel();
    static JButton[] buttons = new JButton[4];
    static JLabel scoreLabel = new JLabel();
    private static final String SCORES_FILE = "HMI/src/scores.txt";
    public static final JTextArea scoresTextArea = new JTextArea();
    public static JTextField nameInput = new JTextField();



    public static void main(String[] args) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        startButton.setBackground(Color.GREEN);
        startButton.setFocusable(false);
        startButton.setBounds(860, 440, 200, 100);
        startButton.setVisible(true);

        nameInput.setBounds(860, 240, 200, 100);
        nameInput.setVisible(true);
        nameInput.setText("Enter your name here!");
        frame.add(nameInput);

        timeLabel.setBounds(1400, 440, 400, 100);
        timeLabel.setText("30");
        timeLabel.setFont(new Font("Dialog", 0, 100));
        timeLabel.setVisible(false);
        frame.add(timeLabel);

        //ArrayList<Player> playersList = new ArrayList<>();
        JScrollPane scrollPane = new JScrollPane();

        ActionListener startListener = new StartListener(startButton, frame, timeLabel,scoreLabel, buttons, scrollPane, nameInput);
        startButton.addActionListener(startListener);
        frame.add(startButton);

        scoreLabel.setBounds(480, 440, 400, 100);
        scoreLabel.setFont(new Font("Dialog", Font.PLAIN, 100));
        frame.add(scoreLabel);

        ActionListener buttonsListener = new ButtonsListener(buttons, scoreLabel);

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(buttonsListener);
            buttons[i].setBackground(Color.RED);
            buttons[i].setFocusable(false);
            buttons[i].setVisible(false);
            frame.add(buttons[i]);
        }

        buttons[0].setBackground(Color.GREEN);
        buttons[0].setBounds(10, 960, 945, 50);
        buttons[1].setBounds(10, 900, 945, 50);
        buttons[2].setBounds(970, 960, 945, 50);
        buttons[3].setBounds(970, 900, 945, 50);

        scrollPane.setBounds(760, 600,400,400);
        scrollPane.setVisible(true);

        scrollPane.setViewportView(scoresTextArea);
        scoresTextArea.setEditable(false);
        scoresTextArea.setLineWrap(true);
        scoresTextArea.setWrapStyleWord(true);

        readScoresFromFile();
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public static void readScoresFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(SCORES_FILE))) {
            //cleares score field to avoid duplicates
            scoresTextArea.selectAll();
            scoresTextArea.replaceSelection("");
            //https://stackoverflow.com/questions/15798532/how-to-clear-jtextarea#:~:text=JTextArea0.,string%2C%20effectively%20clearing%20the%20JTextArea.

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int score = Integer.parseInt(parts[0].replace("(", "").replace(")", ""));
                String name = parts[1];
                scoresTextArea.append(name + "  =  " + score + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}