package fun.youzz.test;

import fun.youzz.config.SpringConfiguration;
import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试；测试配置
 */
public class AccountServiceTest {

    private ApplicationContext ac;
    private IAccountService accountService;

    @Before
    public void init() {
        // 获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 得到业务层对象
        accountService = ac.getBean("accountService", IAccountService.class);
    }

    @Test
    public void testFindAll() {

        // 执行方法
        List<Account> accounts = accountService.findAllAccount();
        accounts.forEach(System.out::println);
    }


    @Test
    public void testFindOne() {
        // 执行方法
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        // 执行方法
        Account account = new Account();
        account.setName("youzz23");
        account.setMoney(1230.3f);
        accountService.saveAccount(account);
    }
}
