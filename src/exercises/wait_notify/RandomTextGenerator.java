package exercises.wait_notify;

import java.util.Random;
import java.util.Stack;

public class RandomTextGenerator extends Thread {
    private Stack<String> stringData;

    public RandomTextGenerator(Stack<String> stringData) {
        this.stringData = stringData;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while(true){
            StringBuilder builder = new StringBuilder(11);
            for (int i = 0; i < 11; i++) {
                builder.append((char)(rand.nextInt(64, 90)+1));
            }
            stringData.push(builder.toString());
            synchronized (stringData){
                stringData.notify();
            }

            try {
                sleep(100);
            } catch (InterruptedException ignored) {}
        }
    }
}
