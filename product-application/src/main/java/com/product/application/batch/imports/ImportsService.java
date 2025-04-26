package com.product.application.batch.imports;

import org.springframework.web.multipart.MultipartFile;

public interface ImportsService {

	public Boolean importExcelData(MultipartFile excelFile, String tableName);

}
