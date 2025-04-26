package com.product.application.batch.imports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/excel")
public class ImportsController {
	
	@Autowired
	private ImportsService importsService;
	
	
    @PostMapping(value ="/import")
	public ResponseEntity<?> importExcelData(@RequestParam String tableName, @RequestBody MultipartFile excelFile){
		
		System.out.println(tableName);
		System.out.print(excelFile.getName());
		
		Boolean statusUpdate=importsService.importExcelData(excelFile,tableName);
		
		return new ResponseEntity<>(excelFile.getName(),HttpStatus.ACCEPTED);
	}
	

}
