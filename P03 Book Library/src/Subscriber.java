import java.util.ArrayList;

public class Subscriber {

  // static fields
  private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked out
                                                       // one subscriber
  private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
                                                   // code of the next subscriber to be created
  // Instance fields
  private int pin; // 4-digits Personal Identification Number to verify the identity of this
                   // subscriber
  private final Integer CARD_BAR_CODE; // card bar code of this subscriber

  private String name; // name of this subscriber
  private String address; // address of this subscriber
  private String phoneNumber; // phone number of this subscriber

  private ArrayList<Book> booksCheckedOut; // list of books checked out by this subscriber and not
                                           // yet
                                           // returned. A subscriber can have at most 10 checked out
                                           // books
  private ArrayList<Book> booksReturned; // list of the books returned by this subscriber



  /**
   * Creates a new subscriber with given name, address, and phone number, and initializes its other
   * instance fields
   * 
   * @param name       - name of subscriber
   * @param pin        - unique pin given to subscriber
   * @param address    - subscriber address
   * @param phoneNuber - subs Phone Number
   */
  public Subscriber(String name, int pin, String address, String phoneNumber) {

    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.pin = pin;
    this.CARD_BAR_CODE = nextCardBarCode;
    nextCardBarCode = nextCardBarCode + 1;
    booksCheckedOut = new ArrayList<Book>();
    booksReturned = new ArrayList<Book>();
  }

  /**
   * returns this subscriber's address
   * 
   *
   */
  public String getAddress() {
    return address;
  }

  /**
   * Updates this subscriber's address
   * 
   * @param address - subscriber address
   *
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * returns this subscriber's phone number
   * 
   *
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Updates this subscriber's address
   * 
   * @param phoneNumber - subscribers Phone Number
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * returns this subscriber's pin
   * 
   *
   */
  public int getPin() {
    return pin;
  }

  /**
   * Returns this subscriber's card bar code
   * 
   *
   */
  public Integer getCARD_BAR_CODE() {
    return CARD_BAR_CODE;
  }

  /**
   * Returns this subscriber's name
   * 
   *
   */
  public String getName() {
    return name;
  }

  /**
   * Checks out an available book. The checkout operation fails if the maximum number of checked out
   * books by this subscriber is already reached
   * 
   * @param book - Book object created by user
   */
  public void checkoutBook(Book book) {

    Integer barCode = book.getBorrowerCardBarCode();
    String title = book.getTitle();

    if (barCode != null) {
      System.out.println("Sorry, " + title + " is not available.");
      return;
    }
    for (int i = 0; i < booksCheckedOut.size(); i++) {
      String title1 = booksCheckedOut.get(i).getTitle();
      if (title1.equals(title)) {
        System.out.println("You have already checked out " + title + " book.");
        return;
      }
    }
    if (booksCheckedOut.size() < MAX_BOOKS_CHECKED_OUT) {
      booksCheckedOut.add(book);
      book.borrowBook(CARD_BAR_CODE);
    } else {
      System.out.println(
          "\"Checkout Failed: You cannot check out more than \" + <MAX_BOOKS_CHECKED_OUT> + \"books.\"");
      return;
    }

  }

  /**
   * Returns a library book
   * 
   * @param book - Book object created by user
   */
  public void returnBook(Book book) {
    booksCheckedOut.remove(book.getID() - 1);
    booksReturned.add(book);
    book.returnBooK();
  }


  /**
   * Checks if this subscriber booksCheckedOut list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksCheckedOut list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksCheckedOut(Book book) {
    return booksCheckedOut.contains(book);
  }

  /**
   * Checks if this subscriber booksReturned list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksReturned list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksReturned(Book book) {
    return booksReturned.contains(book);
  }

  /**
   * Displays the list of the books checked out and not yet returned
   */
  public void displayBooksCheckedOut() {
    if (booksCheckedOut.isEmpty()) // empty list
      System.out.println("No books checked out by this subscriber");
    else
      // Traverse the list of books checked out by this subscriber and display its content
      for (int i = 0; i < booksCheckedOut.size(); i++) {
        System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
      }
  }

  /**
   * Displays the history of the returned books by this subscriber
   */
  public void displayHistoryBooksReturned() {
    if (booksReturned.isEmpty()) // empty list
      System.out.println("No books returned by this subscriber");
    else
      // Traverse the list of borrowed books already returned by this subscriber and display its
      // content
      for (int i = 0; i < booksReturned.size(); i++) {
        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
        System.out.println("Author: " + booksReturned.get(i).getAuthor());
      }
  }

  /**
   * Displays this subscriber's personal information
   */
  public void displayPersonalInfo() {
    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
    System.out.println("  Name: " + name);
    System.out.println("  Address: " + address);
    System.out.println("  Phone number: " + phoneNumber);
  }



}
