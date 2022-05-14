
  package restApiclass;
  
  import java.util.ArrayList; import java.util.List;
  
  public class Books {
  
  private Book[] books; 
  public Books() {
  
  } 
  public Books(Book[] books)
  { this.books=books; }
  
  public Book[] getBooks() { 
	  return books;
	  }
  
  public void setBooks(Book[] books) { 
	  this.books = books;
	  }
  
  }
 