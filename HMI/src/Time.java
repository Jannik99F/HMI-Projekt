public class Time implements Runnable{
    static int value = 1;

    public void run(){
        ClickPage clickPage = new ClickPage();

        for(int i = 30; i >= 0; i--){
            clickPage.setTime(i);
            clickPage.sleep(1000);
            if(i == 15){
                setValue();
            }
        }
    }

    public static void setValue(){
        value+= 1;
    }
    public int getValue(){
        return value;
    }
}
