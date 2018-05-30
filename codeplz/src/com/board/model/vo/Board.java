package com.board.model.vo;

import java.io.Serializable;
import java.util.*;

public class Board  implements Serializable{
	private static final long serialVersionUID = 1L;
	public Board(int col_board_index, String col_board_title, int col_board_hits, String col_board_writer) {
		super();
		this.col_board_index = col_board_index;
		this.col_board_title = col_board_title;
		this.col_board_hits = col_board_hits;
		this.col_board_writer = col_board_writer;
	}
	

	private int col_board_index;
	private int col_board_category_index;
	private String col_board_tags;
	private String col_board_title;
	private String col_board_content;
	private String col_board_file;
	private int col_board_hits;
	private String col_board_writer;
	private Date col_board_inserted_date;
	private Date col_board_modified_date;
	private int col_board_is_deleted;
	
	
	public Board() {
		super();
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col_board_category_index;
		result = prime * result + ((col_board_content == null) ? 0 : col_board_content.hashCode());
		result = prime * result + ((col_board_file == null) ? 0 : col_board_file.hashCode());
		result = prime * result + col_board_hits;
		result = prime * result + col_board_index;
		result = prime * result + ((col_board_inserted_date == null) ? 0 : col_board_inserted_date.hashCode());
		result = prime * result + col_board_is_deleted;
		result = prime * result + ((col_board_modified_date == null) ? 0 : col_board_modified_date.hashCode());
		result = prime * result + ((col_board_tags == null) ? 0 : col_board_tags.hashCode());
		result = prime * result + ((col_board_title == null) ? 0 : col_board_title.hashCode());
		result = prime * result + ((col_board_writer == null) ? 0 : col_board_writer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (col_board_category_index != other.col_board_category_index)
			return false;
		if (col_board_content == null) {
			if (other.col_board_content != null)
				return false;
		} else if (!col_board_content.equals(other.col_board_content))
			return false;
		if (col_board_file == null) {
			if (other.col_board_file != null)
				return false;
		} else if (!col_board_file.equals(other.col_board_file))
			return false;
		if (col_board_hits != other.col_board_hits)
			return false;
		if (col_board_index != other.col_board_index)
			return false;
		if (col_board_inserted_date == null) {
			if (other.col_board_inserted_date != null)
				return false;
		} else if (!col_board_inserted_date.equals(other.col_board_inserted_date))
			return false;
		if (col_board_is_deleted != other.col_board_is_deleted)
			return false;
		if (col_board_modified_date == null) {
			if (other.col_board_modified_date != null)
				return false;
		} else if (!col_board_modified_date.equals(other.col_board_modified_date))
			return false;
		if (col_board_tags == null) {
			if (other.col_board_tags != null)
				return false;
		} else if (!col_board_tags.equals(other.col_board_tags))
			return false;
		if (col_board_title == null) {
			if (other.col_board_title != null)
				return false;
		} else if (!col_board_title.equals(other.col_board_title))
			return false;
		if (col_board_writer == null) {
			if (other.col_board_writer != null)
				return false;
		} else if (!col_board_writer.equals(other.col_board_writer))
			return false;
		return true;
	}
	public int getCol_board_index() {
		return col_board_index;
	}
	public void setCol_board_index(int col_board_index) {
		this.col_board_index = col_board_index;
	}
	public int getCol_board_category_index() {
		return col_board_category_index;
	}
	public void setCol_board_category_index(int col_board_category_index) {
		this.col_board_category_index = col_board_category_index;
	}
	public String getCol_board_tags() {
		return col_board_tags;
	}
	public void setCol_board_tags(String col_board_tags) {
		this.col_board_tags = col_board_tags;
	}
	public String getCol_board_title() {
		return col_board_title;
	}
	public void setCol_board_title(String col_board_title) {
		this.col_board_title = col_board_title;
	}
	public String getCol_board_content() {
		return col_board_content;
	}
	public void setCol_board_content(String col_board_content) {
		this.col_board_content = col_board_content;
	}
	public String getCol_board_file() {
		return col_board_file;
	}
	public void setCol_board_file(String col_board_file) {
		this.col_board_file = col_board_file;
	}
	public int getCol_board_hits() {
		return col_board_hits;
	}
	public void setCol_board_hits(int col_board_hits) {
		this.col_board_hits = col_board_hits;
	}
	public String getCol_board_writer() {
		return col_board_writer;
	}
	public void setCol_board_writer(String col_board_writer) {
		this.col_board_writer = col_board_writer;
	}
	public Date getCol_board_inserted_date() {
		return col_board_inserted_date;
	}
	public void setCol_board_inserted_date(Date col_board_inserted_date) {
		this.col_board_inserted_date = col_board_inserted_date;
	}
	public Date getCol_board_modified_date() {
		return col_board_modified_date;
	}
	public void setCol_board_modified_date(Date col_board_modified_date) {
		this.col_board_modified_date = col_board_modified_date;
	}
	public int getCol_board_is_deleted() {
		return col_board_is_deleted;
	}
	public void setCol_board_is_deleted(int col_board_is_deleted) {
		this.col_board_is_deleted = col_board_is_deleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Board(int col_board_index, int col_board_category_index, String col_board_tags, String col_board_title,
			String col_board_content, String col_board_file, int col_board_hits, String col_board_writer,
			Date col_board_inserted_date, Date col_board_modified_date, int col_board_is_deleted) {
		super();
		this.col_board_index = col_board_index;
		this.col_board_category_index = col_board_category_index;
		this.col_board_tags = col_board_tags;
		this.col_board_title = col_board_title;
		this.col_board_content = col_board_content;
		this.col_board_file = col_board_file;
		this.col_board_hits = col_board_hits;
		this.col_board_writer = col_board_writer;
		this.col_board_inserted_date = col_board_inserted_date;
		this.col_board_modified_date = col_board_modified_date;
		this.col_board_is_deleted = col_board_is_deleted;
	}
	
	
	
	
}
