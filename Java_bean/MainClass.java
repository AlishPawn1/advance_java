package Java_bean;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserBean user = new UserBean();
		user.setEmail("User@gmail.com");
		user.setName("User");
		user.setAge(21);
		
		System.out.println(user.getName() + ", " + user.getEmail() + ", " + user.getAge() + ", ");

	}

}
