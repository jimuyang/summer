package com.muyi.summer.stepbystep.beans;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:12 2018/1/31
 * @Description: 从配置中读取BeanDefinition
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
