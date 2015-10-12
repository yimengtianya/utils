package com.sean.test;

import java.util.Arrays;
import java.util.List;

import com.sean.wang.utils.ArrUtil;

import junit.framework.TestCase;

public class ArrUtilTest extends TestCase {
	public void testMin() {
		double[] a = { 1, 2, 3, 4, 5, -1, -2, -3, 4, -5, 2, -10, -20, 100 };
		assertEquals(-20.0, ArrUtil.min(a));
	}

	public void testToArray() {
		List<String> list = Arrays.asList(new String[] { "s", "d", "k" });
		String[] arr = ArrUtil.toArray(list, String.class);
		assertEquals(arr[0], "s");
		assertEquals(arr[1], "d");
		assertEquals(arr[2], "k");

	}

	public void testAppend() {
		double[] arr = { 1, 2, 3, 4, 5, 6 };
		double[] result = ArrUtil.appendTo(arr, 0.1);
		for (double r : result) {
			System.out.println(r);
		}
	}

	public void textExtract() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 8 };
		int[] result = ArrUtil.select(arr, 1, 2, 3);
		System.out.println(Arrays.toString(result));
	}

	public void testSum() {
		double[] d = new double[] { 2771.360733210057, 4535.445532426664, 2750.6711732888193, 4520.949090106117,
				7393.83714, 4484.616708382909, 2741.843826881231, 4470.120266062363, 2721.3688568731964,
				2181.091985624942, 3573.2399459266753, 2164.8090698754468, 3561.818958417678, 5831.9769636,
				3533.194578127838, 2157.8618492292117, 3521.773590618839, 2141.7478181486367, 2181.092385493369,
				3573.2408094630573, 2164.80946675866, 3561.8198191939764, 5831.9787132, 3533.195431986551,
				2157.8622448387623, 3521.77444171747, 2141.7482108039358, 2181.091988654249, 3573.2399260752636,
				2164.809072882138, 3561.8189386297154, 5831.976931199999, 3533.1945584989007, 2157.861852226254,
				3521.7735710533534, 2141.7478211232965, 2771.2387430473127, 4535.246621287839, 2750.5500938421537,
				4520.750814738102, 7393.514112000001, 4484.420026444989, 2741.7231359979937, 4469.924219895248,
				2721.249067260189
		};
		
		System.out.println(ArrUtil.sum(d));
	}
	
	public void testCount(){
		int[] arr = new int[100];
		for(int i = 0, len = arr.length; i < len; i++) {
			arr[i] = (int)(Math.random() * 20);
		}
		int count = ArrUtil.count(10).in(arr);
		System.out.println(count);
	}
	
	public void testFind(){
		int[] arr = {12,2,3,4,5,4,6};
		System.out.println(ArrUtil.findNext(arr, 6));
		System.out.println(ArrUtil.findPre(arr, 12));
	}
}
