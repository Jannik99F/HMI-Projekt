import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ClickPage {
    JFrame frame = new JFrame();
    JLabel scoreLabel = new JLabel();
    static JLabel timeLabel = new JLabel();
    static JButton[] buttons = new JButton[4];
    static int score = 0;

    ClickPage() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setVisible(true);

        scoreLabel.setBounds(480, 440, 400, 100);
        scoreLabel.setText("" + score);
        scoreLabel.setFont(new Font("Dialog", 0, 100));
        frame.add(scoreLabel);

        timeLabel.setBounds(1400, 440, 400, 100);
        timeLabel.setText("" + score);
        timeLabel.setFont(new Font("Dialog", 0, 100));
        frame.add(timeLabel);

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this::actionPerformed);
            buttons[i].setBackground(Color.RED);
            buttons[i].setFocusable(false);
            frame.add(buttons[i]);
        }

        buttons[0].setBackground(Color.GREEN);
        buttons[0].setBounds(10, 960, 945, 50);
        buttons[1].setBounds(10, 900, 945, 50);
        buttons[2].setBounds(970, 960, 945, 50);
        buttons[3].setBounds(970, 900, 945, 50);

        sleep(1000);
        changeColor();
        System.out.println("Pause");
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        //todo if button get clicked
        Time time = new Time();

        for (int i = 0; i < 4; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getBackground() == Color.GREEN) {
                    score += time.getValue();
                } else score -= time.getValue();
                scoreLabel.setText("" + score);
            }
        }
    }

    public static int getRandomNumber(int x) {
        Random random = new Random();
        int randomNumber = random.nextInt(x);
        return randomNumber;
    }

    public static void changeColor() {
        int x = getRandomNumber(3);
        buttons[0].setBackground(Color.RED);
        buttons[1].setBackground(Color.RED);
        buttons[2].setBackground(Color.RED);
        buttons[3].setBackground(Color.RED);
        buttons[x].setBackground(Color.GREEN);
    }

    public static void setTime(int x) {
        timeLabel.setText("" + x);
    }
}

