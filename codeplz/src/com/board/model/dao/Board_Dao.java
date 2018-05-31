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
		
		String prop_Path = Board_Dao.class.getResource("/com/config/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(prop_Path));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	   public ArrayList<Board> selectList(Connection result, int currentPage, int limit) {
		      // Statement stmt = null;
		      PreparedStatement pstmt = null;

		      ResultSet rset = null;
		      ArrayList<Board> list = null;

		      String sql = prop.getProperty("selectList");

		      System.out.println(sql);

		      try {
		        
		         
		         pstmt = result.prepareStatement(sql);
		         
		         
		         
		         //조회 시작할 행 번호와 마지막 행 번호 계산 
		         int startRow = (currentPage - 1) * limit + 1;
		         int endRow = startRow + limit - 1;
		         
		         pstmt.setInt(1, startRow);
		         pstmt.setInt(2, endRow);
		         
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
		            
		            System.out.println(b);
		         }

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         
		         close(pstmt);
		      }

		      return list;
		   }

	public int getListCount(Connection result) {
		Statement stmt = null;
		
		int listCount = 0;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = result.createStatement();
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
		System.out.println(listCount);
		return listCount;
	}

	public Board Detail(Connection result, int index) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String sql = prop.getProperty("Detail");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, index);
			rset=pstmt.executeQuery();
			
			if(rset.next()){
				b =  new Board();
				b.setCol_board_index(rset.getInt("COL_BOARD_INDEX"));
				b.setCol_board_tags(rset.getString("COL_BOARD_TAGS"));
				b.setCol_board_title(rset.getString("COL_BOARD_TITLE"));
				b.setCol_board_content(rset.getString("COL_BOARD_CONTENT"));
				b.setCol_board_file(rset.getString("COL_BOARD_FILE"));
				b.setCol_board_writer(rset.getString("COL_USER_NICKNAME"));
				b.setCol_board_inserted_date(rset.getDate("COL_BOARD_INSERTED_DATE"));
				b.setCol_board_hits(rset.getInt("COL_BOARD_HITS"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public int updateCount(Connection result, int index) {
		PreparedStatement pstmt = null;
		int num =0;
		String sql = prop.getProperty("updateHits");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return num;
	}
	

}
