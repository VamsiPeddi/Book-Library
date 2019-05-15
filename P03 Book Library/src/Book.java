
public class Book {

  // class/static fields
  private static int nextId = 1; // class variable that represents the identifier of the next
                                 // book
  // Instance fields
  private final int ID; // unique identifier of this book
  private String author; // name of the author of this book
  private String title; // title of this book
  private Integer borrowerCardBarCode; // card bar code of the borrower of this book
                                       // When borrowerCardBarCode == null, the book is available
                                       // (no one has the book)

  /**
   * Construct a new Book object and initialize its instance fields
   * 
   * @param title  - title of the book
   * @param author - author of the book
   */
  public Book(String title, String author) {

    this.author = author;
    this.title = title;
    this.ID = nextId;
    Book.nextId = nextId + 1;


  }

  /**
   * Return the author of this book
   *
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Return the title of this book
   *
   */
  public String getTitle() {
    return title;
  }

  /**
   * Return the the borrower's card bar code of this book if the book has been checked out or null
   * if not
   *
   */
  public Integer getBorrowerCardBarCode() {
    return borrowerCardBarCode;
  }

  /**
   * Return the ID of this book
   *
   */
  public int getID() {
    return ID;
  }

  /**
   * Records the borrower's card bar code of this book if the book is available. If this book is not
   * available, this method does nothing.
   * 
   *
   */
  public void borrowBook(Integer borrowerBarCode) {
    this.borrowerCardBarCode = borrowerBarCode;
  }

  /**
   * Sets this book to be available. When the borrowerCardBarCode is set to null, no one is
   * borrowing it
   *
   */
  public void returnBooK() {
    this.borrowerCardBarCode = null;
  }

  /**
   * Checks if this book is available
   * 
   */
  public boolean isAvailable() {
    boolean testPassed = false;

    Integer barCode = getBorrowerCardBarCode();

    if (barCode == null) {
      testPassed = true;
    }

    return testPassed;

  }

}
