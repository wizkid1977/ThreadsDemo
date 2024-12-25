package threads6_locks.semaphore;

import java.util.concurrent.Semaphore;

public class Program {
    public static void main(String[] args) {
        // Semaphore
        Semaphore semaphore = new Semaphore(2);
        Worker worker1 = new Worker(semaphore);
        worker1.setName("Worker1");
        Worker worker2 = new Worker(semaphore);
        worker2.setName("Worker2");
        Worker worker3 = new Worker(semaphore);
        worker3.setName("Worker3");
        Worker worker4 = new Worker(semaphore);
        worker4.setName("Worker4");
        Worker worker5 = new Worker(semaphore);
        worker5.setName("Worker5");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker5.start();

        /*
        Exercise: Simulate a Parking Lot Using Semaphore

        There are N parking spaces in a parking lot.
        M cars (threads) are trying to park in the lot, where M > N.
        Use a Semaphore to ensure that no more than N cars can park at the same time.
        Each car will "park" for a random duration and then leave the parking lot, freeing up a space.
        Output messages to show when a car parks and when it leaves.
         */
    }
}