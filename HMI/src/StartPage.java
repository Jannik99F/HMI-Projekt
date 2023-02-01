import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StartPage {
    private static final int FRAME_WIDTH = 1920;
    private static final int FRAME_HEIGHT = 1080;
    private static final String BUTTON_TEXT = "Start Game";
    private static final String LABEL_TEXT = "Start";
    private static final String SCORES_FILE = "HMI/src/scores.txt";
    private final JFrame frame = new JFrame();
    private final JTextArea scoresTextArea = new JTextArea();

    StartPage() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);

        // Set layout
        frame.setLayout(new BorderLayout());

        JLabel startLabel = new JLabel(LABEL_TEXT);
        frame.add(startLabel, BorderLayout.CENTER);

        JButton startButton = new JButton(BUTTON_TEXT);
        frame.add(startButton, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane();
        frame.add(scrollPane, BorderLayout.EAST);

        startLabel.setFont(new Font("Dialog", Font.PLAIN, 100));
        startButton.setBackground(Color.GREEN);
        startButton.setFocusable(false);
        ActionListener actionListener = new ActionListener(startButton, frame);

        // Add action listener to the button
        startButton.addActionListener(actionListener);

        // Set properties of the scroll pane and text area
        scrollPane.setViewportView(scoresTextArea);
        scoresTextArea.setEditable(false);
        scoresTextArea.setLineWrap(true);
        scoresTextArea.setWrapStyleWord(true);

        // Read scores from file and add to the text area
        readScoresFromFile();

        frame.setVisible(true);
    }

    private void readScoresFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(SCORES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int score = Integer.parseInt(parts[0].replace("(", "").replace(")", ""));
                String name = parts[1];
                scoresTextArea.append(name + " - " + score + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

