package com.koreaIT.demo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int productNum;
	private int cartStock;
	
}

