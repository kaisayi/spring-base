package fun.youzz.test;

import fun.youzz.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试aop配置
 */
public class AOPTest {

    public static void main(String[] args) {
        // 获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据Id获取bean
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        // 执行方法
        accountService.saveAccount();
    }


}
