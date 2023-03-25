package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.DbProvider;
import models.Department;

public class DepsService {
	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	private int status;
	
	public DepsService() {
		conn = null;
		stmt = null;
		res = null;
		pstmt = null;
		status = 0;
	}
	public List<Department> getAllDeps(){
		List<Department> deps = new ArrayList<Department>();
		try {
			conn = DbProvider.getMySqlConnection();
			stmt = conn.createStatement();
			res = stmt.executeQuery("select * from departments order by id");
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				Department dep = new Department(id,name);
				deps.add(dep);
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
		return deps;
	}
	
}
