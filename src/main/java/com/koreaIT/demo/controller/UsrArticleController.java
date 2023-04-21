package com.koreaIT.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.ArticleService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Article;
import com.koreaIT.demo.vo.ResultData;

@Controller
public class UsrArticleController {

	private ArticleService articleService;

	@Autowired
	public UsrArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// 액션 메서드
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData<Article> doAdd(HttpSession httpSession, String title, String body) {
		
		if (httpSession.getAttribute("loginedMemberId") == null) {
			return ResultData.from("F-A", "로그인후 이용해주세요.");
		}
		
		if (Util.empty(title)) {
			return ResultData.from("f-1", "제목을 입력해주세요.");
		}
		
		if (Util.empty(body)) {
			return ResultData.from("f-1", "내용을 입력해주세요.");
		}
		
		articleService.writeArticle((int) httpSession.getAttribute("loginedMemberId"), title, body);
		
		int id = articleService.getLastInserId();
		
		return ResultData.from("S-1", Util.f("%d번 게시물이 생성되었습니다.", id), "articles" ,articleService.getArticleById(id));
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData<Article> getArticle(int id) {

		Article article = articleService.getArticleById(id);

		if (article == null) {
//			return id + "번 게시물은 존재하지 않습니다.";
			return ResultData.from("F-1", Util.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		return ResultData.from("S-1", Util.f("%d번 게시물입니다.", id), "article", article);
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public ResultData<List<Article>> getArticles() {

		return ResultData.from("S-1", "게시물리스트", "articles", articleService.getArticles()); 
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData<Article> doModify(HttpSession httpSession, int id, String title, String body) {
		
		if (httpSession.getAttribute("loginedMemberId") == null) {
			return ResultData.from("F-A", "로그인후 이용해주세요.");
		}
		
		Article article = articleService.getArticleById(id);
		
		if (article == null) {
			return ResultData.from("F-1", Util.f("%d번 게시물은 존재하지 않습니다.", id));
		}
		ResultData actorCanModifyRd = articleService.artorCanModify((int) httpSession.getAttribute("loginedMemberId"),article.getMemberId());	

		if (actorCanModifyRd.isFail()) {
			return ResultData.from(actorCanModifyRd.getResultCode(), actorCanModifyRd.getMsg());
		}
		
		return articleService.modifyArticle(id, title, body);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(HttpSession httpSession, int id) {
		
		if (httpSession.getAttribute("loginedMemberId") == null) {
			return ResultData.from("F-A", "로그인후 이용해주세요.");
		}
		
		Article article = articleService.getArticleById(id);

		if (article == null) {
			return ResultData.from("F-1", Util.f("%d번 게시물은 존재하지 않습니다.", id));
		}
		if ((int) httpSession.getAttribute("loginedMemberId") != article.getMemberId()) {
			return ResultData.from("F-B", "해당 게시물에 대한 삭제 권한이 없습니다.");
		}	

		return ResultData.from("S-1", Util.f("%d번 게시물을 삭제했습니다.", id));
	}
	
}
