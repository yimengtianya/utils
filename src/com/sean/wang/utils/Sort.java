package com.sean.wang.utils;

import java.util.Arrays;
import java.util.List;

public class Sort {
	public static void quickSort(double[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(double[] arr, int lower, int upper) {

		if (upper <= lower) {
			return;
		}
		int cur = partition(arr, lower, upper);
		double pivot = arr[upper];
		arr[upper] = arr[cur];
		arr[cur] = pivot;
		quickSort(arr, lower, cur - 1);
		quickSort(arr, cur + 1, upper);
	}

	private static int partition(double[] arr, int lower, int upper) {

		double pivot = arr[upper];
		int left = lower;
		int right = upper - 1;
		while (true) {
			while (left < upper && arr[left] <= pivot) {
				left++;
			}
			while (right > lower && arr[right] >= pivot) {
				right--;
			}

			if (right <= left) {
				break;
			}
			double temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}

		return left;
	}

	public static <T extends Comparable<T>> void quickSort(List<T> list) {
		quickSort(list, 0, list.size() - 1);
	}

	private static <T extends Comparable<T>> void quickSort(List<T> list,
			int lower, int upper) {
		
		if (upper <= lower) {
			return;
		}
		int cur = partition(list, lower, upper);
		T pivot = list.get(upper);
		list.set(upper, list.get(cur));
		list.set(cur, pivot);
		quickSort(list, lower, cur - 1);
		quickSort(list, cur + 1, upper);
	}

	private static <T extends Comparable<T>> int partition(List<T> list,
			int lower, int upper) {
		
		T pivot = list.get(upper);
		int left = lower;
		int right = upper - 1;
		while (true) {
			while (left < upper && list.get(left).compareTo(pivot) <= 0) {
				left++;
			}
			while (right > lower && list.get(right).compareTo(pivot) >= 0) {
				right--;
			}
			if (right <= left) {
				break;
			}

			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			left++;
			right--;
		}
		return left;
	}
	
	public static void insertionSort(double[] arr){
		insertionSort(arr, true);
	}

	public static void insertionSort(double[] arr, boolean up) {
		if (arr == null || arr.length == 0)
			return;
		for (int i = 1, len = arr.length; i < len; i++) {
			double temp = arr[i];
			boolean logic;
			logic = up?temp > arr[i - 1]:temp < arr[i - 1];
			if (logic)
				continue;
			int count = 0;
			for (int j = i - 1; j >= 0; j--) {
				logic = up?arr[j] > temp:arr[j] < temp;
				if (logic)
					count++;
			}
			int index = i;
			for (int k = 0; k < count; k++) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = temp;
		}
	}
	
	public static void mergeSort(double[] arr){
		if(arr == null || arr.length <= 1)
			return;
		mergeSort(arr, 0, arr.length - 1);
		
	}
	public static void mergeSort(double[] arr, int m, int n){
		if(n - m == 0)
			return;
		if(n - m == 1){
			if(arr[m] > arr[n]){
				double temp = arr[m];
				arr[m] = arr[n];
				arr[n] = temp;
			}
			return;
		}
		int piv = (n + m) / 2;
		mergeSort(arr, m , piv);
		mergeSort(arr, piv + 1, n);
		merge(arr, m, piv, n);
	}
	
	public static void merge(double[] arr, int p, int q, int r){
		double[] ar1 = new double[q - p + 1 + 1];
		double[] ar2 = new double[r - q + 1];
		for(int i = 0, len = ar1.length - 1; i < len; i++){
			ar1[i] = arr[p + i];
		}
		for(int i = 0, len = ar2.length - 1; i < len; i++){
			ar2[i] = arr[q + i + 1];
		}
		ar1[ar1.length - 1] = Double.MAX_VALUE;
		ar2[ar2.length - 1] = Double.MAX_VALUE;
		int k1 = 0;
		int k2 = 0;
		for(int i = p; i <= r; i++){
			if(ar1[k1] > ar2[k2]){
				arr[i] = ar2[k2];
				k2++;
			}else{
				arr[i] = ar1[k1];
				k1++;
			}
		}
		
		
	}
}
