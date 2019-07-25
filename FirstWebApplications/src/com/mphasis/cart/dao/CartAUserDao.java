package com.mphasis.cart.dao;

import com.mphasis.cart.beans.CartA;

public interface CartAUserDao {
	public void register(CartA c);
	public CartA login(String email,String pass);
	public int changePassword(String oldpass,String newpass);


}
