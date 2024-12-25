package threads1;

public class WorkerRunnable implements Runnable{
    private String name;

    public WorkerRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + " : " + i);
        }
    }
}
