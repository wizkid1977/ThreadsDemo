package exercises.wait_notify;

import java.util.Stack;

public class Program {
    /*
        TODO:
        One Thread adds a random String into a collection(Stack, List...). (65-90)
        The second thread reads the new String available, prints the reversed string and removes it!
        Both use the same collection!
    */

    public static void main(String[] args) {
        Stack<String> textStack = new Stack<>();
        RandomTextGenerator generator = new RandomTextGenerator(textStack);
        TextReverser reverser1 = new TextReverser(textStack, "Reverser1");
        TextReverser reverser2 = new TextReverser(textStack, "Reverser2");
        TextReverser reverser3 = new TextReverser(textStack, "Reverser3");



        reverser1.start();
        reverser2.start();
        reverser3.start();
        generator.start();
    }
}
