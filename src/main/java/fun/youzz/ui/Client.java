package fun.youzz.ui;

import fun.youzz.dao.IAccountDao;
import fun.youzz.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        // 获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据Id获取bean
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);
    }
}
