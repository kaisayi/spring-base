package fun.youzz.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        final Producer producer = new Producer();
//        producer.saleProduct(1000f);

        /**
         * 动态代理
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上，对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *   1.基于接口的动态代理：
         *        涉及的类：Proxy
         *        提供者：JDK官方
         *     如何创建代理对象：
         *        使用Proxy类中的newProxyInstance方法
         *     创建对象的要求：
         *        被代理对象最少实现一个接口，如果没有则不能使用
         *     newProxyInstance 方法的参数
         *     ClassLoader 类加载器
         *        它是用于加载代理对象字节码的，和被代理对象使用相同的类加载器
         *     Class[] ：字节码数组
         *        它是用于让代理对象和被代理对象有相同的方法
         *     InvocationHandler: 用于提供增强的代码
         *        它是让我们如何代理，一般都是该接口的实现类，通常情况下是匿名内部类，但不是必须的
         *
         *   2. 基于子类的动态代理
         *       涉及的类：Enhancer
         *       提供者：第三方的cglib
         *     如何创建代理对象：
         *       使用Enhancer类中的create方法
         *     创建对象的要求：
         *       被代理对象不能是最终类
         *     create 方法的参数：
         *       Class字节码： 被代理对象的字节码
         *       Callback: 用于增强的代码
         */
//        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
//                producer.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    /**
//                     * 作用：执行被代理对象的任何接口方法都会经过该方法
//                     * @param proxy 代理对象的引用
//                     * @param method 当前执行方法
//                     * @param args 当前执行方法所需的参数
//                     * @return 和被代理对象有相同的返回值
//                     * @throws Throwable
//                     */
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        // 提供增强的代码
//                        Object returnValue = null;
//                        // 1. 获取方法执行的参数
//                        Float money = (Float) args[0];
//                        // 2. 判断当前方法是不是销售
//                        if ("saleProduct".equals(method.getName())) {
//                            returnValue = method.invoke(producer, money * 0.8f);
//                        }
//                        // 3. 获取方法执行的参数
//                        return returnValue;
//                    }
//                });

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o  代理对象的引用
             * @param method
             * @param args
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                // 1. 获取方法执行的参数
                Float money = (Float) args[0];
                // 2. 判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                // 3. 获取方法执行的参数
                return returnValue;
            }
        });

        cglibProducer.saleProduct(10000f);

    }

}
