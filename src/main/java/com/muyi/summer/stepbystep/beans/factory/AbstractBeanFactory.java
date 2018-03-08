package com.muyi.summer.stepbystep.beans.factory;

import com.muyi.summer.stepbystep.beans.BeanDefinition;
import com.muyi.summer.stepbystep.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: muyi-corp
 * @Date: Created in 19:11 2018/1/30
 * @Description:
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    // beanPostProcessors
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    // lazy加载 beanName就是beanDefinitionName
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + beanName + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
            this.initializeBean(beanName, bean);
        }
        return bean;
    }

    // initialize bean
    protected void initializeBean(String beanName, Object bean) throws Exception {
        for (BeanPostProcessor beanPostProcessor : this.beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
        }

        // TODO: 2018/3/5 call initialize method

        for (BeanPostProcessor beanPostProcessor : this.beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, beanName);
        }

    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }


    // 注册bean的定义
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
//        Object bean = doCreateBean(beanDefinition);
//        beanDefinition.setBean(bean);
        this.beanDefinitionMap.put(name, beanDefinition);
        this.beanDefinitionNames.add(name);
    }

    // 提前初始化单例bean
    public void preInstantiateSingletons() throws Exception {
        for (Iterator iterator = this.beanDefinitionNames.iterator(); iterator.hasNext(); ) {
            String beanName = (String) iterator.next();
            this.getBean(beanName);
        }
    }

    // 创建bean
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = this.createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);

        this.applyBeanProperties(bean, beanDefinition);

        return bean;
    }

    protected void applyBeanProperties(Object bean, BeanDefinition beanDefinition) throws Exception {

    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    // 通过类型获得beans 没有就创建一个
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<Object>();

        for (String beanDefinitionName : this.beanDefinitionNames) {
            if (type.isAssignableFrom(this.beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(this.getBean(beanDefinitionName));
            }
        }

        return beans;
    }


}
