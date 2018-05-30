package com.board.model.dao.service;
import com.board.model.dao.Board_Dao;
import com.board.model.vo.Board;
import static com.common.connect.JDBCTemplate.*;
import java.sql.*;
import java.util.*;




public class Board_Service {
	
	public ArrayList<Board> selectList(int currentPage, int limit){
		Connection result = getConnection();
		
		ArrayList<Board> list = new Board_Dao().selectList(result, currentPage , limit);
		
		System.out.println(list);
		close(result);
		return list;
		
	}

	public int getListCount() {
		Connection result =getConnection();
		int listCount = new Board_Dao().getListCount(result);
		close(result);
		return listCount;
	}
	
}
