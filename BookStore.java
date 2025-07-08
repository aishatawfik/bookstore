import java.util.*;

public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
    }

    // Remove and return outdated books
    public List<Book> removeOutdatedBooks(int cutoffYear) {
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            if (entry.getValue().getYear() < cutoffYear) {
                removed.add(entry.getValue());
                System.out.println("Removing outdated book: " + entry.getKey());
                iterator.remove();
            }
        }
        return removed;
    }

    // Buy a single book by ISBN
    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new Exception("Book not found with ISBN: " + isbn);
        }
        if (!book.canBeSold()) {
            throw new Exception("This book is not for sale.");
        }
        // Reduce stock if PaperBook
        if (book instanceof PaperBook) {
            ((PaperBook) book).reduceStock(quantity);
        }
        // Deliver book
        book.deliver(quantity, email, address);
        // Return paid amount
        return book.getPrice() * quantity;
    }

    public Collection<Book> getAllBooks() {
        return inventory.values();
    }
}
