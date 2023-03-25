package services;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import data.DbProvider;
import models.Product;


public class ProductsService {
	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	
	public ProductsService() {
		conn = null;
		stmt = null;
		res = null;
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DbProvider.getMySqlConnection();
			stmt = conn.createStatement();
			res = stmt.executeQuery("select * from products order by id");
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				float price = res.getFloat("price");
				Product product = new Product(id,name,price);
				products.add(product);
			}
			
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Class not found exception: " + ex.getMessage());
		}catch(SQLException ex) {
			System.out.println("Runtime sql exception: " + ex.getMessage());
		}finally {
			try {
				if(res != null)
					res.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}catch(SQLException ex) {
				System.out.println("Final sql exception: " + ex.getMessage());
			}
		}
		return products;
	}
	
}
