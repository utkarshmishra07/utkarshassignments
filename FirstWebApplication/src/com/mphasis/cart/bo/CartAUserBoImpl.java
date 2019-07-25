package com.mphasis.cart.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.dao.CartAUserDao;
import com.mphasis.cart.dao.CartAUserDaoImpl;
import com.mphasis.cart.exceptions.BussinessException;
import com.mphasis.cart.util.DbUtil;

public class CartAUserBoImpl implements CartAUserBo {
 Connection con=null;
	CartAUserDao cartAUserDao;
		public CartAUserBoImpl() {
			cartAUserDao=new CartAUserDaoImpl();
			con=DbUtil.getConnection();
		}
		
		public void register(CartAUser user) throws BussinessException{
			if(user.getGender().matches("[mMfF]{1}")) {
				cartAUserDao.register(user);
			}
			else {
				throw new BussinessException("invalid gender entered");
			}
		}
	

	@Override
	public int changePassword(String email,String oldpass, String newpass) throws BussinessException, SQLException {
		int i=0;
		
		if(!oldpass.equals(newpass))
		{i=i+1;
			cartAUserDao.changePassword(email,oldpass,newpass);
		}
		else {
			throw new BussinessException("old ans new password should not be same");
		}
		return i;
	}

	@Override
	public CartAUser login(String email, String pass) {
		return cartAUserDao.login(email, pass);
	}
	
	

}
