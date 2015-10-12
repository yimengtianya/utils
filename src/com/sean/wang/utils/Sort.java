package com.sean.wang.utils;

import java.util.ArrayList;
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

	public static <T extends Comparable<T>> void insertionSort(List<T> list) {
		insertionSort(list, true);
	}
	
	public static <T extends Comparable<T>> void insertionSort(List<T> list, boolean up) {
		if (list == null || list.size() <= 1) {
			return ;
		}
		for(int j = 1; j < list.size(); j++) {
			T key = list.get(j);
			int i = j - 1;
			while(i >= 0 && (up ? list.get(i).compareTo(key) > 0 : list.get(i).compareTo(key) < 0)) {
				list.set(i + 1, list.get(i));
				i--;
			}
			list.set(i + 1, key);
		}
	}
	
	public static <T extends Comparable<T>> void insertion_sort_it(List<T> list){
		if(list == null || list.size() <= 1) {
			return;
		}
		insertion_sort_it(list, list.size() - 1);
	}
	private static <T extends Comparable<T>> void insertion_sort_it(List<T> list, int index){
		if(index == 0) {
			return;
		}
		insertion_sort_it(list, index - 1);
		insert(list, index);
	}
	private static <T extends Comparable<T>> void insert(List<T> list, int index) {
		T key = list.get(index);
		index--;
		while(index >= 0 &&  key.compareTo(list.get(index)) < 0) {
			list.set(index + 1, list.get(index));
			index--;
		}
		list.set(index + 1, key);
	}
	
	public static void mergeSort(double[] arr){
		if(arr == null || arr.length <= 1)
			return;
		mergeSort(arr, 0, arr.length - 1);
		
	}
	public static void mergeSort(double[] arr, int m, int n){
		if(n - m == 0)
			return;
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
	public static <T extends Comparable<T>> void mergeSort(List<T> list){
		if (list == null || list.size() <= 1) {
			return;
		}
		mergeSort(list, 0, list.size() - 1);
	}
	public static <T extends Comparable<T>> void mergeSort(List<T> list, int s, int e){
		if(e - s == 0) {
			return;
		} 
		int m = (s + e) / 2;
		mergeSort(list, s, m);
		mergeSort(list, m + 1, e);
		merge(list, s, m, e);
	}
	private static <T extends Comparable<T>> void merge(List<T> list, int s, int m, int e) {
		List<T> list1 = new ArrayList<>();
		List<T> list2 = new ArrayList<>();
		for(int i = s; i <= m; i++) {
			list1.add(list.get(i));
		}
		for(int i = m + 1; i <= e; i++) {
			list2.add(list.get(i));
		}
		int k1 = 0;
		int k2 = 0;
		
		for(int i = s; i <= e; i++ ) {
			if(k1 == list1.size()) {
				LsUtil.copy(list2, k2, list2.size() - 1, list, i);
				return;
			}
			if(k2 == list2.size()) {
				LsUtil.copy(list1, k1, list1.size() - 1, list, i);
				return;
			}
			if(list1.get(k1).compareTo(list2.get(k2)) < 0) {
				list.set(i, list1.get(k1));
				k1++;
			}else {
				list.set(i, list2.get(k2));
				k2++;
			}
		}
	}
}
