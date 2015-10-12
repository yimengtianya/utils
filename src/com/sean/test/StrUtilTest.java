package com.sean.test;

import com.sean.wang.utils.StrUtil;

import junit.framework.TestCase;

public class StrUtilTest extends TestCase{
	public void testUpperCase() {
		String s = "i love you";
		System.out.println(StrUtil.upperCase(s, 0));
	}
}
