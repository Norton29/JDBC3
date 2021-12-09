package aplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {
	
	public static void main(String[] args) {
		
		
		
	
		Connection conn = null;
		Statement st = null;
		
		try {
		
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			st = conn.createStatement();
			
			st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 1");
			
			
			st.executeUpdate("UPDATE seller SET BaseSalary = 4090 WHERE DepartmentId = 3");
		
			

			conn.commit();
		
		}catch(SQLException e){
			
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by:" + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			
			}
			
		}
		
		finally {
		DB.closeStatament(st);
		DB.closeConnection();
		
		}
		
		
		

		}
		
	}

