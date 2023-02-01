import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                    //Main.frame.getContentPane().setBackground(Color.RED);
                    //time.sleep(1000);
                    //Main.frame.getContentPane().setBackground(Color.WHITE);
                }
                scoreLabel.setText("" + score);
            }
        }
    }
}
