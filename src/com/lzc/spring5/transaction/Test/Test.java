package com.lzc.spring5.transaction.Test;

import com.lzc.spring5.transaction.config.TransactionConfig;
import com.lzc.spring5.transaction.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    @org.junit.Test
    public void testAccount1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
        AccountService accountService = applicationContext.getBean("accountServiceImpl",AccountService.class);
        accountService.changeForAccount();
    }
}
