package datebaseMVC;
public class UserData {
	private String name;
	private String email;
	private float height;
	private Long phone;
	public UserData(String name, String email, float height, Long phone) {
		super();
		this.name = name;
		this.email = email;
		this.height = height;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
