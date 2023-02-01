import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener {
    JButton startButton;
    JFrame frame;
    JLabel timeLabel;
    JLabel scoreLabel;
    JButton[] buttons;
    JScrollPane scrollPane;
    JTextField nameInput;
    StartListener(JButton startButton, JFrame frame, JLabel timeLabel, JLabel scoreLabel, JButton[] buttons, JScrollPane scrollPane, JTextField nameInput){
        this.frame = frame;
        this.startButton = startButton;
        this.timeLabel = timeLabel;
        this.scoreLabel = scoreLabel;
        this.buttons = buttons;
        this.scrollPane = scrollPane;
        this.nameInput = nameInput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (nameInput.getText().equals("")) {}
        else{
            nameInput.setVisible(false);
            startButton.setVisible(false);
            scrollPane.setVisible(false);
            timeLabel.setVisible(true);
            scoreLabel.setText("0");
            scoreLabel.setVisible(true);

            buttons[0].setVisible(true);
            buttons[1].setVisible(true);
            buttons[2].setVisible(true);
            buttons[3].setVisible(true);

            Thread time_thread = new Thread(new Time(timeLabel, scoreLabel, buttons, startButton, scrollPane, nameInput));
            Thread t2 = new Thread(new ColorChange());
            time_thread.start();
            t2.start();
        }
    }
}
