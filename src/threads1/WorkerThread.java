package threads1;

public class WorkerThread extends Thread{
    private String name;

    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + " : " + i);
        }
    }
}
