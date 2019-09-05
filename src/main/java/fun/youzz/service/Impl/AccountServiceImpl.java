package fun.youzz.service.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.service.IAccountService;

/**
 * 账户的业务层
 */
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl被创建了");
    }


    public void saveAccount() {
        System.out.println("saveAccount 方法执行");;
    }
}
