package fun.youzz.ui;

import fun.youzz.dao.IAccountDao;
import fun.youzz.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    /**
     * ApplicationContext 的三个常用实现类
     *     ClassPathXmlApplicationContext 类路径下
     *     FileSystemXmlApplicationContext 绝对路径下
     *     AnnotationConfigApplicationContext 注解方式
     *
     * 核心容器的两个接口
     *     ApplicationContext ： 单例对象适用
     *         构建容器时，创建对象时采用的立即加载的方式，“饿汉式”
     *     BeanFactory ： 多例对象适用
     *         构建容器时, 创建对象时采用的延迟加载的方式，“懒汉式”
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获取核心容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据Id获取bean
//        IAccountService accountService = (IAccountService) ac.getBean("accountService");
//        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(accountService);
//        System.out.println(accountDao);

        // BeanFactory
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService accountService = (IAccountService) factory.getBean("accountService");
        System.out.println(accountService);
    }
}
