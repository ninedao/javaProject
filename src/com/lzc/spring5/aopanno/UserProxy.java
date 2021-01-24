package com.lzc.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
    //前置通知
    @Before("execution(* com.lzc.spring5.aopanno.User.add(..))")
    public void add(){
        System.out.println("before.....");
    }
}
