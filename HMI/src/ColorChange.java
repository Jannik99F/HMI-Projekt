import java.awt.*;
import java.util.Random;

public class ColorChange implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            int x = new Random().nextInt(4);
            Time.getButton(0).setBackground(Color.RED);
            Time.getButton(1).setBackground(Color.RED);
            Time.getButton(2).setBackground(Color.RED);
            Time.getButton(3).setBackground(Color.RED);
            Time.getButton(x).setBackground(Color.GREEN);

            int y = new Random().nextInt(2);
            Time.sleep(y*1000);
        }
    }
}
