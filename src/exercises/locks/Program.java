package exercises.locks;

import java.util.concurrent.Semaphore;

public class Program {
    public static void main(String[] args) {
        Semaphore parkingLot = new Semaphore(4);

        for (int i = 1; i <= 7; i++) {
            Car c = new Car(parkingLot, "Car " + i);
            System.out.println("I am virtual!");
            c.start();
        }

    }
}
