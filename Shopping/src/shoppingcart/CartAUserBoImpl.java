/**
 * 
 */
package shoppingcart;

import java.util.List;

/**
 * @author utkarsh.mishra1
 *
 */
public class CartAUserBoImpl implements CartAUserBo  {
	CartAUserDao cartAUserDao;
	public CartAUserBoImpl() {
		cartAUserDao=new CartAUserDaoImpl();
	}

	@Override
	public void register(CartAUser user)throws BusinessException {
		// TODO Auto-generated method stub
		if(user.getGender().matches("[mMfF]{1}")) {
			cartAUserDao.register(user);
		}else {
			throw new BusinessException("Invalid Gender");
		}
	}

	@Override
	public CartAUser login(String email, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changePassword(String oldpass, String newpass) {
		
		int i=0;
		if(!oldpass.equals(newpass)) {
			cartAUserDao.changePassword(oldpass, newpass);
		}else {
			System.out.println("Old and New passwords cannot be same.");
		}
		return i;
	}

	@Override
	public int addProduct(Product p) {

		return 0;
	}

	@Override
	public int updateProduct(int pid, double cost, int qty) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByName(String pname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
