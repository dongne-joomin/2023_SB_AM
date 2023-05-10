package com.koreaIT.demo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int boardId;
	private String title;
	private String body;
	private String hitCount;
	
	private String writerName;
	private boolean actorCanChangeData;
	private int sumReactionPoint;
	private int goodReactionPoint;
	private int badReactionPoint;
	
	public String getForPrintBody () {
		return this.body.replaceAll("\n", "<br>");
	}
	
}

