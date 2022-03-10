package board;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Alias("InsertVO")
public class InsertVO {
	@Length(min=8, max=8, message="8자리 숫자 입력")
	private String isbn;
	private String name;
	private MultipartFile image;
	private String writer;
	private String publisher;
	private String content;
	private Long price;
	
	private String filename;

	public InsertVO() {}
	
	public InsertVO(String isbn, String name, MultipartFile image, String writer, String publisher, String content, Long price) {
		this.isbn = isbn;
		this.name = name;
		this.image = image;
		this.writer = writer;
		this.publisher = publisher;
		this.content = content;
		this.price = price;
		
	}

	@Override
	public String toString() {
		return "InsertVO [isbn=" + isbn + ", name=" + name + ", image=" + image + ", writer=" + writer + ", publisher="
				+ publisher + ", content=" + content + ", price=" + price + ", filename=" + filename + "]";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
 
}
