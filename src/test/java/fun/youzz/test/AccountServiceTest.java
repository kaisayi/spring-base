package fun.youzz.test;

import fun.youzz.config.SpringConfiguration;
import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试；测试配置
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        // 获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 得到业务层对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        // 执行方法
        List<Account> accounts = service.findAllAccount();
        accounts.forEach(System.out::println);
    }


    @Test
    public void testFindOne() {
        // 获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 得到业务层对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        // 执行方法
        Account account = service.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        // 获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 得到业务层对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        // 执行方法
        Account account = new Account();
        account.setName("youzz23");
        account.setMoney(1230.3f);
        service.saveAccount(account);
    }
}
