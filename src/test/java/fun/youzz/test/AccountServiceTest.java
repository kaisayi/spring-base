package fun.youzz.test;

import fun.youzz.config.SpringConfiguration;
import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试；测试配置
 *
 * Spring 集合 junit的配置
 *     1. 导入spring整合Junit的坐标
 *     2. 使用junit提供的一个注解把原来的main方法替换掉，替换成spring框架提供的
 * @Runwith
 *     3. 告知spring的运行器，spring的ioc创建是基于xml还是注解的，并说明位置
 * @ContextConfiguration
 *    locations: 指定xml，加上classpath
 *    classes：指定注解类的位置
 *
 * 使用 spring5.x 版本时，要求junit的jar必须是4.12以上
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

//    @Before
//    public void init() {
//        // 获取容器
////        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        // 得到业务层对象
//        accountService = ac.getBean("accountService", IAccountService.class);
//    }

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
