package Java_bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

public class BeanIntrospection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(UserBean.class);
			PropertyDescriptor[] propertyDescriptor = beanInfo.getPropertyDescriptors();
			
			MethodDescriptor [] methodDescriptor = beanInfo.getMethodDescriptors(); 
			
			for(PropertyDescriptor pd: propertyDescriptor) {
				System.out.println(pd.getName() + " = " + pd.getPropertyType());
			}
			
			for(MethodDescriptor md: methodDescriptor) {
				System.out.println(md.getMethod().getName());
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
