package com.latico.commons.common.util.compare;

import com.latico.commons.common.util.compare.extendsmode.AbstractCompareObj;


/**
 * @author: latico
 * @date: 2018/12/05 16:00
 * @version: 1.0
 */
public class CompareBean0 extends AbstractCompareObj {
    private int id;
    private String name;
    private String nickName;
    private int age;
    private String sex;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompareBean{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", sex='").append(sex).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 比较时关联用的值，一般是一个列，但是要根据实际情况进行组拼
     *
     * @return
     */
    @Override
    public String getComapreRelatedKey() {
        return name + nickName;
    }

    /**
     * 默认为空
     */
    @Override
    public Object getAutoIncrementFieldValue() {
        return id;
    }
    @Override
    public void setAutoIncrementFieldValue(Object fieldValue) {
        if (fieldValue != null) {
            id = Integer.parseInt(fieldValue.toString());
        }
    }
    /**
     * 默认使用toString()方法后计算MD5
     */
    @Override
    public String getCompareRelatedValue() {
        return age + getSex();
    }
}
