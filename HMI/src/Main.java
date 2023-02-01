import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static JButton startButton = new JButton("Start");
    static JFrame frame = new JFrame("Click Competition");
    static JLabel timeLabel = new JLabel();
    static JButton[] buttons = new JButton[4];
    static JLabel scoreLabel = new JLabel();
    private static final String SCORES_FILE = "HMI/src/scores.txt";
    public static final JTextArea scoresTextArea = new JTextArea();
    public static JTextField nameInput = new JTextField();
    public static JTextField evalLink = new JTextField();


    public static void main(String[] args) {

        //change design to nimbus
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("An error has occurred, program exit.");
            }
        }
        //source: https://stackoverflow.com/questions/4617615/how-to-set-nimbus-look-and-feel-in-main

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //startpage
        startButton.setBackground(Color.GREEN);
        startButton.setFocusable(false);
        startButton.setBounds(400, 230, 200, 100);
        startButton.setVisible(true);

        //startpage
        nameInput.setBounds(400, 140, 200, 40);
        nameInput.setVisible(true);
        nameInput.setText("Enter your name here!");
        frame.add(nameInput);

        //startpage
        evalLink.setBounds(185, 700, 630, 40);
        evalLink.setText("Bitte nimm dir kurz Zeit und Bewerte das Spiel, kopiere dazu folgenden Link: https://forms.gle/wsoBcjnE9GfFPiF7A");
        evalLink.setBackground(Color.LIGHT_GRAY);
        evalLink.setVisible(false);
        evalLink.setEditable(false);
        frame.add(evalLink);

        //gamepage
        timeLabel.setBounds(650, 240, 400, 100);
        timeLabel.setText("30");
        timeLabel.setFont(new Font("Dialog", 0, 100));
        timeLabel.setVisible(false);
        frame.add(timeLabel);

        JScrollPane scrollPane = new JScrollPane();

        ActionListener startListener = new StartListener(startButton, frame, timeLabel,scoreLabel, buttons, scrollPane, nameInput, evalLink);
        startButton.addActionListener(startListener);
        frame.add(startButton);

        //gamepage
        scoreLabel.setBounds(250, 240, 400, 100);
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
        buttons[0].setBounds(10, 550, 485, 100);
        buttons[1].setBounds(10, 650, 485, 100);
        buttons[2].setBounds(495, 550, 480, 100);
        buttons[3].setBounds(495, 650, 480, 100);

        scrollPane.setBounds(300, 370,400,300);
        scrollPane.setVisible(true);

        scrollPane.setViewportView(scoresTextArea);
        scoresTextArea.setEditable(false);
        scoresTextArea.setLineWrap(true);
        scoresTextArea.setWrapStyleWord(true);
        //scoresTextArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

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