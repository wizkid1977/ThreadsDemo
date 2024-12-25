package threads1;

public class Program {
    public static void main(String[] args) {
        WorkerThread worker1 = new WorkerThread("Tomer");
        WorkerThread worker2 = new WorkerThread("Omer");

        worker1.start();
        worker2.start();

        //*******************************************
        Thread worker3 = new Thread(new WorkerRunnable("Nir"));
        Thread worker4 = new Thread(new WorkerRunnable("Amos"));
        worker3.start();
        worker4.start();
        
    }

}
