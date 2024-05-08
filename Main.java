import src.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Main{
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

    while (isRunning) {
      System.out.println("Menu:");
      System.out.println("1. Show all books");
      System.out.println("2. Add new book");
      System.out.println("3. Edit book");
      System.out.println("4. Delete book");
      System.out.println("5. Exit program");
      System.out.print("Choose action: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
            displayAllBooks(bookManager);
            break;
        case 2:
            // addNewBook(scanner, bookManager);
            break;
        case 3:
            // editBook(scanner, bookManager);
            break;
        case 4:
            // removeBook(scanner, bookManager);
            break;
        case 5:
            isRunning = false;
            break;
        default:
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
      }
    }
    scanner.close();
  }

    private static void displayAllBooks(BookManager bookManager) {
      ArrayList<Book> books = bookManager.sortBooks("title");
      if (books.isEmpty()) {
          System.out.println("No books in library");
      } else {
        System.out.println("");
        System.out.println("All Books:");
        bookManager.displayBooks(books);
        System.out.println("");
      }
    }
  }