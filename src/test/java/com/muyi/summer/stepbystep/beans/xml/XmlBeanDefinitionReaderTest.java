package com.muyi.summer.stepbystep.beans.xml;

import com.muyi.summer.stepbystep.beans.BeanDefinition;
import com.muyi.summer.stepbystep.beans.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * @Author: muyi-corp
 * @Date: Created in 15:07 2018/1/31
 * @Description:
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void loadBeanDefinitions() throws Exception {

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());

        xmlBeanDefinitionReader.loadBeanDefinitions("bean-definition.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();

        registry.forEach(
                (s, beanDefinition) -> System.out.println(s + ", " + beanDefinition.getBeanClassName()));
    }
}