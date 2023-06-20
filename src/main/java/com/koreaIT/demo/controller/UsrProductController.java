package com.koreaIT.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koreaIT.demo.service.BoardService;
import com.koreaIT.demo.service.ProductService;
import com.koreaIT.demo.service.ReplyService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Article;
import com.koreaIT.demo.vo.FileVO;
import com.koreaIT.demo.vo.Product;
import com.koreaIT.demo.vo.Reply;
import com.koreaIT.demo.vo.Rq;

@Controller
public class UsrProductController {

	private ProductService productService;
	private BoardService boardService;
	private ReplyService replyService;
	private Rq rq;

	@Autowired
	public UsrProductController(ProductService productService, BoardService boardService,  ReplyService replyService, Rq rq) {
		this.productService = productService;
		this.boardService = boardService;
		this.replyService = replyService;
		this.rq = rq;
	}

	@RequestMapping("/usr/product/register")
	public String wirte() {

		return "/usr/product/register";
	}
	
	@RequestMapping("/usr/product/doRegister")
	@ResponseBody
	public String doRegister(MultipartFile file, int boardId, String title, String report, String price) {

		
		if (Util.empty(title)) {
			return Util.jsHistoryBack("제목을 입력해주세요.");
		}

		if (Util.empty(report)) {
			return Util.jsHistoryBack("상품정보를 입력해주세요.");
		}
		if (Util.empty(price)) {
			return Util.jsHistoryBack("가격정보를 입력해주세요.");
		}
		
		try {
			productService.saveFile(file, rq.getLoginedMemberId(), boardId, title, report, price);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Util.jsReplace("거래품목을 등록하였습니다.", "P_list");
	}
		
	@RequestMapping("/usr/product/P_list")
	public String showList(Model model) {

//		if (page <= 0) {
//			return rq.jsReturnOnView("페이지번호가 존재하지 않습니다.", true);
//		}
//		Board board = boardService.getBoardById(boardId);
//
//		if (board == null) {
//			return rq.jsReturnOnView("존재하지않는 게시글입니다.", true);
//		}
//
//		int itemsInAPage = 10;

		List<Product> products = productService.getProducts();
//		model.addAttribute("page", page);
//		model.addAttribute("pagesCount", pagesCount);
//		model.addAttribute("articlesCnt", articlesCnt);
		model.addAttribute("products", products);
//		model.addAttribute("board", board);
//		model.addAttribute("searchKeywordType", searchKeywordType);
//		model.addAttribute("searchKeyword", searchKeyword);

		return "usr/product/P_list";
	}
	@RequestMapping("/usr/product/file/{fileId}")
	@ResponseBody
	public Resource downloadImage(@PathVariable("fileId") int id, Model model) throws IOException {

		Product product = productService.getProductyId(id);

		return new UrlResource("file:" + product.getSavedPath()); 
	}
	@RequestMapping("/usr/product/P_detail")
	public String showDetail(Model model, int id) {
		
//		Cookie oldCookie = null;
//		Cookie[] cookies = req.getCookies();
//		
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("hitCount")) {
//					oldCookie = cookie;
//				}
//			}
//		}
//		
//		if (oldCookie != null) {
//			if (!oldCookie.getValue().contains("[" + id + "]")) {
//				productService.increaseHitCount(id);
//				oldCookie.setValue(oldCookie.getValue() + "_[" + id + "]");
//				oldCookie.setPath("/");
//				oldCookie.setMaxAge(30 * 60);
//				resp.addCookie(oldCookie);
//			}
//		} else {
//			productService.increaseHitCount(id);
//			Cookie newCookie = new Cookie("hitCount", "[" + id + "]");
//			newCookie.setPath("/");
//			newCookie.setMaxAge(30 * 60);
//			resp.addCookie(newCookie);
//		}
//		
//		List<Reply> replies = replyService.getReplies(rq.getLoginedMemberId(), "article", id);
		
		Product product = productService.getForPrintProduct(id);

//		productService.actorCanChangeData(rq.getLoginedMemberId(), article);

		model.addAttribute("product", product);
//		model.addAttribute("replies", replies);

		return "usr/product/P_detail";
	}

}
