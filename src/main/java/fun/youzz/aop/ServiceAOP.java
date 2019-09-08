package fun.youzz.aop;


import fun.youzz.utils.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceAOP {

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public Object methodProxyClient(ProceedingJoinPoint pjp) {
        try {
            // 1. 开启事务
            txManager.beginTranssaction();
            // 2. 执行操作
            System.out.println("执行操作");
            Object[] args = pjp.getArgs();
            Object rtValue = pjp.proceed(args);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return rtValue;
        } catch (Throwable throwable) {
            txManager.rollback();
            throw new RuntimeException(throwable);
        } finally {
            txManager.release();
        }
    }


}
