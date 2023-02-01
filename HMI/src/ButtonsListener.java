import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class ButtonsListener implements ActionListener {
    JButton[] buttons;
    static int score;
    JLabel scoreLabel;

    ButtonsListener(JButton[] buttons, JLabel scoreLabel){
        this.buttons = buttons;
        this.scoreLabel = scoreLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Time time = new Time();

        for (int i = 0; i < 4; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getBackground() == Color.GREEN) {
                    score += time.getValue();
                } else {
                    score -= time.getValue();

                    Color customColor = new Color(255, 204, 203);
                    Main.frame.getContentPane().setBackground(customColor);
                    //changes bg colour for specific time
                    Timer timer = new Timer(180, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            Main.frame.getContentPane().setBackground(Color.WHITE);
                        }
                    });
                    timer.setRepeats(false); // Only execute once
                    timer.start();
                    //https://stackoverflow.com/questions/2258066/run-a-java-function-after-a-specific-number-of-seconds

                }
                scoreLabel.setText("" + score);
            }
        }
    }
}
