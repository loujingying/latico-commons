package com.latico.commons.common.util.db.dao;

import com.latico.commons.common.util.compare.CompareBean2;
import com.latico.commons.common.util.string.StringUtils;

import java.sql.Connection;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @author: latico
 * @date: 2019-01-24 9:17
 * @version: 1.0
 */
public class BaseDaoImplExample2 extends BaseDao<CompareBean2> {

    @Override
    public String getCharset() {
        if (StringUtils.isBlank(this.charset)) {
            this.charset = "GBK";
        }
        return super.getCharset();
    }

    @Override
    protected Connection getConnection() {
        return null;
    }

}
