public class BookStoreTest {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        // Add books
        store.addBook(new PaperBook("ISBN123", "Java Fundamentals", 2018, 50.0, 10));
        store.addBook(new PaperBook("ISBN223", "C Fundamentals", 2020, 50.0, 10));
        store.addBook(new EBook("ISBN456", "Learning Spring Boot", 2020, 30.0, "PDF"));
        store.addBook(new ShowcaseBook("ISBN789", "Rare Manuscript", 1850, 0.0));
        store.addBook(new ShowcaseBook("ISBN889", "Rare Manuscript 2", 2023, 0.0));

        // Remove outdated books and print them
        System.out.println("Removing outdated books published before 2019:");
        for (Book b : store.removeOutdatedBooks(2019)) {
            System.out.println("Removed: " + b.getTitle());
        }

        // Try to buy PaperBook but removed because of outdated removal
        try {
            double total = store.buyBook("ISBN123", 2, "customer@example.com", "123 Main Street");
            System.out.println("Purchase successful. Paid amount: " + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Try to buy PaperBook (should succeed)
        try {
          double total = store.buyBook("ISBN223", 2, "customer@example.com", "123 Main Street");
            System.out.println("Purchase successful. Paid amount: " + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Try to buy EBook
        try {
            double total = store.buyBook("ISBN456", 1, "ebookbuyer@example.com", "");
            System.out.println("EBook purchase successful. Paid amount: " + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Try to buy ShowcaseBook but removed because it is outdated
        try {
            store.buyBook("ISBN789", 1, "showcasebuyer@example.com", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //try to buy a ShowcaseBook that is not for sale
        try {
          store.buyBook("ISBN889", 1, "showcasebuyer@example.com", "");
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
    }
}