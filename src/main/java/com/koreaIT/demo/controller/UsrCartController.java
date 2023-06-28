package com.koreaIT.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.BoardService;
import com.koreaIT.demo.service.CartService;
import com.koreaIT.demo.service.ReplyService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Cart;
import com.koreaIT.demo.vo.ResultData;
import com.koreaIT.demo.vo.Rq;

@Controller
public class UsrCartController {

	private CartService cartService;
	private BoardService boardService;
	private ReplyService replyService;
	private Rq rq;

	@Autowired
	public UsrCartController(CartService cartService,Rq rq) {
		this.cartService = cartService;
		this.boardService = boardService;
		this.replyService = replyService;
		this.rq = rq;
	}

	@RequestMapping("/usr/cart/doAdd")
	@ResponseBody
	public String doAdd(int id, int memberId, int productNum) {

		if (rq.getLoginedMemberId() == 0) {
			return Util.jsHistoryBack("로그인 후 이용해주세요");
		}
		Cart cart = cartService.getCartById(id);

		ResultData actorAddRd = cartService.actorCanMD(rq.getLoginedMemberId(), cart);

		if (actorAddRd.isFail()) {
			return Util.jsHistoryBack(actorAddRd.getMsg());
		}

		cartService.cartAdd(id, memberId, productNum);

		return Util.jsReplace(Util.f("%d번 게시물을 추가했습니다", id), "C_list");
		
	}

	@RequestMapping("/usr/cart/C_list")
	public String C_list(Model model) {

//		int membersCnt = memberService.getMembersCnt(authLevel, searchKeywordType, searchKeyword);

//		if (page <= 0) {
//			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
//		}

//		int itemsInAPage = 10;
//		int pagesCount = (int) Math.ceil((double) membersCnt / itemsInAPage);

//		List<Product> products = productService.getProducts(rq.getLoginedMemberId());

//		model.addAttribute("pagesCount", pagesCount);
//		model.addAttribute("page", page);
//		model.addAttribute("membersCnt", membersCnt);
//		model.addAttribute("producdgbn78. m8i ts", products);
//		model.addAttribute("authLevel", authLevel);
//		model.addAttribute("searchKeyword", searchKeyword);
//		model.addAttribute("searchKeywordType", searchKeywordType);
		return "/usr/cart/C_list";
	}
}
