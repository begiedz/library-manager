import src.*;

import java.util.Scanner;

public class Main{
  public static void main (String[] args){
    BookManager bookManager = new BookManager();
    Scanner scanner = new Scanner(System.in);
    boolean isRunning = false;

    while (isRunning) {
      System.out.println("Menu:");
      System.out.println("1. Show all books");
      System.out.println("2. Add new book");
      System.out.println("3. Edit book");
      System.out.println("4. Delete book");
      System.out.println("5. Exit program");
      System.out.print("Choose action: ");
    }
    scanner.close();

  if (!isRunning){
    for (int i = 0; i < 1; i++) {
       System.out.println("Menu:");
      System.out.println("1. Show all books");
      System.out.println("2. Add new book");
      System.out.println("3. Edit book");
      System.out.println("4. Delete book");
      System.out.println("5. Exit program");
      System.out.print("Choose action: ");
    }
  }
    
      // Book testBook = new Book("Title","Author", 2024, "Genre");

    // String str1 = "abc";
    // String str2 = "ABC";
    
    // int result = str1.compareToIgnoreCase(str2);

    // System.out.println(result);
    // System.out.println(testBook); 
  }

}