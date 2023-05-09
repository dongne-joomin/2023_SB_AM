package com.koreaIT.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.demo.repository.ReplyeRepository;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.ResultData;
@Service
public class ReplyeService {

	private ReplyeRepository replyeRepository;
	
	@Autowired
	public ReplyeService(ReplyeRepository replyeRepository) {
		this.replyeRepository = replyeRepository;
	}

	public ResultData<Integer> writeReply(int loginedMemberId, String relTypeCode, int relId, String body) {
		replyeRepository.writeReply(loginedMemberId, relTypeCode, relId, body);
		
		int id = replyeRepository.getLastInsertId();
		
		return ResultData.from("S-1", Util.f("%d번 댓글이 등록되었습니다.",id), "id", id);
	}


}
