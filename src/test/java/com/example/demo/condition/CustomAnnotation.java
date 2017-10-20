package com.example.demo.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
//TYPE: Class, interface (including annotation type), or enum declaration
//FIELD: Field declaration (includes enum constants),
//METHOD: Method declaration,
//PARAMETER: Formal parameter declaration
//CONSTRUCTOR: Constructor declaration
//LOCAL_VARIABLE: Local variable declaration
//ANNOTATION_TYPE: Annotation type declaration,
//PACKAGE: Package declaration,
//TYPE_PARAMETER: Type parameter declaration, * @since 1.8
//TYPE_USE: Use of a type, @since 1.8
@Documented
@Conditional(CustomCondition.class)
public @interface CustomAnnotation

        {
    boolean isEnable() default false;
    String[] value() default {};
    String name() default "";
}
