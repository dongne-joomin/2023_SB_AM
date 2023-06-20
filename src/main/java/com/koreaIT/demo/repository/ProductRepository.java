package com.koreaIT.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.demo.vo.FileVO;
import com.koreaIT.demo.vo.Product;

@Mapper
public interface ProductRepository {

	void insertFileInfo(int memberId, int boardId, String title, String report, String orgName, String savedName,
			String savedPath, String price);

	List<Product> getProducts();

	Product getProductyId(int fileId);

	Product getForPrintProduct(int id);


}
