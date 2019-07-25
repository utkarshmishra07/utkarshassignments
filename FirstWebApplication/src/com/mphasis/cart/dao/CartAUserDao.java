package com.mphasis.cart.dao;

import java.sql.SQLException;

import com.mphasis.cart.beans.CartAUser;

public interface CartAUserDao {
	public void register(CartAUser c);
	public CartAUser login(String email,String pass);
	public int changePassword(String email,String oldpass,
			String newpass) throws SQLException;
	
}