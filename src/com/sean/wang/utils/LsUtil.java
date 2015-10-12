package com.sean.wang.utils;

import java.util.ArrayList;
import java.util.List;
import static com.sean.wang.utils.ArgumentCheck.*;

public class LsUtil {
	
	public static double sum(List<Double> list){
		double sum = 0;
		for(Double e:list)
			sum += e;
		return sum;
	}
	
	public static <T> boolean contains(List<T> list, T[] sub){
		for(T t:sub){
			if(!list.contains(t)){
				return false;
			}
		}
		return true;
	}
	
	public static <T> T except(List<T> ls1, List<T> ls2){
		for(int i = 0; i < ls1.size(); i++){
			boolean contain = false;
			for(int j = 0; j < ls2.size(); j++){
				if(ls1.get(i) == ls2.get(j)){
					contain = true;
				}
			}
			if(!contain)
				return ls1.get(i);
		}
		return null;
	}
	
	public static <T> int[] latestIndex(List<T> list, int n){
		int[] result = new int[n];
		for(int i = 0; i < n; i++){
			result[i] = list.size() - (n - i);
		}
		return result;
	}
	
	public static List<Double> extract(List<double[]> list, int n){
		List<Double> result = new ArrayList<>();
		for(int i = 0, len = list.size(); i < len; i++){
			if(list.get(i) == null || list.get(i).length <= n)
				continue;
			result.add(list.get(i)[n]);
		}
		return result;
	}
	
