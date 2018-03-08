package com.muyi.summer.stepbystep.beans.factory;

import com.muyi.summer.stepbystep.service.HelloService;
import com.muyi.summer.stepbystep.beans.io.ResourceLoader;
import com.muyi.summer.stepbystep.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

/**
 * @Author: muyi-corp
 * @Date: Created in 15:34 2018/1/31
 * @Description:
 */

public class BeanFactoryTest {


    @Test
    public void test() throws Exception{
        //1. 读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("bean-definition.xml");

        //2. 初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();

        xmlBeanDefinitionReader.getRegistry().forEach((name,beanDefinition)-> {
            try {
                beanFactory.registerBeanDefinition(name,beanDefinition);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        //3. 获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.helloText();
    }

    @Test
    public void testPreInstantiate() throws Exception{

        //1. 读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("bean-definition.xml");

        //2. 初始化beanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();
        xmlBeanDefinitionReader.getRegistry().forEach((name,beanDefinition)-> {
            try {
                beanFactory.registerBeanDefinition(name,beanDefinition);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        //3. 初始化bean
        AbstractBeanFactory abstractBeanFactory = (AbstractBeanFactory)beanFactory;
        abstractBeanFactory.preInstantiateSingletons();

        //4. get bean
        HelloService helloService = (HelloService)beanFactory.getBean("helloService");
        helloService.helloWorld();

    }


}