package io.github.fairyspace.beans.factory.support;

import io.github.fairyspace.beans.core.io.Resource;
import io.github.fairyspace.beans.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource);

    void loadBeanDefinitions(Resource... resources);

    void loadBeanDefinitions(String location);
    void loadBeanDefinitions(String... locations);

}
