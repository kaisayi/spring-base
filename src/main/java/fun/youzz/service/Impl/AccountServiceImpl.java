package fun.youzz.service.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.service.IAccountService;
import org.springframework.stereotype.Component;

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
 *
 *
 * 用于注入数据的
 *      作用和在xml配置文件中的bean标签内写一个<property><property/>一样
 * 用于改变作用范围
 *      作用集合在bean标签中的scope属性功能一样
 *  生命周期相关
 *      作用和在bean标签内使用的init-method & destroy-method 一样
 *
 */
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void saveAccount() {
        System.out.println("saveAccount 方法执行 /// ");
    }
}
