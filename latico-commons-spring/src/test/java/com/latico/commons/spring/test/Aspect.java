package com.latico.commons.spring.test;

import org.aspectj.lang.JoinPoint;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @author: latico
 * @date: 2019-01-01 21:35
 * @version: 1.0
 */
public class Aspect {


    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("before:" + joinPoint);
    }

    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("after:" + joinPoint);
    }
}
