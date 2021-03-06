package com.latico.commons.net.snmp;

import com.latico.commons.common.util.string.StringUtils;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @author: latico
 * @date: 2019-12-19 18:22:32
 * @version: 1.0
 */
public class SnmpUtils {

    /**
     * 是不是空的结果
     *
     * @param obj
     * @return
     */
    public static boolean isNullResult(Object obj) {
        if (obj == null) {
            return true;
        }

        String str = obj.toString();
        if ("".equals(str)) {
            return true;
        }

        if (str.indexOf("No Such") >= 0 || str.indexOf("noSuchInstance") >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 是不是空的结果
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return isNullResult(obj);
    }

    /**
     * 非空OID结果
     *
     * @param obj
     * @return
     */
    public static boolean isNotNullResult(Object obj) {
        return !isNullResult(obj);
    }

    public static boolean isNotNull(Object obj) {
        return !isNullResult(obj);
    }

    /**
     * 获取列号，table节点的OID组成结构：table节点OID.列号.行号
     *
     * @param oid    当前节点的OID，包括前缀.列号.行号
     * @param prefix 采集数据前的OID，也就是OID前缀，比如采集一个接口table节点的前缀是:.1.3.6.1.2.1.2.2，也就是table节点所有列OID的前缀
     * @return
     */
    public static String getColID(String oid, String prefix) {
        oid = formatterOid(oid);
        prefix = formatterOid(prefix);
        String left = oid.substring(prefix.length() + 1);
        int dot = left.indexOf(46);// 整数46对应的是字符英文点号，目的是为了去掉后面的行号等信息
        return dot > 0 ? left.substring(0, dot) : left;
    }

    /**
     * @param oid    一个OID
     * @param colId  列ID
     * @param prefix OID前缀
     * @return
     */
    public static String getRowID(String oid, String colId, String prefix) {
        oid = formatterOid(oid);
        prefix = formatterOid(prefix);
        prefix = StringUtils.join(prefix, ".", colId, ".");
        String left = oid.substring(prefix.length());
        return left;
    }

    /**
     * 格式化OID
     *
     * @param oid
     * @return
     */
    public static String formatterOid(String oid) {
        if (StringUtils.isNotEmpty(oid)) {
            if (!oid.startsWith(".")) {
                return "." + oid;
            }
        }
        return oid;
    }

    /**
     * 获取OID最后一个索引值,比如.1.3.6.1.2.1.2.2，得到2
     *
     * @param parentOid 父的OID
     * @param oid       当前的OID
     * @return
     */
    public static String getOidLastIndex(String parentOid, String oid) {
        if (parentOid.startsWith(".")) {
            parentOid = parentOid + ".";
        } else {
            parentOid = "." + parentOid + ".";
        }
        oid = formatterOid(oid);
        return oid.replace(parentOid, "");
    }

}
