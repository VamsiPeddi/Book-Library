import java.util.ArrayList;
import java.util.Scanner;

public class Library {

  // instance fields
  private String address; // Street address of this library
  private Librarian librarian; // this library's librarian. This library must have only ONE
                               // librarian
  private ArrayList<Book> books; // list of the books in this library
  private ArrayList<Subscriber> subscribers; // list of this library's subscribers

  /**
   * Creates a new Library and initializes all its instance fields. Initially both books and
   * subscribers lists are empty.
   * 
   * @param librarianUsername - username of librarian
   * @param librarianPassword - unique password given to librarian
   * 
   */
  public Library(String address, String librarianUsername, String librarianLogin) {

    this.address = address;
    librarian = new Librarian(librarianUsername, librarianLogin);
    books = new ArrayList<Book>();
    subscribers = new ArrayList<Subscriber>();

  }

  /**
   * Returns the librarian of this library
   * 
   */
  public Librarian getLibrarian() {
    return librarian;
  }

  /**
   * Returns the address of this library
   * 
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns a Book given a book identifier if found, and null otherwise. If the book is not found,
   * this method displays the following message: "Error: this book identifier didn't match any of
   * our books identifiers."
   * 
   * @param bookId - ID given to the book
   * 
   */
  public Book findBook(int bookId) {
    for (int i = 0; i < books.size(); i++) {
      Book book = books.get(i);
      if (book != null) {
        int Id = book.getID();
        if (Id == bookId) {
          return book;
        }
      }

    }
    System.out.println("Error: this book identifier didn't match any of our books identifiers.");
    return null;
  }

  /**
   * Returns the list of books having a given title in this library. The comparison used by this
   * method is case insensitive
   * 
   * @param title - Title of book to find
   */
  public ArrayList<Book> findBookByTitle(String title) {
    ArrayList<Book> booksByTitle = new ArrayList<Book>();

    for (int i = 0; i < books.size(); i++) {
      Book book = books.get(i);
      String title1 = book.getTitle();
      if (title1.equals(title)) {
        booksByTitle.add(book);
      }

    }

    return booksByTitle;
  }

  /**
   * Returns the list of books having a given author. The comparison used by this method is case
   * insensitive
   * 
   * @param author - Author of book to find
   */
  public ArrayList<Book> findBookByAuthor(String author) {

    ArrayList<Book> booksByAuthor = new ArrayList<Book>();

    for (int i = 0; i < books.size(); i++) {
      Book book = books.get(i);
      String author1 = book.getAuthor();
      if (author1.equals(author)) {
        booksByAuthor.add(book);
      }

    }

    return booksByAuthor;

  }

  /**
   * Adds a new book to the library (to the books list). This method displays the following message:
   * "Book with Title " + title + " is successfully added to the library."
   * 
   * @param author - Author of book to find
   * @param title  - Title of book to find
   */
  public void addBook(String title, String author) {
    Book book = new Book(title, author);
    books.add(book);
    System.out.println("Book with Title " + title + " is successfully added to the library.");
  }

  /**
   * Removes a book given its identifier from the library (from books list)
   * 
   * @param bookId - ID given to the book
   * 
   */
  public Book removeBook(int bookId) {

    for (int i = 0; i < books.size(); i++) {
      Book book = books.get(i);
      int Id = book.getID();
      if (Id == bookId) {
        books.remove(i);
        return book;
      }
    }
    return null;
  }

  /**
   * Adds a new subscriber to this library (to subscribers list). This method displays the following
   * message: "Library card with bar code " + card bar code + " is successfully issued to the new
   * subscriber " + name + "."
   * 
   * 
   * @param name       - name of subscriber
   * @param pin        - unique pin given to subscriber
   * @param address    - subscriber address
   * @param phoneNuber - subs Phone Number
   */

  public void addSubscriber(String name, int pin, String address, String phoneNumber) {
    Subscriber subscriber = new Subscriber(name, pin, address, phoneNumber);
    subscribers.add(subscriber);
    int barCode = subscriber.getCARD_BAR_CODE();
    System.out.println("Library card with bar code " + barCode
        + " is successfully issued to the new subscriber " + name + ".");
  }

