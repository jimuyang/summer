package com.muyi.summer.stepbystep.beans;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:19 2018/1/30
 * @Description: bean的内容及元数据 保存在beanFactory中 包装bean的实体
 */
public class BeanDefinition {

    private Object bean;
    private Class beanClass;
    private String beanClassName;
    private BeanProperties beanProperties;




    public BeanDefinition() {
        this.beanProperties = new BeanProperties();
    }

    public Object getBean() {
        return this.bean;
    }

    public void setBean(Object bean){
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BeanProperties getBeanProperties() {
        return beanProperties;
    }

    public void setBeanProperties(BeanProperties beanProperties) {
        this.beanProperties = beanProperties;
    }
}
