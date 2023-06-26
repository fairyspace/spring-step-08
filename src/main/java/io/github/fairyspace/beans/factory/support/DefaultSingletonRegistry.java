package io.github.fairyspace.beans.factory.support;

import io.github.fairyspace.beans.factory.DisposableBean;
import io.github.fairyspace.beans.factory.config.SingletonRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonRegistry implements SingletonRegistry {
    private Map<String,Object> singletonObjects=new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();
    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    @Override
    public void addSingleton(String name, Object singletonObject){
        singletonObjects.put(name, singletonObject);
    }
    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        ArrayList<String> beanNames = new ArrayList<>(disposableBeans.keySet());
        for (String beanName : beanNames) {
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new RuntimeException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
