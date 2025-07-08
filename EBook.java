public class EBook extends Book {
  private String fileType;

  public EBook(String isbn, String title, int year, double price, String fileType) {
      super(isbn, title, year, price);
      this.fileType = fileType;
  }

  public String getFileType() {
      return fileType;
  }

  @Override
  public boolean canBeSold() {
      return true;
  }

  @Override
  public void deliver(int quantity, String email, String address) {
      System.out.println("Sending EBook [" + isbn + "] in format " + fileType +
          " to MailService at email: " + email);
  }
}