  /**
   * Finds a subscriber given its cardBarCode. This method displayed the following message: "Error:
   * this card bar code didn't match any of our records." and returns null if the provided
   * cardBarCode did not match with any of the subscribers' card bar codes
   * 
   * 
   * @param cardBarCode - Bar code given to the book
   * 
   */
  public Subscriber findSubscriber(int cardBarCode) {
    for (int i = 0; i < subscribers.size(); i++) {
      Subscriber subscriber = subscribers.get(i);
      int barCode = subscriber.getCARD_BAR_CODE();
      if (barCode == cardBarCode) {
        return subscriber;
      }
    }
    System.out.println("Error: this card bar code didn't match any of our records.");
    return null;
  }

  /**
   * Displays a list of books
   * 
   * @param books ArrayList of books
   */
  public static void displayBooks(ArrayList<Book> books) {
    // Traverse the list of books and display book id, title, author, and availability of each book
    for (int i = 0; i < books.size(); i++) {
      System.out.print("<Book ID>: " + books.get(i).getID() + " ");
      System.out.print("<Title>: " + books.get(i).getTitle() + " ");
      System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
      System.out.println("<Is Available>: " + books.get(i).isAvailable());
    }
  }

  /**
   * Displays the main menu for this book library application
   */
  private static void displayMainMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("     Welcome to our Book Library Management System");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <password>] Login as a librarian");
    System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
    System.out.println("[3] Exit"); // Exit the application
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for a Subscriber
   */
  private static void displaySubscriberMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Subscriber's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <book ID>] Check out a book");
    System.out.println("[2 <book ID>] Return a book");
    System.out.println("[3 <title>] Search a Book by title");
    System.out.println("[4 <author>] Search a Book by author");
    System.out.println("[5] Print list of books checked out");
    System.out.println("[6] Print history of returned books");
    System.out.println("[7 <address>] Update address");
    System.out.println("[8 <phone number>] Update phone number");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for the Librarian
   */
  private static void displayLibrarianMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Librarian's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <title> <author>] Add new Book");
    System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
    System.out.println("[3 <card bar code> <book ID>] Check out a Book");
    System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
    System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
    System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
    System.out.println("[7] Display All Books");
    System.out.println("[8 <book ID>] Remove a Book");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Display the Application GoodBye and logout message.
   */
  private static void displayGoodByeLogoutMessage() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("       Thanks for Using our Book Library App!!!!");
    System.out.println("--------------------------------------------------------");
  }


  /**
   * Reads and processes the user commands with respect to the menu of this application
   * 
   * @param scanner Scanner object used to read the user command lines
   */
  public void readProcessUserCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displayMainMenu(); // display the library management system main menu
    System.out.print(promptCommandLine);
    String command = scanner.nextLine(); // read user command line
    String[] commands = command.trim().split(" "); // split user command
    while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
      switch (commands[0].trim().charAt(0)) {
        case '1': // login as librarian commands[1]: password
          if (this.librarian.checkPassword(commands[1])) {
            // read and process librarian commands
            readProcessLibrarianCommand(scanner);
          } else { // error password
            System.out.println("Error: Password incorrect!");
          }
          break;
        case '2': // login as subscriber commands[1]: card bar code
          Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
          if (subscriber != null) {
            if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
              // read and process subscriber commands
              readProcessSubscriberCommand(subscriber, scanner);
            else
              System.out.println("Error: Incorrect PIN.");
          }
          break;
      }
      // read and split next user command line
      displayMainMenu(); // display the library management system main menu
      System.out.print(promptCommandLine);
      command = scanner.nextLine(); // read user command line
      commands = command.trim().split(" "); // split user command line
    }

  }


  /**
   * Reads and processes the librarian commands according to the librarian menu
   * 
   * @param scanner Scanner object used to read the librarian command lines
   */

  private void readProcessLibrarianCommand(Scanner scanner) {

    displayLibrarianMenu();

    final String promptCommandLine = "ENTER COMMAND: ";
    System.out.print(promptCommandLine);

    int a = 0;

    String command = scanner.nextLine();
    String[] commands = command.split(" ");
    char firstNum = commands[0].charAt(0);

    while (firstNum != '9') {

      if (a != 0) {
        displayLibrarianMenu();
        System.out.print(promptCommandLine);
        command = scanner.nextLine();
        commands = command.split(" ");
        firstNum = commands[0].trim().charAt(0);
      }

      if (firstNum == '1') {
        String title = commands[1].trim();
        String author = commands[2].trim();
        addBook(title, author);
      } else if (firstNum == '2') {
        String name = commands[1].trim();
        int pin = Integer.parseInt(commands[2]);
        String address = commands[3].trim();
        String phoneNumber = commands[4].trim();
        addSubscriber(name, pin, address, phoneNumber);
      } else if (firstNum == '3') {
        Integer barCode = Integer.parseInt(commands[1]);
        int bookId = Integer.parseInt(commands[2]);
        Book book = findBook(bookId);
        Subscriber subscriber = findSubscriber(barCode);
        subscriber.checkoutBook(book);
      } else if (firstNum == '4') {
        Integer barCode = Integer.parseInt(commands[1]);
        int bookId = Integer.parseInt(commands[2]);
        Book book = findBook(bookId);
        Subscriber subscriber = findSubscriber(barCode);
        subscriber.returnBook(book);
      } else if (firstNum == '5') {
        Integer barCode = Integer.parseInt(commands[1]);
        Subscriber sub = findSubscriber(barCode);
        sub.displayPersonalInfo();
      } else if (firstNum == '6') {
        Integer barCode = Integer.parseInt(commands[1]);
        Subscriber sub = findSubscriber(barCode);
        sub.displayBooksCheckedOut();
      } else if (firstNum == '7') {
        displayBooks(books);
      } else if (firstNum == '8') {
        int bookId = Integer.parseInt(commands[1]);
        removeBook(bookId);
      }
      a++;
      if (firstNum == '9') {
        break;
      } else {
        continue;
      }
    }

    return;
  }

  /**
   * Reads and processes the subscriber commands according to the subscriber menu
   * 
   * @param subscriber Current logged in subscriber
   * @param scanner    Scanner object used to read the librarian command lines
   */
  private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {

    displaySubscriberMenu();

    final String promptCommandLine = "ENTER COMMAND: ";
    System.out.print(promptCommandLine);

    int a = 0;

    String command = scanner.nextLine();
    String[] commands = command.split(" ");
    char firstNum = commands[0].charAt(0);
    while (firstNum != '9') {

      if (a != 0) {
        displaySubscriberMenu();
        System.out.print(promptCommandLine);
        command = scanner.nextLine();
        commands = command.split(" ");
        firstNum = commands[0].charAt(0);
      }

      if (firstNum == '1') {
        int bookId = Integer.parseInt(commands[1]);
        Book book = findBook(bookId);
        subscriber.checkoutBook(book);
      }
      if (firstNum == '2') {
        int bookId = Integer.parseInt(commands[1]);
        Book book = findBook(bookId);
        subscriber.returnBook(book);
      }
      if (firstNum == '3') {
        String title = commands[1].trim();
        ArrayList<Book> booksByTitle = new ArrayList<Book>();
        booksByTitle = findBookByTitle(title);
        displayBooks(booksByTitle);
      }
      if (firstNum == '4') {
        String author = commands[1].trim();
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        booksByAuthor = findBookByAuthor(author);
        displayBooks(booksByAuthor);
      }
      if (firstNum == '5') {
        subscriber.displayBooksCheckedOut();
      }
      if (firstNum == '6') {
        subscriber.displayHistoryBooksReturned();
      }
      if (firstNum == '7') {
        String address = commands[1].trim();
        subscriber.setAddress(address);
      }
      if (firstNum == '8') {
        String phoneNumber = commands[1].trim();
        subscriber.setPhoneNumber(phoneNumber);
      }

      a++;
      if (firstNum == '9') {
        break;
      } else {
        continue;
      }
    }

    return;
  }


  /**
   * Main method that represents the driver for this application
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
    // create a new library object
    Library madisonLibrary = new Library("Madison, WI", "april", "abc");
    // read and process user command lines
    madisonLibrary.readProcessUserCommand(scanner);
    displayGoodByeLogoutMessage(); // display good bye message
    scanner.close();// close this scanner
  }



}
