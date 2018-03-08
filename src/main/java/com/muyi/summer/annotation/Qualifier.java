package com.muyi.summer.annotation;

import java.lang.annotation.*;

/**
 * @Author: muyi-corp
 * @Date: Created in 18:20 2018/1/26
 * @Description:
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Qualifier {
    String value() default "";
}
