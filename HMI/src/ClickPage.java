import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.lang.Thread.sleep;

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
        scoreLabel.setFont(new Font("Dialog", Font.PLAIN, 100));
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
            try {
                sleep(new Random().nextInt(4) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            changeColor();
            System.out.println("Pause");
        }
    }

    public void changeColor() {
        int x = new Random().nextInt(4);
        for (JButton button : buttons) {
            button.setBackground(Color.RED);
        }
        buttons[x].setBackground(Color.GREEN);
        try {
            sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
