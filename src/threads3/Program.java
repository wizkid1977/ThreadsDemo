package threads3;

public class Program {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("I counted " + counter.getCount() + " numbers...");
    }
}
