package com.muyi.summer.stepbystep.beans.factory;

import com.muyi.summer.stepbystep.beans.BeanDefinition;

/**
 * @Author: muyi-corp
 * @Date: Created in 19:12 2018/1/30
 * @Description:
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

    //void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
