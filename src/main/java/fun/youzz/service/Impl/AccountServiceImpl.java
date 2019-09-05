package fun.youzz.service.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.service.IAccountService;

/**
 * 账户的业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
