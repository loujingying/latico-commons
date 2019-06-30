package com.latico.commons.designpattern.structural.decorator.decorator.impl;

import com.latico.commons.designpattern.structural.decorator.decorator.AbstractPersonBehaviorDecorator;
import com.latico.commons.designpattern.structural.decorator.personbehavior.PersonBehavior;

/**
 * <PRE>
 * 做头发行为修饰
 * </PRE>
 *
 * @Author: LanDingDong
 * @Date: 2019-01-14 22:40
 * @Version: 1.0
 */
public class DoHairPersonBehaviorDecoratorImpl extends AbstractPersonBehaviorDecorator {

    public DoHairPersonBehaviorDecoratorImpl() {
    }
    public DoHairPersonBehaviorDecoratorImpl(PersonBehavior personBehavior) {
        this.personBehavior = personBehavior;
    }
    @Override
    public void toDate() {
        System.out.println(getType() + "做个头发");
        super.toDate();
    }
}
