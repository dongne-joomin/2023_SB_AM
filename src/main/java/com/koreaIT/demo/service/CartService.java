package com.koreaIT.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.demo.repository.Cartrepository;
import com.koreaIT.demo.vo.Cart;
import com.koreaIT.demo.vo.ResultData;

@Service
public class CartService {
	private Cartrepository cartrepository;
	
	@Autowired
	public CartService(Cartrepository cartrepository) {
		this.cartrepository = cartrepository;
		
	}

	public void cartAdd(int id, int memberId, int productNum) {
		cartrepository.cartAdd(id, memberId, productNum);
	}

	public int getLastInsertId() {
		return 0;
	}

	public Cart getCartById(int id) {
		return cartrepository.getCartById(id);
	}

	public ResultData actorCanMD(int loginedMemberId, Cart cart) {
		if (cart == null) {
			return ResultData.from("F-1", "해당 게시물은 존재하지 않습니다.");
		}

		if (loginedMemberId != cart.getMemberId()) {
			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다");
		}
		return ResultData.from("S-1", "가능");
	}
}
