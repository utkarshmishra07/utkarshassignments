package com.mphasis.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.util.DbUtil;

public class Productdaoimpl implements ProductDao {
Connection con;
public Productdaoimpl() {
	con=DbUtil.getConnection();
}
	@Override
	public int addProduct(Product p) {
		int i = 0;
		try {
			String sql="insert into product values(pseq.nextval,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			//pst.setInt(1, p.getPid());
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getQuantity());
			pst.setDouble(3, p.getCost());
	
			i=pst.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateProduct(int pid, double cost,String pname, int qty) {
		int i = 0;
		try {
			String sql="update product set cost=?, quantity=?, pname=? where pid=?";
					PreparedStatement pst=con.prepareStatement(sql);
			pst.setDouble(1, cost);
			pst.setInt(2, qty);
			pst.setString(3, pname);
			pst.setInt(4, pid);
			i=pst.executeUpdate();
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteProduct(int pid) {
		int i = 0;
		try {
			String sql="delete from product where pid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,pid);
			pst.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		Product p=new Product();
		try {
			String sql="select * from product where pid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCost(rs.getDouble(3));
				p.setQuantity(rs.getShort(4));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> getProductByName(String pname) {
		//TODO Auto-generated method stub
		List<Product> p1 = new ArrayList<>();
		try {
			String sql="select * from product where pname=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, pname);
			ResultSet rs=pst.executeQuery();
			while(rs.next());
			{
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCost(rs.getDouble(3));
				p.setQuantity(rs.getShort(4));
				p1.add(p);

			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return p1;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products= new ArrayList<>();
try {
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from product");
	while(rs.next())
	{
		Product p=new Product();
		p.setPid(rs.getInt(1));
		p.setPname(rs.getString(2));
		p.setCost(rs.getDouble(3));
		p.setQuantity(rs.getShort(4));
		products.add(p);

	}
}catch(SQLException e)
{
	e.printStackTrace();
}
		return products;
	}

}
