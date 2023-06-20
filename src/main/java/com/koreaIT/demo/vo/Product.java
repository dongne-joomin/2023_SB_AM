package com.koreaIT.demo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int boardId;
	private String title;
	private String report;
	private String price;
	private String orgName;
	private String savedName;
	private String savedPath;
	private String hitCount;
	
	private String writerName;
	private int sumReactionPoint;
	private int goodReactionPoint;
	private int badReactionPoint;
	
}

