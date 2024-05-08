import src.Book;

public class Main{
  public static void main (String[] args){
    Book testBook = new Book("Title","Author", 2024, "Genre");

    String str1 = "abc";
    String str2 = "ABC";
    
    int result = str1.compareToIgnoreCase(str2);
    
    System.out.println(result);
    System.out.println(testBook); 
  }
}