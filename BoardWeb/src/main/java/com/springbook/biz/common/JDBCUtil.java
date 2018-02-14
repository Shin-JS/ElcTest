package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","sa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		if(pstmt!=null) {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				pstmt = null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null) {
			try {
				if(!rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				rs = null;
			}
		}
		
		if(pstmt!=null) {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				pstmt = null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				conn = null;
			}
		}
	}
}
