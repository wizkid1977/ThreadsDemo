package threads6_locks.semaphore;

import java.util.concurrent.Semaphore;

public class Worker extends Thread{
    private Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // check if number of running threads is less
                                 // than number of permits in the Semaphore.
                                 // if less - run, if not - wait
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i <= 20; i++) {
            System.out.println(getName() + " : " + i);
            try {
                sleep((int)(Math.random()*200)+200);
            } catch (InterruptedException ignored) {}
        }

        semaphore.release(); // decrement counter in semaphore and call notify()
    }
}
