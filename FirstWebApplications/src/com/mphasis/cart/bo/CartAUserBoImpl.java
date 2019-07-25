package com.mphasis.cart.bo;

import com.mphasis.cart.beans.CartA;
import com.mphasis.cart.dao.CartADao;
import com.mphasis.cart.dao.CartAUserDao;
import com.mphasis.cart.exceptions.BuisnessException;

public class CartAUserBoImpl implements CartAUserBo {
	CartAUserDao cartAUserDao;
	public  CartAUserBoImpl()
	{
		cartAUserDao=new CartADao(); 
	}
	@Override
	public void register(CartA user) throws BuisnessException
	{
		if(user.getGender().matches("[mMfF]{1}"))
		{
			cartAUserDao.register(user);
			
		}else
		{
			throw new BuisnessException
			("entered Invalid gender");
		}
	}
	@Override
	public int changePassword(String emailid, String password) throws BuisnessException {
		return cartAUserDao.changePassword(emailid, password);
	}
	@Override
	public CartA login(String email, String pass) {
		System.out.println("Bo called"+email +" "+pass);
		return cartAUserDao.login(email, pass);
	}
}
