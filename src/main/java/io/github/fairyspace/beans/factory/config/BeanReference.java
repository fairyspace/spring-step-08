package io.github.fairyspace.beans.factory.config;

public class BeanReference {
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
