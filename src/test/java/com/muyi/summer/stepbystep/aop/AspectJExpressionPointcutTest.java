package com.muyi.summer.stepbystep.aop;

import com.muyi.summer.stepbystep.service.HelloService;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/5 下午7:22
 * @Description:
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception{
        String expression = "execution(* com.muyi.summer.stepbystep.service.*.*(..))";

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);

        boolean isMatch = pointcut.getClassFilter().matches(HelloService.class);
        Assert.assertTrue(isMatch);
    }

    @Test
    public void testMethodInterceptor() throws Exception{
        String expression = "execution(* com.muyi.summer.stepbystep.service.*.*(..))";

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);

        Method method = HelloService.class.getDeclaredMethod("helloWorld");
        boolean isMatch = pointcut.getMethodMatcher().matches(method, HelloService.class);
        Assert.assertTrue(isMatch);
    }

}
