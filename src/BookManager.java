package src;
import java.util.ArrayList;

public class BookManager {
  private ArrayList<Book> books;

  public BookManager(){
    this.books = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public ArrayList<Book> searchBooks(String inputedText) {

        String searchText = inputedText.toLowerCase();
        ArrayList<Book> matchingBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchText) ||
                    book.getAuthor().toLowerCase().contains(searchText) ||
                    String.valueOf(book.getYear()).contains(searchText) ||
                    book.getGenre().toLowerCase().contains(searchText)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

   public ArrayList<Book> sortBooks(String criteria) {

        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        String criteriaLowerCase = criteria.toLowerCase();

        switch (criteriaLowerCase) {
            case "title":
                sortedBooks.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
                break;
            case "author":
                sortedBooks.sort((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
                break;
            case "year":
                sortedBooks.sort((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()));
                break;
            case "genre":
                sortedBooks.sort((b1, b2) -> b1.getGenre().compareToIgnoreCase(b2.getGenre()));
                break;
            default:
                throw new IllegalArgumentException("Invalid criteria.");
        }
    return sortedBooks;
  }

  public void displayBooks(ArrayList<Book> books) {
    for (Book book : books) {
        System.out.println(book);
    }
  }
}