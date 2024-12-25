package threads6_locks.reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Writer extends Thread{
    private ReentrantReadWriteLock lock;
    private Book book;

    public Writer(Book book, ReentrantReadWriteLock lock) {
        this.book = book;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.writeLock().lock();
        System.out.println(getName() + " is starting to write:");
        for (int i = 0; i < 10; i++) {
            char tav = (char)((int)(Math.random()*25)+65);
            book.setText(book.getText() + tav);
            try {
                sleep(200);
            } catch (InterruptedException ignored) {}
        }

        System.out.println(getName() + " finished writing");
        lock.writeLock().unlock();
    }
}
