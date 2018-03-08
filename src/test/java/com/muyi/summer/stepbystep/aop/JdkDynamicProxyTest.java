package com.muyi.summer.stepbystep.aop;

import com.muyi.summer.stepbystep.context.ApplicationContext;
import com.muyi.summer.stepbystep.context.ClassPathXmlApplicationContext;
import com.muyi.summer.stepbystep.service.HelloService;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/5 下午8:03
 * @Description:
 */
public class JdkDynamicProxyTest {

    @Test
    public void testInterceptor() throws Exception{

        // helloService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-definition.xml");
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        helloService.helloText();

        // helloService with AOP
        // 1.设置被代理对象(JoinPoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloService, HelloService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2.设置拦截器(advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3.创建代理(proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloService helloServiceProxy = (HelloService)jdkDynamicAopProxy.getProxy();

        // 4.通过代理调用
        helloServiceProxy.helloText();

    }


}
