package shoppingcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import shoppingcart.DbUtil;
import shoppingcart.Product;

public class ProductDaoImpl implements ProductDao {
	Connection con;
	public ProductDaoImpl() {
	con=DbUtil.getConnection();
	}
	@Override
	public int addProduct(Product p) {
		int i=0;
		try {
			String sql="insert into product values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, p.getPid());
			pst.setString(2, p.getPname());
			pst.setInt(3, p.getQty());
			pst.setDouble(4, p.getCost());
		
			i=pst.executeUpdate();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}	
		return i;
	}
	@Override
	public int updateProduct(int pid, double cost, int qty) {
		int i=0;
		try{String sql ="update product set cost=?. quantity=? where pid=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setDouble(1, cost);
		pst.setInt(2, qty);
		pst.setInt(3, pid);
		i=pst.executeUpdate();
		}catch(SQLException e) {
			e.getStackTrace();
		}
		return i;
	}
	@Override
	public Product getById(int pid) {
		Product p=new Product();
		try {
			String sql="select * from product where pid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCost(rs.getDouble(3));
				p.setQty(rs.getShort(4));
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}
		return p;
	}
	@Override
	public List<Product> getAll() {
		List<Product> products=new ArrayList<>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from product");
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCost(rs.getDouble(3));
				p.setQty(rs.getShort(4));
				products.add(p);
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}
		return products;
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
                        p.setQty(rs.getShort(4));
                        p1.add(p);

                  }
           }catch(SQLException e)
           {
                  e.printStackTrace();
           }
           return p1;
    }
    @Override
    public int deleteProduct(int pid) {
           int i = 0;
           try {
                  String sql="delete from prdouct where pid=?";
                  PreparedStatement pst=con.prepareStatement(sql);
                  pst.setInt(1,pid);
                  pst.executeUpdate();
           }catch(SQLException e)
           {
                  e.printStackTrace();
           }
           return i;
    }




}
