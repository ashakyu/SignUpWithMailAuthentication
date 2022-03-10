package spring;

public class BookBoard {
	private int num;
	private String isbn;
	private String name;
	private String auth;
	private String publisher;
	private int price;
	private String image;
	private String description;

	public BookBoard(String isbn, String name, String auth, String publisher, int price, String image,
			String description) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.auth = auth;
		this.publisher = publisher;
		this.price = price;
		this.image = image;
		this.description = description;
	}
	public BookBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
