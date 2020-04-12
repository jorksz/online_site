package com.online.site.start.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 随机获取验证码
 * @return resultCode --验证码
 */
public class RandomVerCode {

	private RandomVerCode(){}

	public static String achieveCode() {
		String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
		"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
		"w", "x", "y", "z" };
		@SuppressWarnings("rawtypes")
		List list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
		sb.append(list.get(i));
		}
		String afterShuffle = sb.toString();
		String resultCode = afterShuffle.substring(3, 9);
		return resultCode;
		}
}
