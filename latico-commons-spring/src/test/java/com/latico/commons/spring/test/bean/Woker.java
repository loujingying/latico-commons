package com.latico.commons.spring.test.bean;

import com.latico.commons.spring.test.Study;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @author: latico
 * @date: 2019-01-01 17:26
 * @version: 1.0
 */
public class Woker implements Study {
    @Override
    public String doSomeThing(String someThing) {
        return hashCode() + "工人学习com.latico.commons.spring.bean.Woker:" + someThing;
    }
}
