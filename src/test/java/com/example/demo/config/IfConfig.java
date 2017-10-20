package com.example.demo.config;

import com.example.demo.condition.CustomAnnotation;
import com.example.demo.condition.PhoneExistCondition;
import com.example.demo.object.Book;
import com.example.demo.object.Person;
import com.example.demo.object.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class IfConfig {

    @Bean(name = "personBean")//먼저 선언되어야 한다.
    Person personBean() {
        return new Person();
    }

    @Bean
    @Conditional(PhoneExistCondition.class)
    Phone phoneBean() {
        return new Phone();
    }

    @Bean
    @CustomAnnotation(isEnable = true, value = {"a", "b", "c"}, name = "dev")
    Book BookDevBean() {
        return new Book("dev 책");
    }

    @Bean
    @CustomAnnotation(value = {"d", "e", "f"}, name = "prod")
    Book BookProdBean() {
        return new Book("prod 책");
    }

}
