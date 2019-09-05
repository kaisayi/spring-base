package fun.youzz.service.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层
 */
public class AccountServiceImpl implements IAccountService {

    // 如果经常变化的数据，并不适用于注入的方式。
    private String name;
    private Integer age;
    private Date birtyday;


//    public AccountServiceImpl() {
//        System.out.println("AccountServiceImpl被创建了");
//    }

    public AccountServiceImpl(String name, Integer age, Date birtyday) {
        this.name = name;
        this.age = age;
        this.birtyday = birtyday;
    }


    public void saveAccount() {
        System.out.println("saveAccount 方法执行 /// " + name + " " + age + " " + birtyday);
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
