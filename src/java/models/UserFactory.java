
package models;

public class UserFactory {
    
    	public User getUser(String user) {

		if (user.equals("admin")) {
			return new Admin();

		} else if (user.equals("customer")) {
			return new Customer();
                }
		 else
			return null;
	}
     
}
