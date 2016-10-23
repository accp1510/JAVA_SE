package javaapp15;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//аннотация будет применятся к методам или классам
@Target({ElementType.METHOD, ElementType.TYPE})
//аннотация будет доступна во вромя выполнения приложения
@Retention(RetentionPolicy.RUNTIME)
//описание собственной аннотации
public @interface MethInfo {
    //атрибуты, которые будет принимать аннотация
    String name() default "Ваня";

    String date();

    int version() default 56;

}
