package io.github.fairyspace.beans.factory.support;

import io.github.fairyspace.beans.factory.config.BeanDefinition;
import io.github.fairyspace.beans.factory.config.BeanPostProcessor;
import io.github.fairyspace.beans.factory.config.ConfigurableBeanFactory;
import io.github.fairyspace.beans.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements ConfigurableBeanFactory {
    /**
     * ClassLoader to resolve bean class names with, if necessary
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name)  {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name,Object... args) {
       return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition,Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String name);


    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

}
