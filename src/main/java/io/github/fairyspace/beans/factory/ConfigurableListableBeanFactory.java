package io.github.fairyspace.beans.factory;

import io.github.fairyspace.beans.factory.config.AutowireCapableBeanFactory;
import io.github.fairyspace.beans.factory.config.BeanDefinition;
import io.github.fairyspace.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 提前实例化所有单例实例
     *
     */
    void preInstantiateSingletons();

}
