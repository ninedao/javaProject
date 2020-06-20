package com.lzc.coreJava.stackTrace;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.logging.*;

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
        System.out.println(System.getProperty("java.util.logging.config.class"));
        logger = Logger.getLogger("StackTraceTest","com.lzc.coreJava.stackTrace.logmessages_cn");
        Handler handler = null;
        Handler handler1 = new ConsoleHandler();
        System.setProperty("user.home","src/com/lzc/coreJava/stackTrace");
        try {
            handler = new FileHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.setUseParentHandlers(false);
        handler1.setFormatter(new java.util.logging.XMLFormatter());
        handler.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                if(record.getMessage().startsWith("test")) {
                    return false;
                }else{
                    return true;
                }
            }
        });
//        handler.setFormatter(new Formatter() {
//            @Override
//            public String format(LogRecord record) {
//                return "[" + GregorianCalendar.getInstance().getTime() + "]" + "[" + record.getSourceClassName() + "." + record.getSourceMethodName() + "]" + ":" + record.getMessage() + "\n";
//            }
//        });
        //handler.setLevel(Level.INFO);
        logger.addHandler(handler);
        logger.log(Level.INFO,"test",new Object[]{"is","good"});
        Exception e = new Exception("test");
        logger.throwing(" com.lzc.coreJava.stackTrace","main",e);
        logger.fine("111");
        StackTraceTest s = new StackTraceTest();
        s.factorial(3);

    }

}
