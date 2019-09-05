package fun.youzz.service.Impl;

import fun.youzz.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层
 */
public class AccountServiceImpl2 implements IAccountService {

    // 如果经常变化的数据，并不适用于注入的方式。
    private String name;
    private Integer age;
    private Date birtyday;



    public void saveAccount() {
        System.out.println("saveAccount 方法执行 /// " + name + " " + age + " " + birtyday);
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirtyday() {
        return birtyday;
    }

    public void setBirtyday(Date birtyday) {
        this.birtyday = birtyday;
    }
}
