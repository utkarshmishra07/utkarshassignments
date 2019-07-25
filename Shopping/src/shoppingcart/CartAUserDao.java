package shoppingcart;
import shoppingcart.CartAUser;

public interface CartAUserDao {
	//public void addUser(CartAUser c);
	 CartAUser login(String email, String pass);
	public int changePassword(String oldpass, String newpass);
	public void register(CartAUser c);

}
