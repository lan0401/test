package com.xiaolan.mybatis.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcTest {
	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement prep=null;
		ResultSet  resultset=null;
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncode=utf-8&serverTimezone=UTC","root","xiaolan");
			
			String sql="select * from user where username= ? ";
			
			prep=connection.prepareStatement(sql);
			
			prep.setString(1, "����");
			
			resultset=prep.executeQuery();
			
			
			while(resultset.next()){
				System.out.println(resultset.getString("id")+" "+resultset.getString("username"));
			}
			
			
		} catch (Exception e){
			System.out.println(e);
		}finally{
			
		}
	}
	
}
