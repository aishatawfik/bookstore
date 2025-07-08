public class ShowcaseBook extends Book {
  public ShowcaseBook(String isbn, String title, int year, double price) {
      super(isbn, title, year, price);
  }

  @Override
  public boolean canBeSold() {
      return false;
  }

  @Override
  public void deliver(int quantity, String email, String address) {
      System.out.println("ShowcaseBook [" + isbn + "] is not for sale.");
  }
}
