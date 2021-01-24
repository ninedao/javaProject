package com.lzc.spring5;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        //
        UserDao userDao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(new UserDaoImpl()));
        System.out.println(userDao.add(1,1));
        userDao.update("lzc");
    }
}
class UserDaoProxy implements InvocationHandler{
    private Object userDao;

    public UserDaoProxy(Object userDao) {
        this.userDao = userDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前" + method.getName() + ":传递的参数。。。" + Arrays.toString(args));
        System.out.println(proxy.getClass().getSimpleName());
        System.out.println(userDao);
        Object res = method.invoke(userDao,args);
        System.out.println("方法之后输出。。。" + res);
        return res;
    }

}
