package com.sean.wang.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrUtil<T> {
	public static double sum(double[] arr){
		double sum = 0;
		for(int i = 0, len = arr.length; i < len; i++){
			sum += arr[i];
		}
		return sum;
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
	public static int count(int[] arr, int t){
		int count = 0;
		for(int a:arr){
			if(a == t){
				count++;
			}
		}
		return count;
	}
	
	public static double max(double[] arr){
		double max = Double.MIN_VALUE;
		for(double d:arr){
			if(max < d){
				max = d;
			}
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
	public static int[] add(int[] arr, int value){
		if(arr == null){
			arr = new int[0];
		}
		int[] result = new int[arr.length + 1];
		System.arraycopy(arr, 0, result, 0, arr.length);
		result[arr.length] = value;
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
	
	public static int share(int[] arr1, int[] arr2){
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
	
}
