import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ClickPage {
    //when app launches: startpanel should be seen first, last-score is 0, user needs to enter a name before start
    //after user finished game: return to start page, last-score and score-board updates with entered name, name field is clear again

    // ### basis ###
    JFrame mainframe = new JFrame();    //application frame
    JPanel startPanel = new JPanel();   //start page (score-board, last-score, enter-name, start-button, eval. link) -> (Maybe 3 seconds counter before start)
    JPanel gamePanel = new JPanel();    //actual game (score, time, buttons)

    // ### startPanel ###
    JLabel lastScore = new JLabel();
    JTextField enterName = new JTextField();
    JButton startButton = new JButton();
    JLabel evalLink = new JLabel();
    
    // ### gamePanel ###
    JLabel scoreLabel = new JLabel();
    JLabel timeLabel;
    JButton[] buttons = new JButton[4];
    static int score = 0;

    ClickPage() {
        //game page
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(1920, 1080);
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.getContentPane().setBackground(Color.WHITE);
        mainframe.setLayout(null);
        mainframe.setVisible(true);

        scoreLabel.setBounds(480, 440, 400, 100);
        scoreLabel.setText("" + score);
        scoreLabel.setFont(new Font("Dialog", 0, 100));
        mainframe.add(scoreLabel);

        ActionListener actionListener = new ActionListener(buttons, scoreLabel, score);

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(actionListener);
            buttons[i].setBackground(Color.RED);
            buttons[i].setFocusable(false);
            mainframe.add(buttons[i]);
        }

        buttons[0].setBackground(Color.GREEN);
        buttons[0].setBounds(10, 960, 945, 50);
        buttons[1].setBounds(10, 900, 945, 50);
        buttons[2].setBounds(970, 960, 945, 50);
        buttons[3].setBounds(970, 900, 945, 50);

        Time time_thread = new Time(buttons);
        this.timeLabel = time_thread.get_label();
        mainframe.add(this.timeLabel);
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
