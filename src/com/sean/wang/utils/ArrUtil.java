package com.sean.wang.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.sean.wang.utils.ArgumentCheck.*;

public class ArrUtil<T> {
	public static double sum(double[] arr){
		double sum = 0;
		for(int i = 0, len = arr.length; i < len; i++){
			sum += arr[i];
		}
		return sum;
	}

	public static double[] sum(double[][] arr){
		int col = arr[0].length;
		double[] result =  new double[col];
		for(int i = 0, len = arr.length; i < len; i++){
			for(int j = 0; j < col; j++){
				result[j] += arr[i][j];
			}
		}
		return result;
	}
	
	public static double[] add(double[] ar1, double[] ar2){
		double[] result = new double[ar1.length];
		for(int i = 0, len = ar1.length; i < len; i++){
			result[i] = ar1[i] + ar2[i];
		}
		return result;
	}
	
	public static double[] mul(double[] arr, double value){
		double[] result = new double[arr.length];
		for(int i = 0, len = arr.length; i < len; i++)
			result[i] = arr[i] * value;
		return result;
	}
	public static double[][] mul(double[][] arr, double[] values){
		double[][] result = new double[arr.length][];
		for(int i = 0, len = arr.length; i < len; i++){
			double[] r = new double[arr[i].length];
			for(int j = 0; j < r.length; j++){
				r[j] = arr[i][j] * values[i];
			}
			result[i] = r;
		}
		return result;
	}
	
	public static double cdot(double[] ar1, double[] ar2){
		if(ar1.length != ar2.length)
			return 0;
		double[] arr = new double[ar1.length];
		for(int i = 0, len = ar1.length; i < len; i++)
			arr[i] = ar1[i] * ar2[i];
		return sum(arr);
	}
	
	public static int[] toArray1(int[][] arr){
		int[] result = new int[arr.length * arr[0].length];
		int k = 0;
		for(int i = 0, len = arr.length; i < len; i++){
			for(int j = 0; j < arr[i].length; j++){
				result[k++] = arr[i][j];
			}
		}
		return result;
	}
	public static int[] toArray1i(List<int[]> arr){
		int[] result = new int[arr.size() * arr.get(0).length];
		int k = 0;
		for(int i = 0, len = arr.size(); i < len; i++){
			for(int j = 0; j < arr.get(i).length; j++){
				result[k++] = arr.get(i)[j];
			}
		}
		return result;
	}
	public static double[] toArray1d(List<double[]> arr){
		double[] result = new double[arr.size() * arr.get(0).length];
		int k = 0;
		for(int i = 0, len = arr.size(); i < len; i++){
			for(int j = 0; j < arr.get(i).length; j++){
				result[k++] = arr.get(i)[j];
			}
		}
		return result;
	}
	public static double[][] toArrayNd(double[] arr, int n){
	
		double[][] result = new double[arr.length / n][n];
		for(int i = 0, len = result.length; i < len; i++){
			for(int j = 0; j < n; j++){
				result[i][j] = arr[i * n + j];
			}
		}
		return result;
	}
	
	public static String toString(double[][] arr){
		String str = "";
		for(double[] d:arr){
			str += Arrays.toString(d) + "\r\n";
		}
		return str;
	}
	
	public static String toString(double[] arr){
		StringBuilder builder = new StringBuilder();
		for(double d:arr) {
			builder.append(d + "\n");
		}
		return builder.toString();
	}
	
	public static int count(int[] arr, int t){
		int count = 0;
		for(int a:arr){
			if(a == t){
				count++;
			}
		}
		return count;
	}
	
	public static Counter count(int value){
		return new Counter(value);
	}
	
	public static class Counter{
		private int value;
		
		public Counter(int value){
			this.value = value;
		}
		
		public int in(int[] arr){
			int count = 0;
			for(int a:arr) {
				if(a == value) {
					count++;
				}
			}
			return count;
		}
	}
	
//	public static double max(double[] arr){
//		double max = Double.MIN_VALUE;
//		for(double d:arr){
//			if(max < d){
//				max = d;
//			}
//		}
//		return max;
//	}
	
	public static int max(int... arr) {
		checkArgument(arr != null && arr.length >= 1);
		int max = arr[0];
		for(int a:arr) {
			max = (a > max) ? a : max;
		}
		return max;
	}
	public static double max(double... arr) {
		checkArgument(arr != null && arr.length >= 1);
		double max = arr[0];
		for(double a:arr) {
			max = (a > max) ? a : max;
		}
		return max;
	}
	
	public static double[] max(double[][] arr){
		double[] max = new double[arr[0].length];
		Arrays.fill(max, Double.MIN_VALUE);
		for(int i = 0, len = arr.length; i < len; i++){
			for(int j = 0; j < max.length; j++){
				if(max[j] < arr[i][j]){
					max[j] = arr[i][j];
				}
			}
		}
		return max;
	}
	 
