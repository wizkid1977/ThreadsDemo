package threads4_deadlock;

public class Program {
    public static void main(String[] args) {
        // Shared resources
        final Resource resource1 = new Resource("Resource 1");
        final Resource resource2 = new Resource("Resource 2");

        // Thread 1
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
                try {
                    // Simulate some work
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " waiting for " + resource2.getName());
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
                }
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
                try {
                    // Simulate some work
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " waiting for " + resource1.getName());
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
                }
            }
        });

        // Start both threads
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }

}