	public static double[][] toArray(List<double[]> list){
		double[][] result = new double[list.size()][];
		for(int i = 0, len = list.size(); i < len; i++){
			double[] li = list.get(i);
			double[] ar = new double[li.length];
			for(int j = 0; j < ar.length; j++){
				ar[j] = li[j];
			}
			result[i] = ar;
		}
		return result;
	}
	public static int[] toIntArray(List<Integer> list){
		int[] result=  new int[list.size()];
		for(int i = 0, len = result.length; i < len; i++){
			result[i] = list.get(i);
		}
		return result;
	}
	public static double[] toDoubleArray(List<Double> list){
		double[] result = new double[list.size()];
		for(int i = 0, len = list.size(); i < len; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	
	public static <T extends Comparable<T>> void copy(List<T> src, int from, int to, List<T> dest, int from2){
		for(int i = from; i <= to; i++) {
			dest.set(from2++, src.get(i));
		}
	}
	public static List<double[]> merge(List<Double> list1, List<double[]> list2){
		List<double[]> result = new ArrayList<>();
		for(int i = 0, len = list1.size(); i < len; i++) {
			result.add(ArrUtil.appendTo(list2.get(i), list1.get(i)));
		}
		return result;
	}
	public static <T> List<T> mergeList(List<T> list1, List<T> list2){
		List<T> result = new ArrayList<>();
		list1.forEach(e -> {
			if(!result.contains(e)){
				result.add(e);	
			}
		});
		list2.forEach(e -> {
			if(!result.contains(e)){
				result.add(e);
			}
		});
		return result;
	}
	
	public static double[] flat(List<double[]> list){
		double[] result = new double[list.size() * list.get(0).length];
		for(int i = 0, len = list.size(); i < len; i++) {
			double[] arr = list.get(i);
			for(int j = 0; j < arr.length; j++) {
				result[i * arr.length + j] = arr[j];
			}
		}
		return result;
	}
	public static int[] flatIntArrList(List<int[]> list){
		int[] result = new int[list.size() * list.get(0).length];
		for(int i = 0, len = list.size(); i < len; i++) {
			int[] arr = list.get(i);
			for(int j = 0; j < arr.length; j++) {
				result[i * arr.length + j] = arr[j];
			}
		}
		return result;
	}
	
	public static <T extends Comparable<T>> List<T> deleteRepeat(List<T> list) {
		checkArgument(list != null && list.size() > 0);
		List<T> result = new ArrayList<>();
		result.add(list.get(0));
		for(T t:list) {
			if(result.get(result.size() - 1).compareTo(t) == 0) {
				continue;
			}
			result.add(t);
		}
		return result;
	}
	
	public static <T extends Comparable<T>> void deleteRepeat_(List<T> list) {
		list = deleteRepeat(list);
	}
	
	public static <T extends Comparable<T>> int binarySearch(List<T> list, T t){
		int lower = 0;
		int upper = list.size() - 1;
		if(list.get(lower).compareTo(t) == 0) {
			return lower;
		}
		if(list.get(upper).compareTo(t) == 0) {
			return upper;
		}
		while(upper - lower > 1) {
			int mid = (lower + upper) / 2;
			if(list.get(mid).compareTo(t) > 0) {
				upper = mid;
			}else if(list.get(mid).compareTo(t) < 0) {
				lower = mid;
			}else if(list.get(mid).compareTo(t) == 0) {
				return mid;
			}
			
		}
		return -1;
	}
	
	public static double[][] select(List<double[]> list, int... indexs) {
		double[][] result = new double[indexs.length][];
		for(int i = 0, len = indexs.length; i < len; i++) {
			result[i] = list.get(indexs[i]);
		}
		return result;
	}
	
	public static double max(List<Double> arr) {
		checkArgument(arr != null && arr.size() >= 1);
		double max = arr.get(0);
		for(double a:arr) {
			max = (a > max) ? a : max;
		}
		return max;
	}
	public static double min(List<Double> arr) {
		checkArgument(arr != null && arr.size() >= 1);
		double min = arr.get(0);
		for(double a:arr) {
			min = (a < min) ? a : min;
		}
		return min;
	}
	
	public static List<Integer> within(List<double[]> list, List<Double> xd, List<Double> yd){
		if(xd.size() > 2 || yd.size() > 2) {
			return null;
		}
		List<Integer> result = new ArrayList<>();
		for(int i = 0, len = list.size(); i < len; i++) {
			double x = list.get(i)[0];
			double y = list.get(i)[1];
			if(xd.get(0) <= x && x <= xd.get(xd.size() - 1)){
				if(yd.get(0) <= y && y <= yd.get(yd.size() - 1)) {
					result.add(i);
				}
			}
		}
		return result;
	}
	public static List<Integer> within_sort(List<double[]> list, List<Double> xd, List<Double> yd){
		if(xd.size() > 2 || yd.size() > 2) {
			return null;
		}
		List<Pair> pairs = new ArrayList<>();
		for(int i = 0, len = list.size(); i < len; i++) {
			double x = list.get(i)[0];
			double y = list.get(i)[1];
			if(xd.get(0) <= x && x <= xd.get(xd.size() - 1)){
				if(yd.get(0) <= y && y <= yd.get(yd.size() - 1)) {
					pairs.add(new Pair(i, list.get(i)));
				}
			}
		}
		Sort.quickSort(pairs);
		System.out.println(list.get(pairs.get(0).getId())[1]);
		List<Integer> result = new ArrayList<>();
		for(int i = 0, len = pairs.size(); i < len; i++) {
			result.add(pairs.get(i).getId());
		}
		return result;
	}
	static class Pair implements Comparable<Pair>{
		private int id;
		private double[] point;
		public Pair(int id, double[] point){
			this.id = id;
			this.point = point;
		}
		public int getId() {
			return id;
		}
		public double[] getPoint(){
			return point;
		}
		@Override
		public int compareTo(Pair p) {
			for(int i = 0; i < point.length; i++) {
				if(point[i] < p.point[i]) {
					return -1;
				}
				if(point[i] > p.point[1]) {
					return 1;
				}
			}
			return 0;
		}
		
	}
	
	public static <T> List<T> append(List<T> l1, List<T> l2){
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		List<T> result = new ArrayList<>();
		for(T i: l1) {
			result.add(i);
		}
		for(T i:l2) {
			result.add(i);
		}
		return result;
	}
	public static <T> void append_(List<T> l1, List<T> l2){
		if(l1 == null || l2 == null) {
			return;
		}
		for(T i:l2) {
			l1.add(i);
		}
	}
	
	public static List<double[]> selectClosest(List<double[]> l1, List<Double> l2){
		List<double[]> result = new ArrayList<>();
		
		for(int i = 0, len = l2.size(); i < len; i++) {
			int closest_id = 0;
			double min_dist = Double.MAX_VALUE;
			double value = l2.get(i);
			for(int j = 0, len2 = l1.size(); j < len2; j++) {
				double dist = l1.get(j)[0] - value;
				if(Math.abs(dist) < min_dist) {
					closest_id = j;
					min_dist = Math.abs(dist);
				}
			}
			result.add(l1.get(closest_id));
		}
		return result;
	}
	
	public static int findNext(List<Integer> list, int e){
		int index = list.indexOf(e);
		return list.get((index + 1) % list.size());
	}
	public static int findPre(List<Integer> list, int e){
		int index = list.indexOf(e);
		return list.get((index - 1 + list.size()) % list.size());
	}
	
	public static String toString(List<double[]> list){
		StringBuilder builder = new StringBuilder();
		list.forEach(e -> {
			for(double d:e) {
				builder.append(d + "\t");
			}
			builder.append("\n");
		});
		return builder.toString();
	}
}
