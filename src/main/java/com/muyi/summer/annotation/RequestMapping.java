package com.muyi.summer.annotation;

import java.lang.annotation.*;

/**
 * @Author: muyi-corp
 * @Date: Created in 18:23 2018/1/26
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";
}
