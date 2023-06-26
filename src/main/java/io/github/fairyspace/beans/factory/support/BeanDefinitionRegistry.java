package io.github.fairyspace.beans.factory.support;

import io.github.fairyspace.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