	public static double absMax(double... arr){
		for(int i = 0, len = arr.length; i < len; i++) {
			arr[i] = (arr[i] > 0)?arr[i]:-arr[i];
		}
		return max(arr);
	}
	
	public static int min(int... arr) {
		checkArgument(arr != null && arr.length >= 1);
		int min = arr[0];
		for(int a:arr) {
			min = (a < min) ? a : min;
		}
		return min;
	}
	
	public static int min(int index, int... arr){
		int[] arr_cp = new int[arr.length]; 
		System.arraycopy(arr, 0, arr_cp, 0, arr.length);;
		Arrays.sort(arr_cp);
		return arr_cp[index];
	}
	
	public static double[] min(double[][] arr){
		double[] min = new double[arr[0].length];
		Arrays.fill(min, Double.MAX_VALUE);
		for(int i = 0, len = arr.length; i < len; i++){
			for(int j = 0; j < min.length; j++){
				if(min[j] > arr[i][j]){
					min[j] = arr[i][j];
				}
			}
		}
		return min;
	}
	
	public static double min(double... arr) {
		double result = Double.MAX_VALUE;
		for(int i = 0, len = arr.length; i < len; i++)
			result = (result < arr[i])?result:arr[i];
		return result;
	}
	
//	public static double min(double[] arr){
//		double result = Double.MAX_VALUE;
//		for(int i = 0, len = arr.length; i < len; i++)
//			result = (result < arr[i])?result:arr[i];
//		return result;
//	}
	public static boolean equal(double[] d1, double[] d2){
		if(d1.length != d2.length){
			return false;
		}
		for(int i = 0, len = d1.length; i < len; i++){
			if(d1[i] != d2[i]){
				return false;
			}
		}
		return true;
	}
	
	public static int[] add(int[] arr, int[] values){
		if(arr == null){
			arr = new int[0];
		}
		int[] result = new int[arr.length + values.length];
		System.arraycopy(arr, 0, result, 0, arr.length);
		for(int i = 0; i < values.length; i++){
			result[arr.length + i] = values[i];
		}
		return result;
	}
	public static int[] append(int[] arr, int value){
		if(arr == null){
			arr = new int[0];
		}
		int[] result = new int[arr.length + 1];
		System.arraycopy(arr, 0, result, 0, arr.length);
		result[arr.length] = value;
		return result;
	}
	public static double[] append(double[] arr, double elem){
		if(arr == null) {
			arr = new double[0];
		}
		double[] result = new double[arr.length + 1];
		System.arraycopy(arr, 0, result, 0, arr.length);
		result[arr.length] = elem;
		return result;
	}
	public static double[] appendTo(double[] arr, double elem) {
		if(arr == null) {
			return new double[]{elem};
		}
		double[] result = new double[arr.length + 1];
		System.arraycopy(arr, 0, result, 1, arr.length);
		result[0] = elem;
		return result;
	}
	
	public static int[][] toArrayN(int[] arr, int n){
		int[][] result = new int[arr.length / n][n];
		for(int i = 0, len = result.length; i < len; i++){
			for(int j = 0; j < n; j++){
				result[i][j] = arr[n * i + j];
			}
		}
		return result;
	}
	
	public static <T> List<T> toList(T[] arr){
		List<T> result = new ArrayList<>();
		for(T t:arr){
			result.add(t);
		}
		return result;
	}
	
	public static int shareCount(int[] arr1, int[] arr2){
		int count = 0;
		for(int i = 0; i < arr1.length; i++){
			for(int j = 0; j < arr2.length; j++){
				if(arr1[i] == arr2[j]){
					count++;
				}
			}
		}
		return count;
	}
	
	public static double[] minus(double[] arr1, double[] arr2){
		int len = Integer.min(arr1.length, arr2.length);
		double[] result = new double[len];
		for(int i = 0; i < len; i++){
			result[i] = arr1[i] - arr2[i];
		}
		return result;
	}
	
	public static int indexOf(int[] arr, int value){
		for(int i = 0, len = arr.length; i < len; i++){
			if(arr[i] == value)
				return i;
		}
		return -1;
	}
	public static int indexOf(int[] arr, int value, boolean direction){
		if(direction)
			return indexOf(arr, value);
		for(int i = arr.length - 1; i > 0; i--){
			if(arr[i] == value)
				return i;
		}
		return -1;
	}
	
	public static boolean contains(int[] arr, int[] sub){
		for(int i = 0; i <sub.length; i++){
			boolean c = false;
			for(int j = 0; j < arr.length; j++){
				if(arr[j] == sub[i]){
					c = true;
					break;
				}
			}
			if(c == false)
				return false;
		}
		return true;
	}
	
