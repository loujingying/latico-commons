/**
 * <PRE>
 *
 Java解析、生成Excel比较有名的框架有Apache poi、jxl。但他们都存在一个严重的问题就是非常的耗内存，poi有一套SAX模式的API可以一定程度的解决一些内存溢出的问题，但POI还是有一些缺陷，比如07版Excel解压缩以及解压后存储都是在内存中完成的，内存消耗依然很大。easyexcel重写了poi对07版Excel的解析，能够原本一个3M的excel用POI sax依然需要100M左右内存降低到KB级别，并且再大的excel不会出现内存溢出，03版依赖POI的sax模式。在上层做了模型转换的封装，让使用者更加简单方便

 使用easyexcel，首先我们需要添加maven依赖：

 <dependency>
 <groupId>com.alibaba</groupId>
 <artifactId>easyexcel</artifactId>
 <version>2.1.6</version>
 </dependency>

 * </PRE>
 *
 * @author: latico
 * @date: 2020-03-31 17:34
 * @version: 1.0
 */
package com.latico.commons.office.xls.easyexcel;