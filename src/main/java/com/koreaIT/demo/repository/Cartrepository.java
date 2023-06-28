package com.koreaIT.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.demo.vo.Cart;

@Mapper
public interface Cartrepository {

	public void cartAdd(int id, int memberId, int productNum);

	public Cart getCartById(int id);

}