	public static int[] and(int[] ar1, int[] ar2){
		List<Integer> rs = new ArrayList<>();
		for(int i = 0; i < ar1.length; i++){
			for(int j = 0; j < ar2.length; j++){
				if(ar1[i] == ar2[j] && !rs.contains(ar1[i]))
					rs.add(ar1[i]);
			}
		}
		int[] result = new int[rs.size()];
		for(int i = 0; i < rs.size(); i++)
			result[i] = rs.get(i);
		return result;
	}
	public static int except(int[] ar1, int[] ar2){
		for(int i = 0; i < ar1.length; i++){
			boolean contain = false;
			for(int j = 0; j < ar2.length; j++){
				if(ar1[i] == ar2[j]){
					contain = true;
				}
			}
			if(!contain)
				return ar1[i];
		}
		return -1;
	}
	public static int[] except(int[] arr, int a){
		List<Integer> rs = new ArrayList<>();
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != a){
				rs.add(arr[i]);
			}
		}
		int[] result = new int[rs.size()];
		for(int i = 0; i < rs.size(); i++)
			result[i] = rs.get(i);
		return result;
	}
	
	public static double squareSum(double[] arr){
		double result = 0;
		for(double a:arr)
			result += a * a;
		return result;
	}
	
	public static List<double[]> toListdn(double[] arr, int n){
		List<double[]> result = new ArrayList<>();
		for(int i = 0, len = arr.length / n; i < len; i++){
			double[] ar = new double[n];
			for(int j = 0; j < n; j++){
				ar[j] = arr[i * n + j];
			}
			result.add(ar);
		}
		return result;
	}

	public static List<int[]> toListin(int[] arr, int n){
		List<int[]> result = new ArrayList<>();
		for(int i = 0, len = arr.length / n; i < len; i++){
			int[] ar = new int[n];
			for(int j = 0; j < n; j++){
				ar[j] = arr[i * n + j];
			}
			result.add(ar);
		}
		return result;
	}
	
	public static int binarySearch(double[] arr, double value){
		if(arr == null)
			return -1;
		int lower = 0;
		int upper = arr.length - 1;
		if(arr[lower] == value)
			return lower;
		if(arr[upper] == value)
			return upper;
		while(upper - lower > 1){
			int pivot = (lower + upper) / 2;
			if(arr[pivot] == value)
				return pivot;
			
			if(arr[pivot] > value)
				upper = pivot;
			else 
				lower = pivot;
		}
		return -1;
	}
	public static int[] binarySearchEx(double[] arr, double value){
		if(arr == null || arr.length <= 1){
			return null;
		}
		int lower = 0;
		int upper = arr.length - 1;
		
		if(arr[lower] == value)
			return new int[]{lower};
		if(arr[upper] == value)
			return new int[]{upper};
		if(arr[lower] > value)
			return new int[]{-1, lower};
		if(arr[upper] < value)
			return new int[]{upper, -1};
		while(upper - lower > 1){
			int pivot = (lower + upper) / 2;
			if(arr[pivot] == value)
				return new int[]{pivot};
			if(arr[pivot] > value)
				upper = pivot;
			else
				lower = pivot;
			
		}
		return new int[]{lower, upper};
	}
	
	public static double[] merge(double[] ar1, double[] ar2){
		double[] result = new double[ar1.length + ar2.length];
		for(int i = 0, len = ar1.length; i < len; i++)
			result[i] = ar1[i];
		for(int i = 0, len = ar2.length; i < len; i++)
			result[i + ar1.length] = ar2[i];
		return result;
	}
	
	public static double[] toArray(List<Double> list){
		double[] result = new double[list.size()];
		for(int i = 0, len = list.size(); i < len; i++)
			result[i] = list.get(i);
		return result;
	}
	
	public static <T> T[] toArray(List<T> list, Class<T> t){
		Class<T> type = t;
		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(type, list.size());
		for(int i = 0, len = list.size(); i < len; i++){
			result[i] = list.get(i);
		}
		return result;
	}
	
	public static double[] extract(double[][] arr, int col){
		List<Double> list = new ArrayList<>();
		for(int i = 0, len = arr.length; i < len; i++){
			if(arr[i] == null || arr[i].length <= col)
				continue;
			list.add(arr[i][col]);	
		}
		return toArray(list);
	}
	
	public static double[][] select(double[][] arr, int... indexs) {
		double[][] result = new double[indexs.length][];
		for(int i = 0, len = indexs.length; i < len; i++) {
			result[i] = arr[indexs[i]];
		}
		return result;
	}
	
	public static int[] select(int[] arr, int... indexs) {
		int[] result = new int[indexs.length];
		for(int i = 0;i < indexs.length; i++) {
			result[i] = arr[indexs[i]];
		}
		return result;
	}
	
	public static int findNext(int[] arr, int e){
		for(int i = 0, len = arr.length; i < len; i++) {
			if(e == arr[i]) {
				return arr[(i + 1) % len];
			}
		}
		return -1;
	}
	public static int findPre(int[] arr, int e){
		for(int i = 0, len = arr.length; i < len; i++) {
			if(e == arr[i]) {
				return arr[(i - 1 + len) % len];
			}
		}
		return -1;
	}
	

}
