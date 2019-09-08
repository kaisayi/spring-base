package fun.youzz.factory;

import fun.youzz.domain.Account;
import fun.youzz.service.IAccountService;
import fun.youzz.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public IAccountService getAccountService(){
        IAccountService proxyInstance = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try {
                            // 1. 开启事务
                            txManager.beginTranssaction();
                            // 2. 执行操作
                            returnValue = method.invoke(accountService, args);
                            // 3. 提交事务
                            txManager.commit();
                            // 4. 返回结果
                            return returnValue;
                        } catch (Exception e) {
                            // 5. 回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            // 6. 释放连接
                            txManager.release();
                        }
                    }
                });
        return proxyInstance;
    }
}
