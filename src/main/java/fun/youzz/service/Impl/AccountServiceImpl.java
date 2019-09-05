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
        System.out.println("saveAccount 方法执行");
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
