package com.latico.commons.spring.test;

import org.springframework.stereotype.Component;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @author: latico
 * @date: 2019-01-01 18:12
 * @version: 1.0
 */
@Component
public class Student implements Person {
    @Override
    public String doSomeThing(String someThing) {
        return hashCode() + "学生干活com.latico.commons.spring.Student：" + someThing;
    }
}
