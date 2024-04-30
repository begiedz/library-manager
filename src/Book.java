package src;

public class Book{

  private String title;
  private String author;
  private int year;
  private String genre;
  
  public Book(String title, String author, int publishYear, String genre) {
    this.title = title;
    this.author = author;
    this.year = publishYear;
    this.genre = genre;
  }

  public String getTitle(){
    return title;
  }
  public void setTitle(String title){
    this.title = title;
  }


  public String getAuthor(){
    return author;
  }
  public void setAuthor(String author){
    this.author = author;
  }


  public int getYear() {
    return year;
  }
  public void setYear(int year) {
    this.year = year;
  }

  
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public String toString() {
    return "Title: " + title + ", Author: " + author + ", Year: " + year + ", Genre: " + genre;
  }
}
