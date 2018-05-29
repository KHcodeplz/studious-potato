package com.board.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import com.board.model.vo.Board;
import static com.common.connect.JDBCTemplate.*;

public class Board_Dao {
		
	private Properties prop;
	
	public Board_Dao(){
		prop= new Properties();
		
		String prop_Path = Board_Dao.class.getResource("/config/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(prop_Path));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	   public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		      // Statement stmt = null;
		   ArrayList<Board> list = null;
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;

		      String query = prop.getProperty("selectList");

		      System.out.println(query);

		      try {
		         // 페이징처리 전
		         // stmt = con.createStatement();
		         // rset = stmt.executeQuery(query);

		         // 페이징처리 후
		         
		         pstmt = con.prepareStatement(query);
		         
		         //조회 시작할 행 번호와 마지막 행 번호 계산 
		         int startRow = (currentPage - 1) * limit + 1;
		         int endRow = startRow + limit - 1;
		         
		         pstmt.setInt(1, startRow); pstmt.setInt(2, endRow);
		         
		         rset = pstmt.executeQuery();
		          
		         
		         list = new ArrayList<Board>();

		         while (rset.next()) {
		            Board b = new Board();
		            //넘버 타이틀 작성자 추천수 조회수
		            b.setCol_board_index(rset.getInt("COL_BOARD_INDEX"));
		            b.setCol_board_title(rset.getString("COL_BOARD_TITLE"));
		            b.setCol_board_writer(rset.getString("COL_USER_NICKNAME"));
		            b.setCol_board_hits(rset.getInt("COL_BOARD_HITS"));
		            list.add(b);
		          
		         }

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         //close(stmt);
		         close(pstmt);
		      }

		      return list;
		   }

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()){
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}
	

}
