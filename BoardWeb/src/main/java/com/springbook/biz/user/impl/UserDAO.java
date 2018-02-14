package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;
@Repository
public class UserDAO {
	//JDBC관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//sql문
	private final String USER_GET = "select * from users where id=? and password=?";
	private final String USER_SET = "insert into users values(?,?,?,?)";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===>JDBC로 getUser()기능 처리");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}

	public UserVO setUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===>JDBC로 setUser()기능 처리");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_SET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			int result = pstmt.executeUpdate();
			if(result>0) {
				user = getUser(vo);
			}else {
				System.out.println("망했어요");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
	
}
