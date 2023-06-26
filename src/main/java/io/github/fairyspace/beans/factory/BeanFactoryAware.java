package io.github.fairyspace.beans.factory;

import io.github.fairyspace.beans.BeanFactory;

public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory);
}
