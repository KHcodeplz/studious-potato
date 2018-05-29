package com.board.model.service;
import com.board.model.dao.Board_Dao;
import com.board.model.vo.Board;
import static com.common.connect.JDBCTemplate.*;
import java.sql.*;
import java.util.*;




public class Board_Service {
	
	public ArrayList<Board> selectList(int currentPage, int limit){
		Connection con = getConnection();
		
		ArrayList<Board> list = new Board_Dao().selectList(con, currentPage , limit);
		
		close(con);
		return list;
		
	}

	public int getListCount() {
		Connection con =getConnection();
		int listCount = new Board_Dao().getListCount(con);
		close(con);
		return listCount;
	}
	
}
