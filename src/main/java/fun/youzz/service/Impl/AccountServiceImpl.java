package fun.youzz.service.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层
 * <bean id="accountService" class="fun.youzz.service.Impl.AccountServiceImpl"></bean>
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
}
