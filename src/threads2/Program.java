package threads2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        Thread numsWorker = new Thread(new NumsGenerator(numbers));
        Thread numsWorker2 = new Thread(new NumsGenerator(numbers));
        numsWorker.start();
        numsWorker2.start();

        numsWorker.join(); // make Main Thread wait for numsWorker to finish
        numsWorker2.join(); // make Main Thread wait for numsWorker2 to finish
        System.out.println(numbers.size());
    }
}
