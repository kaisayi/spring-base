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
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据Id获取bean
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        System.out.println(accountService);
//
//        IAccountDao dao = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(dao);
    }
}
