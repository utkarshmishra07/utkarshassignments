package com.mphasis.cart.bo;

import java.sql.SQLException;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.exceptions.BussinessException;

public interface CartAUserBo {
	public void register(CartAUser user) throws BussinessException;
	public int  changePassword(String email,String oldpass,String newpass) throws BussinessException, SQLException;
	public CartAUser login(String email,String pass);
	
}
