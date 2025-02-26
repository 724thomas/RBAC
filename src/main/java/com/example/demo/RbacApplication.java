package com.example.demo;

import com.example.demo.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RbacApplication implements CommandLineRunner {

	@Autowired
	private SomeService someService;

	public static void main(String[] args) {
		SpringApplication.run(RbacApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 현재 사용자는 "USER" 역할만 가지고 있으므로 adminTask()는 예외 발생
		try {
			someService.adminTask();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// userTask()는 성공적으로 실행됩니다.
		someService.userTask();
	}

}
