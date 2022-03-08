package board;

public class BooksVO {
	private Long num;
	private String isbn;
	private String image;
	private String name;
	private String writer;
	private String publisher;
	private String content;
	private Long price;
	
	public BooksVO() {}
	
	public BooksVO(String isbn,String image,  String name, String writer, String publisher, 
			String content,Long price) {
		// TODO Auto-generated constructor stub
		
		this.isbn = isbn;
		this.image = image;
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
		this.content = content;
		this.price = price;
		
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BooksVO [num=" + num + ", isbn=" + isbn + ", image=" + image + ", name=" + name + ", writer=" + writer
				+ ", publisher=" + publisher + ", content=" + content + ", price=" + price + "]";
	}
	
	 
}
