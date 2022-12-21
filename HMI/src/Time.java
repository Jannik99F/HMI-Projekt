import javax.swing.*;
import java.awt.*;

public class Time extends Thread{
    static int value = 1;
    int stop = 1;
    JLabel timeLabel = new JLabel();
    JButton[] buttons = new JButton[4];

    public Time(JButton[] buttons){
        this.buttons = buttons;
    }

    public void run() {
        for(int i = 30; i >= 0; i--){
            setTime(i);
            sleep(1000);
            if(i == 15){
                setValue(2);
            }
            if(i == 1){
                setValue(0);
                buttons[0].setVisible(false);
                buttons[1].setVisible(false);
                buttons[2].setVisible(false);
                buttons[3].setVisible(false);
            }
        }
    }

    public static void setValue(int x) {
        value = x;
    }
    public int getValue(){
        return value;
    }

    public void setTime(int x) {
        timeLabel.setText("" + x);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    public JLabel get_label() {
        timeLabel.setBounds(1400, 440, 400, 100);
        timeLabel.setText("30");
        timeLabel.setFont(new Font("Dialog", 0, 100));
        return timeLabel;
    }
}
