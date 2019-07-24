package shoppingcart;
import java.util.List;

import shoppingcart.CartAUser;
public interface CartAUserBo {
	public void register(CartAUser user) throws BusinessException;
	CartAUser login(String email, String pass);
	public int changePassword(String oldpass, String newpass)throws BusinessException;
	public int addProduct(Product p);
	public int updateProduct(int pid, double cost, int qty);
	public int deleteProduct(int pid);
	public Product getById(int pid);
	public List<Product> getProductByName(String pname);
	public List<Product> getAll();
}
