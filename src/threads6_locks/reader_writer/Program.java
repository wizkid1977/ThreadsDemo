package threads6_locks.reader_writer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        // Reader Writer Lock
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Book book = new Book("start");
        Writer writer = new Writer(book, lock);
        writer.setName("Writer1");
        Writer writer2 = new Writer(book, lock);
        writer2.setName("Writer2");

        Reader reader1 = new Reader(book, lock);
        reader1.setName("Reader1");
        Reader reader2 = new Reader(book, lock);
        reader2.setName("Reader2");

        writer.start();
        writer2.start();
        reader1.start();
        reader2.start();

    }
}
