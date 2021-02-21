package guru.springframeword.sfgdi.services;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {


    public LifeCycleDemoBean() {//1
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void setBeanName(String name) {//2
        System.out.println("## My Bean Name is: " + name);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {//3
        System.out.println("## Bean Factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {//4
        System.out.println("## Application context has been set");
    }

    public void beforeInit(){//5
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    @PostConstruct
    public void postConstruct(){//6
        System.out.println("## The Post Construct annotated method has been called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {//7
        System.out.println("## The LifeCycleBean has its properties set!");

    }

    public void afterInit(){//8
        System.out.println("## - After init called by Bean Post Processor");
    }
    @PreDestroy
    public void preDestroy() {//9
        System.out.println("## The Predestroy annotated method has been called");
    }

    @Override
    public void destroy() throws Exception {//10
        System.out.println("## The Lifecycle bean has been terminated");

    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {//before ---> afterPropertiesSet or init mehtod
//        System.out.println("postProcessBeforeInitialization");
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {//after ---> afterPropertiesSet or init mehtod
//        System.out.println("postProcessAfterInitialization");
//        return bean;
//    }
}