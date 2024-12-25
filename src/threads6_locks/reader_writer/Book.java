package threads6_locks.reader_writer;

public class Book {
    private String text;

    public Book(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
