package com.example.demo.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Conditional(CustomCondition.class)
public @interface CustomAnnotation {
    boolean isEnable() default false;
    String[] value() default {};
    String name() default "";
}
