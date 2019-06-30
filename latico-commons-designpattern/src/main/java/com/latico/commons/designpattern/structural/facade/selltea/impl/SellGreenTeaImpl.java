package com.latico.commons.designpattern.structural.facade.selltea.impl;

import com.latico.commons.designpattern.structural.facade.selltea.SellTea;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @Author: LanDingDong
 * @Date: 2019-01-14 23:51
 * @Version: 1.0
 */
public class SellGreenTeaImpl implements SellTea {
    @Override
    public void sellTea() {
        System.out.println("卖的这是一杯绿茶");
    }
}
