package com.koreaIT.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.MemberService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Member;
import com.koreaIT.demo.vo.ResultData;
import com.koreaIT.demo.vo.Rq;

@Controller
public class UsrMemberController {

	private MemberService memberService;
	private Rq rq;

	@Autowired
	public UsrMemberController(MemberService memberService, Rq rq) {
		this.memberService = memberService;
		this.rq = rq;
	}

	// 액션 메서드
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData<Member> doJoin(String loginId, String loginPw, String name,
			String nickname, String cellphoneNum, String email) {

		if (rq.getLoginedMemberId() != 0) {
			return ResultData.from("F-A", "로그아웃 후 이용해주세요");
		}

		if (Util.empty(loginId)) {
			return ResultData.from("F-1", "아이디를 입력해주세요");
		}
		if (Util.empty(loginPw)) {
			return ResultData.from("F-2", "비밀번호를 입력해주세요");
		}
		if (Util.empty(name)) {
			return ResultData.from("F-3", "이름을 입력해주세요");
		}
		if (Util.empty(nickname)) {
			return ResultData.from("F-4", "닉네임을 입력해주세요");
		}
		if (Util.empty(cellphoneNum)) {
			return ResultData.from("F-5", "전화번호를 입력해주세요");
		}
		if (Util.empty(email)) {
			return ResultData.from("F-6", "이메일을 입력해주세요");
		}

		ResultData<Integer> doJoinRd = memberService.doJoin(loginId, loginPw, name, nickname, cellphoneNum, email);

		if (doJoinRd.isFail()) {
			return ResultData.from(doJoinRd.getResultCode(), doJoinRd.getMsg());
		}

		return ResultData.from(doJoinRd.getResultCode(), doJoinRd.getMsg(), "member",
				memberService.getMemberById((int) doJoinRd.getData1()));
	}

	@RequestMapping("/usr/member/login")
	public String login() {
		return "usr/member/login";
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(String loginId, String loginPw) {

		if (rq.getLoginedMemberId() != 0) {
			return Util.jsHistoryBack("로그아웃 후 이용해주세요");
		}

		if (Util.empty(loginId)) {
			return Util.jsHistoryBack("아이디를 입력해주세요");
		}
		if (Util.empty(loginPw)) {
			return Util.jsHistoryBack("비밀번호를 입력해주세요");
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return Util.jsHistoryBack(Util.f("%s은(는) 존재하지 않는 아이디입니다", loginId));
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Util.jsHistoryBack("비밀번호가 일치하지 않습니다");
		}

		rq.login(member);

		return Util.jsReplace(Util.f("%s 회원님 환영합니다~!", member.getNickname()), "/");
	}
	
	@RequestMapping("/usr/member/myPage")
	public String showMyPage() {
		return "usr/member/myPage";
	}
	@RequestMapping("/usr/member/checkPassword")
	public String checkPassword() {
		return "usr/member/checkPassword";
	}
	
	@RequestMapping("/usr/member/doCheckPassword")
	public String doCheckPassword(String loginPw) {

		if (Util.empty(loginPw)) {
			return rq.jsReturnOnView("비밀번호를 입력해주세요", true);
		}

		if (rq.getLoginedMember().getLoginPw().equals(loginPw) == false) {
			return rq.jsReturnOnView("비밀번호가 일치하지 않습니다", true);
		}

		return "usr/member/modify";
	}
	@RequestMapping("/usr/member/doModify")
	@ResponseBody
	public String doModify(String nickname, String cellphoneNum, String email) {

		if (Util.empty(nickname)) {
			return Util.jsHistoryBack("닉네임을 입력해주세요");
		}

		if (Util.empty(cellphoneNum)) {
			return Util.jsHistoryBack("전화번호를 입력해주세요");
		}

		if (Util.empty(email)) {
			return Util.jsHistoryBack("이메일을 입력해주세요");
		}

		memberService.doModify(rq.getLoginedMemberId(), nickname, cellphoneNum, email);

		return Util.jsReplace("회원정보가 수정되었습니다", "myPage");
	}
	
	
	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public String doLogout() {

		rq.logout();

		return Util.jsReplace("정상적으로 로그아웃 되었습니다", "/");
	}

}
