package common;

import bean.UserService;
import io.github.fairyspace.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.err.println("bean 初始化之前"+beanName);
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.err.println("bean 初始化之后"+beanName);
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setCompany("改为：gagagag");
        }
        return bean;
    }
}
