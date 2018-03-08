package com.muyi.summer.annotation;

import java.lang.annotation.*;

/**
 * @Author: muyi-corp
 * @Date: Created in 18:25 2018/1/26
 * @Description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value() default "";

}
