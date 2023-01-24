package com.query;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.ConnectionFactory;

public class InsertBook {
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionFactory.getDbConn();

			int id[] = new int[] { 1, 2, 3 };

			String name[] = new String[] { "Oracle", "Network Security", "Ds" };

			Double price[] = new Double[] { 200.00, 400.00, 500.00 };

			String sql = "INSERT INTO BOOK(BOOK_ID,BOOK_NAME,BOOK_PRICE) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);for(
			int i = 0;i<id.length;i++)
			{
				ps.setInt(1, id[i]);
				ps.setString(2, name[i]);
				ps.setDouble(3, price[i]);
				ps.addBatch();
			}
			int[] count = ps.executeBatch();System.out.println("Records Effected ::"+count.length);

			conn.close();

			System.out.println("Execution Completed...");

			}catch(
			Exception e)
			{
				System.out.println("Error:: " + e.getMessage());
			}

	}
	

}

