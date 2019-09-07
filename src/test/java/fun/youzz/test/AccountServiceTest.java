package fun.youzz.test;

import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试；测试配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {
        // 执行方法
        List<Account> accounts = as.findAllAccount();
        accounts.forEach(System.out::println);
    }

    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 100f);
    }
}
