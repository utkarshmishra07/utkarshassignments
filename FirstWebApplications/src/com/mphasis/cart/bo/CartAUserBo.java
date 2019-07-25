package com.mphasis.cart.bo;

import com.mphasis.cart.beans.CartA;
import com.mphasis.cart.exceptions.BuisnessException;
public interface CartAUserBo {
	public void register(CartA user)throws BuisnessException;
	public int changePassword(String emailid,String password)throws BuisnessException;
	public CartA login(String email,String pass);
}

