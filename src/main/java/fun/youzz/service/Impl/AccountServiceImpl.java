package fun.youzz.service.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;
import fun.youzz.utils.TransactionManager;

import java.util.Collections;
import java.util.List;

/**
 * 账户的业务层
 * <bean id="accountService" class="fun.youzz.service.Impl.AccountServiceImpl"></bean>
 * <p>
 * 事务控制：全都在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String source, String target, Float money) {
        System.out.println("transfer....");
        // 2.1. 根据名称查询转出账户
        Account sourceAc = accountDao.findAccountByName(source);
        // 2.2. 根据名称查询转入账户
        Account targetAc = accountDao.findAccountByName(target);
        // 2.3. 转出账户减钱
        sourceAc.setMoney(sourceAc.getMoney() - money);
        // 2.4. 转入账户加钱
        targetAc.setMoney(targetAc.getMoney() + money);
        // 2.5. 更新转出账户
        accountDao.updateAccount(sourceAc);

//        System.out.println(1 / 0);
        // 2.6. 更新转入账户
        accountDao.updateAccount(targetAc);
    }
}
