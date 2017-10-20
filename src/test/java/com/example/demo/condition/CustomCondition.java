package com.example.demo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;

public class CustomCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        /**
         *      metadata:
         *          getAllAnnotationAttributes():
         * */

        MultiValueMap<String, Object> attrs1 = metadata.getAllAnnotationAttributes(CustomAnnotation.class.getName());
        String name = (String) attrs1.getFirst("name");
        List list = attrs1.get("name");
        String[] array = (String[]) attrs1.getFirst("value");
        boolean isEnable = (boolean) attrs1.getFirst("isEnable");
        System.out.println("--------------CustomCondition--------------");
        System.out.println(name);
        list.stream().forEach(System.out::println);
        Arrays.asList(array).stream().forEach(System.out::println);
        System.out.println(isEnable);
        System.out.println("----------------------------");

        return isEnable;
    }
}
