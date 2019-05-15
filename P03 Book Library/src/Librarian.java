
public class Librarian {

  // instance fields
  private String username; // librarian's username
  private String password; // librarian password to have access to this application

  /**
   * Creates a new Librarian with a given name and a given password
   * 
   * @param username  - username of librarian
   * @param password - unique password given to librarian
   * 
   */
  public Librarian(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   *Returns the name of this librarian
   * 
   */
  public String getUsername() {
    return username;
  }

  /**
   * Checks if a given password equals the password of this librarian
   * 
   * @param password - password given to librarian
   */
  public boolean checkPassword(String password) {
    boolean testPassed = false;

    if (this.password.equals(password)) {
      testPassed = true;
    }

    return testPassed;
  }



}
