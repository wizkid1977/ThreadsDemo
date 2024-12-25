package exercises.wait_notify;

import java.util.Stack;

public class TextReverser extends Thread{
    private Stack<String> stringData;
    private String name;

    public TextReverser(Stack<String> stringData, String name) {
        this.stringData = stringData;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){

                while (stringData.isEmpty()) {
                    try {
                        synchronized (stringData) {
                            stringData.wait();
                        }
                    } catch (InterruptedException ignored) {}
                }
                // read string, reverse it
                String str = stringData.pop();
                System.out.println(name + " is reversing text: " + str);
                System.out.println(name + " - Revered test is: "
                        + new StringBuilder(str).reverse());
                try {
                    sleep(300);
                } catch (InterruptedException ignored) {}
        }
    }
}
