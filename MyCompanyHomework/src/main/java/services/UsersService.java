package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.DbProvider;

public class UsersService {
	private Connection conn;
	private ResultSet res;
	private PreparedStatement pstmt;
	private String query;
	private int status;	
	
	public UsersService() {
		conn = null;
		res = null;
		pstmt = null;
		query = "";
		status = 0;
	}
	
	public boolean addUser(String login, String passw, String email, String regdate, int roleId, int statusId) {
		boolean success = false;
		
		try {
			query = "insert into users";
			query += " (login, passw, email, regdate, role_id, status_id)";
			query += " values(?, ?, ?, ?, ?, ?)";
			conn = DbProvider.getMySqlConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, login);
			pstmt.setString(2, passw);
			pstmt.setString(3, email);
			pstmt.setString(4, regdate);
			pstmt.setInt(5, roleId);
			pstmt.setInt(6, statusId);
			
			status = pstmt.executeUpdate();
			
			if(status != 0) {
				success = true;
			}
			
		}catch(ClassNotFoundException ex) {
			System.out.println("addUser - classNotFoundException: " + ex.getMessage());
			success = false;
		}catch(SQLException ex) {
			System.out.println("addUser - SQLException: " + ex.getMessage());
			success = false;
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
				if(res!=null){
					res.close();
				}
			}catch(SQLException ex) {
				System.out.println("addUser - SQLException: " + ex.getMessage());
				success = false;
			}
		}
		
		return success;
	}
	
	public boolean loginUser(String login, String hashedPassword) {
		boolean success = false;
		try {
			query = "select login passw from users";
			query += " where login=? and passw=?";
			conn = DbProvider.getMySqlConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, login);
			pstmt.setString(2, hashedPassword);
			
			res = pstmt.executeQuery();
			if(res.next())
				success = true;
			
			
		}catch(SQLException ex) {
			System.out.println("SQL Exception - " + ex.getMessage());
		}catch(ClassNotFoundException ex) {
			System.out.println("CLassNotFound exception " + ex.getMessage());
		}finally {
			try {
				pstmt.close();
				conn.close();
				res.close();
			}
			catch (SQLException ex) {
				System.out.println("Closing exception " + ex.getMessage());
			}catch(Exception ex) {
				System.out.println("Closing exception " + ex.getMessage());
			}
			
		}
		return success;
	}
	
}
