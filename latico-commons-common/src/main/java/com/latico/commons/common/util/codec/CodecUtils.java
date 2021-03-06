package com.latico.commons.common.util.codec;

import com.latico.commons.common.util.logging.Logger;
import com.latico.commons.common.util.logging.LoggerFactory;

import java.nio.charset.Charset;

/**
 * <PRE>
 *     编码、解码、字符集编码转换工具.
 *
 * 在仅有 中文字符 和 ASCII字符 的环境下，
 * 已知的无错误的编码转换方向如下：
 * GB2312 -> GBK
 * GB2312 -> UTF8
 * GBK -> UTF8
 * UTF8 -> GBK
 * UNICODE -> GBK
 * GBK -> UNICODE
 * UNICODE -> UTF8
 * UTF8 -> UNICODE
 *
 * 使用ISO-8859-1存储编码的转换方向如下（其他编码雷同）：
 * GBKstr -> GBKbyte -> ISOstr -> ISObyte -> GBKstr
 * UTF8str -> UTF8byte -> ISOstr -> ISObyte -> UTF8str
 * UNICODEstr -> UNICODEbyte -> ISOstr -> ISObyte -> UNICODEstr
 *  
 * </PRE>
 * @author: latico
 * @date: 2019-06-24 00:27:46
 * @version: 1.0
 */
public class CodecUtils {

	/** LOG 日志工具 */
	private static final Logger LOG = LoggerFactory.getLogger(CodecUtils.class);
	
	/** 私有化构造函数 */
	protected CodecUtils() {}
	
	/**
	 * 检测字符编码是否有效
	 * @param charset 被检测的字符编码
	 * @return true:有效; false:无效
	 */
	public static boolean isVaild(String charset) {
		boolean isVaild = true;
		try {
			"test".getBytes(charset);
		} catch (Exception e) {
			isVaild = false;
		}
		return isVaild;
	}
	
	/**
	 * 检查字符编码是否无效
	 * @param charset 被检测的字符编码
	 * @return true:无效; false:有效
	 */
	public static boolean isInvalid(String charset) {
		return !isVaild(charset);
	}
	
	/**
	 * <pre>
	 * 把以charset编码的bytes的字节数组，变成以charset编码的String
	 * 
	 * charset byte[] -> charset String
	 * </pre>
	 * @param bytes 以charset编码的源字节数组
	 * @param charset 指定编码
	 * @return 以charset编码的字符串
	 */
	public static String toStr(byte[] bytes, String charset) {
		String str = "";
		try {
			str = new String(bytes, charset);
		} catch (Exception e) {
			LOG.error("把字节数组转换成 [{}] 编码字符串失败.", charset, e);
		}
		return str;
	}
	
	/**
	 * <pre>
	 * 把任意编码的str转换为以charset编码的byte[]
	 * 
	 * 任意编码 String -> charset byte[] 
	 * 
	 * 在不知道str的编码时，慎用。
	 * 因为charset可能不兼容str的编码，导致乱码。
	 * </pre>
	 * @param str 源字符串
	 * @param charset 目标字节数组的编码
	 * @return 以charset编码的byte[]
	 */
	public static byte[] toBytes(String str, String charset) {
		byte[] bytes = {};
		try {
			bytes = str.getBytes(charset);
		} catch (Exception e) {
			LOG.error("把字符串 [{}] 转换成 [{}] 编码字节数组失败.", str, charset, e);
		}
		return bytes;
	}
	
	/**
	 * <pre>
	 * 把任意编码的str，转换为使用charset编码的String
	 * 
	 * 任意编码 String -> charset String 
	 * 
	 * 在不知道str的编码时，慎用。
	 * 因为charset可能不兼容str的编码，导致乱码。
	 * </pre>
	 * @param str 源字符串
	 * @param charset 目标字符串编码
	 * @return 以charset编码的字符串
	 */
	public static String transcode(String str, String charset) {
		byte[] bytes = toBytes(str, charset);
		return toStr(bytes, charset);
	}
	
	/**
	 * <pre>
	 * 把使用srcCharset编码的srcBytes，转换为使用destCharset编码的byte[]
	 * 
	 * srcCharset byte[] -> destCharset byte[]
	 * 
	 * 在不知道[源字节数组]的编码时，慎用。
	 * 因为[目标编码]可能不兼容[源字节数组]的编码，导致乱码。
	 * </pre>
	 * @param srcBytes 源字节数组
	 * @param srcCharset 源字节数组的编码
	 * @param destCharset 目标字节数组的编码
	 * @return 目标字节数组
	 */
	public static byte[] transcode(byte[] srcBytes, 
			String srcCharset, String destCharset) {
		String srcStr = toStr(srcBytes, srcCharset);
		return toBytes(srcStr, destCharset);
	}
	/**
	 * Calls {@link String#getBytes(Charset)}
	 *
	 * @param string
	 *            The string to codec (if null, return null).
	 * @param charset
	 *            The {@link Charset} to codec the {@code String}
	 * @return the encoded bytes
	 */
	private static byte[] getBytes(final String string, final Charset charset) {
		if (string == null) {
			return null;
		}
		return string.getBytes(charset);
	}

	/**
	 * short转换成byte数组
	 * @param s
	 * @return
	 */
	public static byte[] shortToByte(short s) {
		byte[] targets = new byte[2];
		targets[0] = (byte) (s >> 8 & 0xFF);
		targets[1] = (byte) (s & 0xFF);
		return targets;
	}
}
