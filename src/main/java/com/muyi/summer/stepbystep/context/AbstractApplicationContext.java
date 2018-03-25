package com.muyi.summer.stepbystep.context;

import com.muyi.summer.stepbystep.beans.BeanPostProcessor;
import com.muyi.summer.stepbystep.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @Author: muyi-corp
 * @Date: Created in 23:34 2018/2/4
 * @Description:
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) throws Exception{
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
        this.loadBeanDefinitions(this.beanFactory);
        this.registerBeanPostProcessors(this.beanFactory);
        this.onRefresh();
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception{
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);

        for (Object beanPostProcessor : beanPostProcessors){
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected void onRefresh() throws Exception{
        this.beanFactory.preInstantiateSingletons();
    }


    @Override
    public Object getBean(String beanName) throws Exception {
        return this.beanFactory.getBean(beanName);
    }


}


