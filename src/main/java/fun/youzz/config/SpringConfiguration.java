package fun.youzz.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 是一个配置类，作用和bean.xml一样
 * spring中的新注解
 * @Configuration
 *    作用：表明当前类为一个配置类
 *    细节：当配置类作为AnnotationConfigurationContext对象创建的参数时，该注解可以不写
 *
 * @ComponentScan
 *    作用：用于通过注解指定spring创建容器时要创建的包
 *    属性：value
 *    等同于：<context:component-scan base-package="fun.youzz"></context:component-scan>
 *
 * @Bean
 *    作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器
 *    属性：
 *         name: 用于指定bean的id，默认为方法名
 *    细节：
 *        使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
 */

@Configuration
@ComponentScan(basePackages = "fun.youzz")
public class SpringConfiguration {


}
