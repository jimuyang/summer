package com.muyi.summer.stepbystep.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/5 下午7:54
 * @Description:
 */
public class TimerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long time = System.nanoTime();

        System.out.println("Invocation of method " + methodInvocation.getMethod().getName() + " start!");
        Object proceed = methodInvocation.proceed();
        System.out.println("Invocation of method " + methodInvocation.getMethod().getName() + " takes " + (System.nanoTime() - time) + " nanoseconds");
        System.out.println("Invocation of method " + methodInvocation.getMethod().getName() + " end!");

        return proceed;
    }
}
