public class PaperBook extends Book {
  private int stock;

  public PaperBook(String isbn, String title, int year, double price, int stock) {
      super(isbn, title, year, price);
      this.stock = stock;
  }

  public int getStock() {
      return stock;
  }

  public void reduceStock(int quantity) throws Exception {
      if (stock < quantity) {
          throw new Exception("Insufficient stock for ISBN: " + isbn);
      }
      stock -= quantity;
  }

  @Override
  public boolean canBeSold() {
      return true;
  }

  @Override
  public void deliver(int quantity, String email, String address) {
      System.out.println("Sending PaperBook [" + isbn + "] to ShippingService at address: " + address);
  }
}