package com.lzc.coreJava.stackTrace;

import java.util.logging.Logger;

/**
 * Created by POPO LIU on 2020-06-11.
 */
public class StackTraceTest {
    private static Logger logger = null;
    public  int factorial(int n){
        logger.entering("com.lzc.coreJava.stackTrace.StackTraceTest","factorial",new Object[]{n,n});
        assert n >0 : "n小于0";
        System.out.println("factorial(" + n + ")");
        Throwable t = new Throwable();
        for(StackTraceElement element : t.getStackTrace()){
            System.out.println(element.getFileName());
            System.out.println(element);
        }
        int r;
        if(n == 1){
            r = 1;
        }else{
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        logger.exiting("com.lzc.coreJava.stackTrace.StackTraceTest","factorial",r);
        return r;
    }
//    static{
//        System.setProperty("java.util.logging.config.file","logging.properties");
//    }

    public static void main(String[] args){


// 设置过滤打印日志的级别（根据个人情况定）
        ///logger.logp(Level.FINE, "com.lzc.coreJava.stackTrace.StackTraceTest1", "main","test");
        ///logger.setLevel(Level.FINE);

        System.setProperty("java.util.logging.config.file", "src/com/lzc/source/properties/logging.properties");
        System.out.println(System.getProperty("java.util.logging.config.file"));
        logger = Logger.getLogger("StackTraceTest");
        Exception e = new Exception("test");
        logger.throwing(" com.lzc.coreJava.stackTrace","main",e);
        logger.fine("111");
        StackTraceTest s = new StackTraceTest();
        s.factorial(3);

    }

}
