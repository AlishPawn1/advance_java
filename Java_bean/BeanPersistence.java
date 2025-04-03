package Java_bean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BeanPersistence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserBean user = new UserBean();
		user.setName("New user");
		user.setEmail("NewUser@gmail.com");
		user.setAge(21);
		
//		serialize the bean
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userbean"))){
			out.writeObject(user);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
//		Deserialize the bean
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("userbean"))){
			UserBean retrieve = (UserBean) in.readObject();
			System.out.println("Retrieved user " + retrieve);
		} catch(Exception e) {
			System.out.println(e.toString());
		}

	}

}
