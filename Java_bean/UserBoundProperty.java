package Java_bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

public class UserBoundProperty implements Serializable {

	private String name;
	private final PropertyChangeSupport support;
	
	public UserBoundProperty() {
		support = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
	
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		support.firePropertyChange("name", oldName, name);
	}
	
//	veteoable change property
	
	private String email;
	private final VetoableChangeSupport vCS = new VetoableChangeSupport(this);
	
	public void addVetoableChangeListener(VetoableChangeListener listener) {
		vCS.addVetoableChangeListener(listener);
	}
	
	public void setEmail(String email) {
		String oldEmail = this.email;
		this.email = email;
//		try {
//			support.firePropertyChange("Email", oldEmail, email);
//		} catch(PropertyVetoException e) {
//			e.printStackTrace();
//		}
		support.firePropertyChange("Email", oldEmail, email);
	}
}
