package exercises.locks;

import java.util.concurrent.Semaphore;

public class Car extends Thread{
    private Semaphore semaphore;
    private String carName;

    public Car(Semaphore semaphore, String name) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Car " + getName() + " is trying to park...");
        try {
            semaphore.acquire();

            System.out.println("Car " + getName() + " parked ✌");
            sleep((int)(Math.random()*1000)+ 500);

            System.out.println("Car " + getName() + " left the parking lot 🏎");
            semaphore.release();

        } catch (InterruptedException ignored) {}
    }
}
