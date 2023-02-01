import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    JButton[] buttons;
    JLabel scoreLabel;
    int score;
    JButton startButton;
    JFrame frame;

    public ActionListener(JButton[] buttons, JLabel scoreLabel, int score){
        this.buttons = buttons;
        this.scoreLabel = scoreLabel;
        this.score = score;
    }
    public ActionListener(JButton startButton, JFrame frame) {
        this.startButton = startButton;
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e) {
        //todo if button get clicked
        Time time = new Time(buttons);
        if (e.getSource() == startButton){
            //frame.dispose();
            ClickPage clickPage = new ClickPage(frame);
        }else {for (int i = 0; i < 4; i++) {
                if (e.getSource() == buttons[i]) {
                    if (buttons[i].getBackground() == Color.GREEN) {
                        score += time.getValue();
                    } else score -= time.getValue();
                    scoreLabel.setText("" + score);
                }
            }
        }
    }
}
