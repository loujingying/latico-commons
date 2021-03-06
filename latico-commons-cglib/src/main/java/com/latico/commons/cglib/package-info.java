/**
 * <PRE>
 CGLIB代理主要通过对字节码的操作，为对象引入间接级别，以控制对象的访问。
 我们知道Java中有一个动态代理也是做这个事情的，那我们为什么不直接使用Java动态代理，而要使用CGLIB呢？
 答案是CGLIB相比于JDK动态代理更加强大，JDK动态代理虽然简单易用，但是其有一个致命缺陷是，
 只能对接口进行代理。如果要代理的类为一个普通类、没有接口，那么Java动态代理就没法使用了。
 * </PRE>
 *
 * @author: latico
 * @date: 2019-07-12 0:52
 * @version: 1.0
 */
package com.latico.commons.cglib;