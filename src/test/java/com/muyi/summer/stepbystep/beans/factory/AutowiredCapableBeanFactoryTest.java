package com.muyi.summer.stepbystep.beans.factory;

import com.muyi.summer.stepbystep.beans.BeanDefinition;
import com.muyi.summer.stepbystep.beans.BeanProperties;
import com.muyi.summer.stepbystep.service.HelloService;
import com.muyi.summer.stepbystep.beans.PropertyValue;
import org.junit.Test;

/**
 * @Author: muyi-corp
 * @Date: Created in 20:11 2018/1/30
 * @Description:
 */
public class AutowiredCapableBeanFactoryTest {

//    @Test
//    public void test1(){
//
//        //1. initialize beanFactory
//        BeanFactory beanFactory = new AutowiredCapableBeanFactory();
//
//        //2. set bean
//        BeanDefinition beanDefinition = new BeanDefinition();
//        beanDefinition.setBeanClassName("com.muyi.summer.stepbystep.service.HelloService");
//        beanFactory.registerBeanDefinition("helloService", beanDefinition);
//
//        //3. get bean
//        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
//        helloService.helloWorld();
//
//    }

    /**
     * 通过反射动态改变对象属性
     */
    @Test
    public void test2() throws Exception{

        //1. 初始化beanFactory
        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();

        //2. bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.muyi.summer.stepbystep.service.HelloService");

        //3. 设置属性
        BeanProperties beanProperties = new BeanProperties();
        beanProperties.addProperty(new PropertyValue("text","Hello Text!"));
        beanDefinition.setBeanProperties(beanProperties);

        //4. 生成bean
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        //5. 获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.helloText();

    }


}