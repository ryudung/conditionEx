package com.example.demo.condition;

import com.example.demo.object.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.reflect.Field;

public class PhoneExistCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        /**
         * context:
         *      Enviromnet: 환경변수에 접근 가능.
         *      ResourceLoader: resource에 접근가능.
         *      BeanFactory: 빈 객체에 접근 가능.
         *      ClassLoader: class 접근가능.
         * */
        ClassLoader classLoader = context.getClassLoader();
        ResourceLoader resourceLoader = context.getResourceLoader();
        BeanFactory beanFactory = context.getBeanFactory();
        Environment env = context.getEnvironment();

        Person person = (Person) beanFactory.getBean("personBean");
        System.out.println("--------------PhoneExistCondition--------------");
        System.out.println(person.getName());
        System.out.println(resourceLoader.getResource("classpath:../resources/common.properties").exists());

        try {

            Class phoneClass = classLoader.loadClass("com.example.demo.object.Phone");
            Field field = phoneClass.getDeclaredField("name");
            field.setAccessible(true);
            System.out.println(field.get(phoneClass.newInstance()));

        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------");
        return Boolean.parseBoolean(env.getProperty("phone.enable"));
    }
}
