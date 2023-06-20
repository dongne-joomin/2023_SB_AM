package com.koreaIT.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreaIT.demo.repository.ProductRepository;
import com.koreaIT.demo.vo.Article;
import com.koreaIT.demo.vo.FileVO;
import com.koreaIT.demo.vo.Product;
@Service
public class ProductService {
	@Value("${file.dir}")
	private String fileDir;
	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void saveFile(MultipartFile file, int memberId, int boardId, String title, String report, String price) throws IOException {
		
		if (file.isEmpty()) {
			return;
		}

		String orgName = file.getOriginalFilename();

		String uuid = UUID.randomUUID().toString();

		String extension = orgName.substring(orgName.lastIndexOf("."));

		String savedName = uuid + extension;

		String savedPath = fileDir + "/" + savedName;
		
		productRepository.insertFileInfo(memberId, boardId, title, report, orgName, savedName, savedPath, price);

		file.transferTo(new File(savedPath));
		
	}

	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

	public Product getProductyId(int fileId) {
		return productRepository.getProductyId(fileId);
	}

	public Product getForPrintProduct(int id) {
		return productRepository.getForPrintProduct(id);
	}


}
