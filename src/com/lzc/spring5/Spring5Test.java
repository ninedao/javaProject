package com.lzc.spring5;
import com.lzc.spring5.aopanno.User;
import common.constant;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5Test {
    @Test
    public void testAOPAnno(){
        System.out.println(System.getProperty("user.dir"));
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(constant.OUTURL.getValue()+"spring5/aopanno/bean1.xml");
        User user = applicationContext.getBean("user", User.class);
        user.add();
    }
}
