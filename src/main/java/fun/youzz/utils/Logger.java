package fun.youzz.utils;

/**
 * 记录日志的工具类，提供了公共的代码
 */
public class Logger {

    /**
     * 计划在切入点方法执行之前执行；切入点方法：业务层方法
     */
    public void printLog() {
        System.out.println("printLog 开始记录日志");
    }
}
