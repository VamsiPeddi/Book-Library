import java.util.ArrayList;

public class BookLibraryTests {

  public static boolean testBookConstructorGetters() {

    boolean testPassed = true;

    Book newBook = new Book("Harry Potter", "J.K Rowling");

    String title = newBook.getTitle();
    String author = newBook.getAuthor();
    int ID = newBook.getID();
    Integer borrowerCardBarCode = newBook.getBorrowerCardBarCode();

    Book newBook1 = new Book("Harry Potter 2", "J.K Rowling");

    int ID1 = newBook1.getID();
    Integer borrowerCardBarCode1 = newBook1.getBorrowerCardBarCode();

    if (!title.equals("Harry Potter") || !author.equals("J.K Rowling")) {
      System.out.println(
          "Title and author isn't correct, your program returned " + title + " and " + author);
      testPassed = false;
    }

    if (ID1 != 2 && ID != 1) {
      System.out.println("Test failed, your ID was " + ID1);
      testPassed = false;
    }

    if (borrowerCardBarCode != null || borrowerCardBarCode1 != null) {
      System.out.println("Test failed, your barcode isnt null");
      testPassed = false;
    }
    return testPassed;

  }

  /**
   * testBookReturnBook() checks whether returnBook() method defined within the Book class sets
   * correctly the instance field borrowerCardBarCode. A Book must be available after this instance
   * method is called.
   * 
   * return a boolean value
   */
  public static boolean testBookReturnBook() {

    boolean testPassed = true;

    Book book = new Book("Harry Potter", "JK Rowling");
    Integer barCode = book.getBorrowerCardBarCode();
    book.borrowBook(barCode);
    book.returnBooK();

    if (barCode != null) {
      testPassed = false;
      System.out.println("TEST FAILED, your BAR CODE is " + barCode);
    }


    return testPassed;

  }

  /**
   * This unit test method checks whether the checkoutBook() method defined within the Subscriber
   * class works correctly
   * 
   * return a boolean value
   */
  public static boolean testSubscriberCheckoutBook() {
    boolean testPassed = true;
    Book book = new Book("Harry Potter", "JK Rowling");
    Subscriber sub = new Subscriber("Jeremy", 9999, "Witte", "9908148272");
    sub.checkoutBook(book);
    boolean check = sub.isBookInBooksCheckedOut(book);
    if (check == false) {
      testPassed = false;
      System.out.println("TEST FAILED");
    }


    return testPassed;
  }

  /**
   * This method checks the good functioning of findBookByAuthor(String) method defined in the
   * Library class.
   * 
   * return a boolean value
   */
  public static boolean testLibraryFindBookByAuthor() {
    boolean testPassed = true;
    
    Library library = new Library("99", "1", "abcd");

    library.addBook("Harry Potter", "JK Rowling");
    library.addBook("Harry Potter 2", "JK Rowling");
    
    ArrayList<Book> booksByAuthor = library.findBookByAuthor("JK Rowling");
    
    if (booksByAuthor.size() != 2) {
      testPassed = false;
      System.out.println("TEST FAILED");
    }
    
    
    return testPassed;
  }
  
  /**
   * This method checks the good functioning of findBookByTitle(String) method defined in the
   * Library class.
   * 
   * return a boolean value
   */
  public static boolean testLibraryFindBookByTitle() {
    boolean testPassed = true;
    
    Library library = new Library("99", "1", "abcd");

    library.addBook("Harry Potter", "JK Rowling");
    library.addBook("Harry Potter 2", "JK Rowling");
    
    ArrayList<Book> booksByTitle = library.findBookByTitle("Harry Potter");
    
    if (booksByTitle.size() != 1) {
      testPassed = false;
      System.out.println("TEST FAILED");
    }
    
    
    return testPassed;
  }
  
  


  public static void main(String[] args) {
    testBookConstructorGetters();
    testBookReturnBook();
    testSubscriberCheckoutBook();
    testLibraryFindBookByAuthor();
    testLibraryFindBookByTitle();

  }



}
