package fun.youzz.factory;

import fun.youzz.service.IAccountService;
import fun.youzz.service.Impl.AccountServiceImpl;

/**
 * 模拟一个工厂类，该类可能存在于jar包中，无法通过修改源码的方式来提供默认构造函数
 */
public class StaticFactory {

    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
