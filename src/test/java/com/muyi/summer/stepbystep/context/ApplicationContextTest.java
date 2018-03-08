package com.muyi.summer.stepbystep.context;

import com.muyi.summer.stepbystep.service.HelloService;
import com.muyi.summer.stepbystep.service.impl.OutputServiceImpl;
import org.junit.Test;

/**
 * @Author: muyi-corp
 * @Date: Created in 23:59 2018/2/4
 * @Description:
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-definition.xml");
        HelloService helloService  = (HelloService) applicationContext.getBean("helloService");
        helloService.helloText();

//        OutputServiceImpl outputService = (OutputServiceImpl) applicationContext.getBean("outputService");
//        outputService.testHello();
    }

}