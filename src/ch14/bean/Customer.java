package ch14.bean;

public class Customer {
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", city=" + city + ", id=" + id + ", contactName=" + contactName
				+ ", address=" + address + ", postalCode=" + postalCode + ", country=" + country + "]";
	}
	private String name;
	private String city;
	private int id;
	private String contactName;
	private String address;
	private String postalCode;
	private String country;
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
