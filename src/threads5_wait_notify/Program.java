package threads5_wait_notify;

import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack, "c1");
        Consumer consumer2 = new Consumer(stack, "c2");
        producer.start();
        consumer.start();
        consumer2.start();

        /*
        TODO:
        One Thread adds a random String into a collection(Stack, List...).
        The second thread reads the new String available and prints the reversed string.
        Both use the same collection!
         */
    }
}