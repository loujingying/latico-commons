package com.latico.commons.common.util.thread;

import org.junit.Test;

/**
 * @author: latico
 * @date: 2018/12/08 23:37
 * @version: 1.0
 */
public class ThreadUtilsTest {

    @Test
    public void getTotalSize() {
        System.out.println(ThreadUtils.getMainThreadGroupActiveThreadCount());
        System.out.println(ThreadUtils.getSystemThreadGroupActiveThreadCount());
    }

    @Test
    public void sleep() {
    }

    @Test
    public void tWait() {
    }

    @Test
    public void tNotify() {
    }
}