import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class StartPage {
    JFrame frame = new JFrame();
    JLabel startLabel = new JLabel();
    JButton startButton = new JButton();
    JTextArea scoresTextArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane();
    StartPage() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setVisible(true);




//        startLabel to center
        startLabel.setBounds(800, 100, 400, 100);
        startLabel.setText("Start");
        startLabel.setFont(new Font("Dialog", Font.PLAIN, 100));
        frame.add(startLabel);

        startButton.setBounds(700, 500, 400, 100);
        startButton.setText("Start Game");
        startButton.setBackground(Color.GREEN);
        startButton.setFocusable(false);
        frame.add(startButton);

        scrollPane.setBounds(50, 50, 400, 800);
        scoresTextArea.setEditable(false);
        scoresTextArea.setLineWrap(true);
        scoresTextArea.setWrapStyleWord(true);
        scrollPane.setViewportView(scoresTextArea);
        frame.add(scrollPane);

        // read the scores from the file and add them to the textarea
        try {
            BufferedReader br = new BufferedReader(new FileReader("HMI/src/scores.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int score = Integer.parseInt(parts[0].replace("(", "").replace(")", ""));
                String name = parts[1];
                scoresTextArea.append(name + " - " + score + "\n");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
