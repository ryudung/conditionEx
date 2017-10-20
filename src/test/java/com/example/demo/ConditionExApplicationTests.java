package com.example.demo;

import com.example.demo.condition.PhoneExistCondition;
import com.example.demo.config.IfConfig;
import com.example.demo.object.Book;
import com.example.demo.object.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {PhoneExistCondition.class, IfConfig.class})
@TestPropertySource(locations = {"classpath:../resources/common.properties"})
public class ConditionExApplicationTests {

	@Autowired
	Phone phone;

	@Autowired
	Book book;

	@Test
	public void contextLoads() {
		System.out.println("=======condition test result========");
		System.out.println(phone.getName());
		System.out.println("=======customAnnotation result======");
		System.out.println(book.getName());
		System.out.println("====================================");
	}
}
