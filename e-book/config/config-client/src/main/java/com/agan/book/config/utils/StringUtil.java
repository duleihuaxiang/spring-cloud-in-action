package com.agan.book.config.utils;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


/**
 * string util
 * 
 */
public class StringUtil {

	/**
	 * check if two strings are equal
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean equals(String string1, String string2) {
		return (string1 == null && string2 == null) || (string1 != null && string1.equals(string2));
	}

	/**
	 * check if two strings are equal ignore case
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean equalsIgnoreCase(String string1, String string2) {
		return (string1 == null && string2 == null) || (string1 != null && string1.equalsIgnoreCase(string2));
	}

	/**
	 * check if string is empty
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		return string == null || string.trim().equals("");
	}

	/**
	 * check if string is not empty
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}

	/**
	 * split string with regex, and return list of non-empty items with leading and trailing whitespace omitted
	 * 
	 * @param string
	 * @param regex
	 * @return
	 */
	public static List<String> splitIgnoreEmpty(String string, String regex) {
		if (isEmpty(string)) {
			return null;
		}
		String[] array = string.split(regex);
		List<String> list = new ArrayList<String>(array.length);
		for (String item : array) {
			if (isNotEmpty(item)) {
				list.add(item.trim());
			}
		}
		return list;
	}

	/**
	 * filter off utf8 mb4
	 *
	 * @param text
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author Dina
	 */
	public static String filterOffUtf8Mb4(String text) throws UnsupportedEncodingException {
		byte[] bytes = text.getBytes("UTF-8");
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		int i = 0;
		while (i < bytes.length) {
			short b = bytes[i];
			if (b > 0) {
				buffer.put(bytes[i++]);
				continue;
			}
			b += 256;
			if ((b ^ 0xC0) >> 4 == 0) {
				buffer.put(bytes, i, 2);
				i += 2;
			} else if ((b ^ 0xE0) >> 4 == 0) {
				buffer.put(bytes, i, 3);
				i += 3;
			} else if ((b ^ 0xF0) >> 4 == 0) {
				buffer.put((byte) 0x3F);
				i += 4;
			}
		}
		buffer.flip();
		return new String(buffer.array(), "UTF-8");
	}
	
}
