package com.sean.wang.utils;

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
}
