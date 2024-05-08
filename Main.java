import src.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Main{
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_BOLD = "\033[0;1m";
  public static void main (String[] args){
    BookManager bookManager = new BookManager();

    // Example books
    bookManager.addBook(new Book("Pan Tadeusz", "Adam Mickiewicz", 1834, "Epos narodowy"));
    bookManager.addBook(new Book("Lalka", "Bolesław Prus", 1890, "Realizm"));
    bookManager.addBook(new Book("Quo Vadis", "Henryk Sienkiewicz", 1896, "Historyczna"));
    bookManager.addBook(new Book("Ferdydurke", "Witold Gombrowicz", 1937, "Absurdalna"));
    bookManager.addBook(new Book("Solaris", "Stanisław Lem", 1961, "Science fiction"));

    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;

    System.out.println(ANSI_GREEN + "Java Library Manager" + ANSI_RESET);
    while (isRunning) {
      System.out.println("");
      System.out.println(ANSI_BOLD + "Menu:" + ANSI_RESET );
      System.out.println("1. Show all books");
      System.out.println("2. Add new book");
      System.out.println("3. Edit book");
      System.out.println("4. Delete book");
      System.out.println("5. Exit program");
      System.out.println("");
      System.out.print("Choose action: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
            displayAllBooks(scanner, bookManager);
            break;
        case 2:
            addNewBook(scanner, bookManager);
            break;
        case 3:
            editBook(scanner, bookManager);
            break;
        case 4:
            removeBook(scanner, bookManager);
            break;
        case 5:
            isRunning = false;
            break;
        default:
            System.out.println("Incorrect selection. Try again.");
      }
    }
    scanner.close();
  }
  
    private static void displayAllBooks(Scanner scanner, BookManager bookManager) {
      System.out.println("");
      System.out.println("Choose sorting criteria:");
      System.out.println("1. Title");
      System.out.println("2. Author");
      System.out.println("3. Publication Year");
      System.out.println("4. Genre");
      System.out.println("");
      System.out.print("Enter sorting criteria number: ");

      int sortChoice = scanner.nextInt();
    scanner.nextLine();

    String sortCriteria;
    switch (sortChoice) {
        case 1:
            sortCriteria = "title";
            break;
        case 2:
            sortCriteria = "author";
            break;
        case 3:
            sortCriteria = "year";
            break;
        case 4:
            sortCriteria = "genre";
            break;
        default:
            System.out.println("Invalid selection. Sorting by title.");
            sortCriteria = "title";
    }

      ArrayList<Book> books = bookManager.sortBooks(sortCriteria);
      if (books.isEmpty()) {
          System.out.println("No books in library");
      } else {
        System.out.println("");
        System.out.println("All books:");
        bookManager.displayBooks(books);
        System.out.println("");
      }
    }

    private static void addNewBook(Scanner scanner, BookManager bookManager) {
      System.out.println("");
      System.out.print( "Enter the title of the book: " );
      String title = scanner.nextLine();
      System.out.println("");
      System.out.print("Enter the author of the book: ");
      String author = scanner.nextLine();
      System.out.println("");
      System.out.print("Enter the publication year of the book: ");
      int year = scanner.nextInt();
      scanner.nextLine();
      System.out.println("");
      System.out.print("Enter the genre of the book: ");
      String genre = scanner.nextLine();

      Book newBook = new Book(title, author, year, genre);
      bookManager.addBook(newBook);
      System.out.println("");
      System.out.println("Book added successfully.");
    }

    private static void editBook(Scanner scanner, BookManager bookManager) {
      System.out.print("");
      System.out.print( "Enter the title of the book to edit: " );
      String titleToEdit = scanner.nextLine();
      ArrayList<Book> books = bookManager.searchBooks(titleToEdit);

      if (books.isEmpty()) {
          System.out.println("Book not found.");
          return;
      }

      System.out.println("Select a book to edit:");
      for (int i = 0; i < books.size(); i++) {
          System.out.println((i + 1) + ". " + books.get(i));
      }

      System.out.print("Choose the number of the book to edit: ");
      int index = scanner.nextInt() - 1;
      scanner.nextLine();

      if (index < 0 || index >= books.size()) {
          System.out.println("Invalid book number.");
          return;
      }

      Book bookToEdit = books.get(index);

      System.out.print("New title (press Enter to skip): ");
      String newTitle = scanner.nextLine();
      if (!newTitle.isEmpty()) {
          bookToEdit.setTitle(newTitle);
      }

      System.out.print("New author (press Enter to skip): ");
      String newAuthor = scanner.nextLine();
      if (!newAuthor.isEmpty()) {
          bookToEdit.setAuthor(newAuthor);
      }

      System.out.print("New publication year (press Enter to skip): ");
      String newYearStr = scanner.nextLine();
      if (!newYearStr.isEmpty()) {
          try {
              int newYear = Integer.parseInt(newYearStr);
              bookToEdit.setYear(newYear);
          } catch (NumberFormatException e) {
              System.out.println("Invalid year format.");
          }
      }

      System.out.print("New genre (press Enter to skip): ");
      String newGenre = scanner.nextLine();
      if (!newGenre.isEmpty()) {
          bookToEdit.setGenre(newGenre);
      }

      System.out.println("");
      System.out.println("Book updated successfully.");
    }

    private static void removeBook(Scanner scanner, BookManager bookManager) {
      System.out.print("");
      System.out.print("Enter the title of the book to remove: ");
      String titleToRemove = scanner.nextLine();
      ArrayList<Book> books = bookManager.searchBooks(titleToRemove);

      if (books.isEmpty()) {
          System.out.println("Book not found.");
          return;
      }

      System.out.println("Select a book to remove:");
      for (int i = 0; i < books.size(); i++) {
          System.out.println((i + 1) + ". " + books.get(i));
      }

      System.out.print("Choose the number of the book to remove: ");
      int index = scanner.nextInt() - 1;
      scanner.nextLine();

      if (index < 0 || index >= books.size()) {
          System.out.println("Invalid book number.");
          return;
      }

      Book bookToRemove = books.get(index);
      bookManager.removeBook(bookToRemove);
      System.out.println("");
      System.out.println("Book " + bookToRemove.getTitle() + " removed successfully.");
    }
  }