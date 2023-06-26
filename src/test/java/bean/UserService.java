package bean;

import io.github.fairyspace.beans.BeanFactory;
import io.github.fairyspace.beans.factory.BeanClassLoaderAware;
import io.github.fairyspace.beans.factory.BeanFactoryAware;
import io.github.fairyspace.beans.factory.BeanNameAware;
import io.github.fairyspace.context.ApplicationContext;
import io.github.fairyspace.context.ApplicationContextAware;

public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId)+"company="+company+"location="+location;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("set Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("set ClassLoader：" + classLoader);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
