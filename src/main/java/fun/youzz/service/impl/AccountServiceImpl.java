package fun.youzz.service.impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;

/**
 * 账户的业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("Transfer...");
        // 按名称查找账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        // 转账操作
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        // 保存
        accountDao.updateAccount(source);
        System.out.println(1 / 0);
        accountDao.updateAccount(target);
    }
}
