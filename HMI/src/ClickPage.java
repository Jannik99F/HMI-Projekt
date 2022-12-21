import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ClickPage {
    JFrame frame = new JFrame();
    JLabel scoreLabel = new JLabel();
    JLabel timeLabel;
    JButton[] buttons = new JButton[4];
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

        ActionListener actionListener = new ActionListener(buttons, scoreLabel, score);

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(actionListener);
            buttons[i].setBackground(Color.RED);
            buttons[i].setFocusable(false);
            frame.add(buttons[i]);
        }

        buttons[0].setBackground(Color.GREEN);
        buttons[0].setBounds(10, 960, 945, 50);
        buttons[1].setBounds(10, 900, 945, 50);
        buttons[2].setBounds(970, 960, 945, 50);
        buttons[3].setBounds(970, 900, 945, 50);

        Time time_thread = new Time(buttons);
        this.timeLabel = time_thread.get_label();
        frame.add(this.timeLabel);
        time_thread.start();

        for(int i = 0; i < 30; i++) {
            sleep(getRandomNumber(5) * 1000);
            changeColor();
            System.out.println("Pause");
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    public static int getRandomNumber(int x) {
        Random random = new Random();
        int randomNumber = random.nextInt(x);
        return randomNumber;
    }

    public void changeColor() {
        int timer = getRandomNumber(4);
        int x = getRandomNumber(3);
        buttons[0].setBackground(Color.RED);
        buttons[1].setBackground(Color.RED);
        buttons[2].setBackground(Color.RED);
        buttons[3].setBackground(Color.RED);
        buttons[x].setBackground(Color.GREEN);
        sleep(1000);
    }
}
