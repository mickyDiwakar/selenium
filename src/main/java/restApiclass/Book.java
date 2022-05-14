package restApiclass;

public class Book {
	private String isbn;
	private String title;
    private String subTitle;
    private String author;
    private String published;
    private String publisher;
    private int pages;
    private String description;
    private String website;
    
    public Book() {
    	
    }
	public Book(String isbn,String title,String subTitle,String author,String published,String publisher
			,int pages,String description,String website) {
		this.isbn=isbn;
		this.title=title;
		this.subTitle=subTitle;
		this.author=author;
		this.published=published;
		this.publisher=publisher;
		this.pages=pages;
		this.description=description;
		this.website=website;
		
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
}
