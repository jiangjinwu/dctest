package com.dc.function.paper.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.jdbc.core.RowMapper;

@Entity

public class Paper  implements RowMapper<Paper>{

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer paperId;
	String paperName;
	
	
	Long paperCtime;
	String paperUid;
	Float paperPrice;
	
	
	public Integer getPaperId() {
		return paperId;
	}
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Long getPaperCtime() {
		return paperCtime;
	}
	public void setPaperCtime(Long paperCtime) {
		this.paperCtime = paperCtime;
	}
	public String getPaperUid() {
		return paperUid;
	}
	public void setPaperUid(String papeUid) {
		this.paperUid = papeUid;
	}
	
	public Float getPaperPrice() {
		return paperPrice;
	}
	public void setPaperPrice(Float paperPrice) {
		this.paperPrice = paperPrice;
	}
	public Paper mapRow(ResultSet rs, int arg1) throws SQLException {
		Paper paper = new Paper();
		
		paper.setPaperPrice(rs.getFloat("pape_price"));
		paper.setPaperUid(rs.getString("pape_uid"));
		paper.setPaperName(rs.getString("pape_name"));
		paper.setPaperCtime(rs.getLong("pape_ctime"));
		paper.setPaperId(rs.getInt("pape_id"));
		return paper;
	}

}
