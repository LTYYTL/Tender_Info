package com.liu.tender_info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.liu.tender_info.mapper")
@SpringBootApplication
public class TenderInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenderInfoApplication.class, args);
	}

}
