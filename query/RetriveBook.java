package com.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.ConnectionFactory;

public class RetriveBook {
public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionFactory.getDbConn();

			String sql = "select * from book";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				System.out.println(rs.getInt(1)+"--"+
				rs.getString(2)+"--"+
				rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println("Error:: " + e.getMessage());
		}
		
	}
	
}
