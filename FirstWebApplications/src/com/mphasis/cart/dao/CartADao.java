package com.mphasis.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mphasis.cart.beans.CartA;
import com.mphasis.cart.util.DbUtil;

public  class CartADao implements CartAUserDao {
	Connection con;
	public CartADao()
	{
		con=DbUtil.getConnection();
	}
	@Override
	public void register(CartA c) {
		// TODO Auto-generated method stub
		try {
		String sql="insert into carta  (userid,username,emailid,password,dor,crcardno,gender,role) values(?,?,?,?,sysdate,?,?,?)";
	PreparedStatement pst;
	
		pst = con.prepareStatement(sql);
	
	pst.setInt(1,c.getUserid());
	pst.setString(2, c.getUsername());
	pst.setString(3, c.getEmailid());
	pst.setString(4, c.getPassword());
	pst.setLong(5, c.getCrcardno());
	pst.setString(6, c.getGender());
	pst.setString(7,c.getRole());
	pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public CartA login(String email, String pass) {
		CartA user=new CartA();
		try {
		PreparedStatement pst=con.prepareStatement("select * from carta where emailid=? and password=?");
		pst.setString(1, email);
		pst.setString(2, pass);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setEmailid(rs.getString(4));
			
			user.setDor(rs.getString(5));
			user.setCrcardno(rs.getLong(6));
			user.setGender(rs.getString(7));
			user.setRole(rs.getString(8));

		}
		}catch(SQLException e) {e.printStackTrace();}
		return user;
	}

	
	@Override
	public int changePassword(String emailid, String password) {
		int i=0;
		try {
			PreparedStatement pst=con.prepareStatement("update carta set password=? where  emailid=?");
			pst.setString(1, password);
			pst.setString(2, emailid);
		    i=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
