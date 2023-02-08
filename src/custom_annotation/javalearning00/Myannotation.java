package custom_annotation.javalearning00;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//元注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Myannotation {
/*
定义属性格式：返回值 属性名()[默认值Default]
*/
        String name() default "jls";
        int age() default 21;
}
