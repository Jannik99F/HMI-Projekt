import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    JButton[] buttons;
    JLabel scoreLabel;
    int score;

    public ActionListener(JButton buttons[], JLabel scoreLabel, int score){
        this.buttons = buttons;
        this.scoreLabel = scoreLabel;
        this.score = score;
    }

    public void actionPerformed(ActionEvent e) {
        //todo if button get clicked
        Time time = new Time(buttons);

        for (int i = 0; i < 4; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getBackground() == Color.GREEN) {
                    score += time.getValue();
                } else score -= time.getValue();
                scoreLabel.setText("" + score);
            }
        }
    }
}
