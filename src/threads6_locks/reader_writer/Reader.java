package threads6_locks.reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reader extends Thread{
    private ReentrantReadWriteLock lock;
    private Book book;

    public Reader(Book book, ReentrantReadWriteLock lock) {
        this.lock = lock;
        this.book = book;
    }

    @Override
    public void run() {
        if(lock.isWriteLocked())
            System.out.println("Book is currently being written, reader is waiting...");
        lock.readLock().lock();
        System.out.println(getName() + " is reading the book:");
        for (int i = 0; i < book.getText().length(); i++) {
            System.out.print(book.getText().charAt(i));
            try {
                sleep(50);
            } catch (InterruptedException ignored) {}
        }

        lock.readLock().unlock();
    }
}
