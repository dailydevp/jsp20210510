package ch08;
//기본생상자/겟셋메소드 -자바빈.
//프로퍼티는 겟셋에서 겟쎗 없앤 뒤의 애들. 
//코드 프로퍼티. 타이틀프로퍼티 등등 소문자로시작code
//필드명과 프로퍼티명이 대부분 같음
//프로퍼티는 메소드에 의해 결정된다
//is---라고프리픽스하는게 뷸리언 타입 프로퍼티일 경우의 관습.
//셋타입은 상관없고 겟일 경우에만!!
//유즈빈은 딱히 많이 쓰이는 타입은 아님. 챕탸8!

public class Book {
	private String code;
	private String title;
	private String writer;
	private String publisher;
	private int price;
	private boolean out;
	
	public boolean isOut() {
		return out;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
