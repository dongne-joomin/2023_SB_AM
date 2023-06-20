package com.koreaIT.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.koreaIT.demo.vo.FileVO;

@Mapper
public interface FileRepository {

	@Insert("""
			INSERT INTO file
				SET regDate = NOW(),
					title = #{title},
					report = #{report},
					originName = #{orgName},
					savedName = #{savedName},
					savedPath = #{savedPath},
					price = #{price}
			""")
	void insertFileInfo(String title, String report, String orgName, String savedName, String savedPath, String price);

	@Select("""
			SELECT *
				FROM file
				WHERE id = #{fileId}
			""")
	FileVO getFileById(int fileId);

	@Select("""
			SELECT *
				FROM file
			""")
	List<FileVO> getFiles();

}