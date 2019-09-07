package fun.youzz.service.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * 账户的业务层
 *  <bean id="accountService" class="fun.youzz.service.Impl.AccountServiceImpl"></bean>
 *
 * 用于创建对象的
 *      作用和在xml配置文件中编写一个<bean><bean/>一样
 * @Component
 *  作用：把当前对象存入spring容器
 *  属性：value 指定bean的id， 不写时，默认当前类名的首字母改小写
 *
 * @Controller ： 表现层
 * @Service ： 业务层
 * @Repository ： 持久层
 * 以上三个注解的作用和属性与Component一样
 * 这三个注解是spring框架为我们提供明确的三层使用的注解，使三层对象更为清晰
 *
 * 用于注入数据的
 *      作用和在xml配置文件中的bean标签内写一个<property><property/>一样
 * @Autowired
 *   作用：
 *      自动按照类型注入，只有容器中有唯一的一个bean对象类型和要注入的变量类型一致，就可以注入成功
 *      如果Ioc容器中有多个类型对象, 需要指定名称或者配合 Qualifier 使用
 *   出现位置：可以是变量上，也可以是方法上
 *   细节：在使用注解时，set方法就不是必须的
 *
 * @Qualifier:
 *    作用： 在按照类型注入的基础上再按照名称注入，在给类成员注入时不能单独使用
 *    属性： value： 指定注入bean的id
 * @Resource：
 *     作用：直接按照bean的id注入，可以单独使用
 *     属性： name：指定注入bean的id
 *
 * 以上三种注解 只能注入其他bean类型的数据, 而基本类型和String类型无法使用上述注解
 * 另外，集合类型的注入只能通过xml实现
 *
 * @Value:
 *     作用：用于注入基本类型和String类型
 *     属性：value 用于指定数据的值，可以使用spring中的SpEL：${表达式}
 *
 * 用于改变作用范围
 *      作用集合在bean标签中的scope属性功能一样
 * @Scope
 *      作用：指定bean的作用范围
 *      属性： value => singleton, prototype
 *
 *  生命周期相关
 *      作用和在bean标签内使用的init-method & destroy-method 一样
 * @PreDestroy
 *      作用：指定销毁方法
 * @PostConstruct
 *      作用：指定初始化方法
 *
 */
@Component("accountService")
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    private IAccountDao accountDao2;

//    @Autowired
//    @Qualifier("accountDao2")
//    private IAccountDao accountDao;

    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    public void saveAccount() {
//        accountDao2.saveAccount();
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行");
    }

}
