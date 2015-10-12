package com.sean.wang.utils;

import java.util.function.Function;

import com.sean.tailcall.TailCall;
import com.sean.tailcall.TailCalls;

public class MathUtil {
	public static double max(double x, double y, double z){
		return (x >= y && x >= z)?x:max(y, z, x);
	}
	public static double min(double x, double y, double z){
		return (x <= y && x <= z)?x:min(y, z, x);
	}
	public static double absMax(double x, double y, double z){
		return max(Math.abs(x), Math.abs(y), Math.abs(z));
	}
	public static double x_product(double[] ar1, double[] ar2){
		return ar1[0] * ar2[1] - ar1[1] * ar2[0];
	}
	
	public static double[][] randomPoint(int n, double min, double max){
		double[][] result = new double[n][2];
		for(int i = 0; i < n; i++){
			result[i] = new double[]{Math.random() * (max - min) + min, Math.random() * (max - min) + min};
		}
		return result;
	}
	
	public static double H(double n){
		if(n == 0)
			return 0.5;
		return (n > 0) ? 1.0 : 0.0;
	}
	
	public static double sum(Function<Double, Double> term, double a, Function<Double, Double> next, double b){
		if(a > b)
			return 0;
		return term.apply(a) + sum(term, next.apply(a), next, b);
	}
	
	public static double sum_(Function<Double, Double> term, double a, Function<Double, Double> next, double b){
		return sum(term, a, next, b, 0);
	}
	
	private static double sum(Function<Double, Double> term, double a, Function<Double, Double> next, double b, double result){
		if(a > b)
			return result;
		return sum(term, next.apply(a), next, b, result + term.apply(a));
	}
	
	public static double sum__(Function<Double, Double> term, double a, Function<Double, Double> next, double b){
		return sum__(term, a, next, b, 0).invoke();
	}
	
	private static TailCall<Double>  sum__(Function<Double, Double> term, double a, Function<Double, Double> next, double b, double result){
		if(a > b)
			return TailCalls.done(result);
		return TailCalls.call(() -> sum__(term, next.apply(a), next, b, result + term.apply(a)));
	}
	
	
	
	public static double integral(Function<Double, Double> f, double a, double b, double dx){
		Function<Double, Double> add_dx = (e -> e + dx);
		return sum__(f, a + dx / 2.0, add_dx, b) * dx;
	}
	
	public static double integral(Function<Double, Double> f, double a, double b, int n){
		double h = (b - a) / (double)n;
		return h / 3.0 * ( sum_(k -> k % 2 == 0 ? 2 * f.apply(a + k * h): 4 * f.apply(a + k * h), 1, e -> e + 1, n - 1) 
				+ f.apply(a) + f.apply(a + n * h));
	}
	
	public static double integral_trapezoid(Function<Double, Double> f, double a, double b, double dx) {
		double h = dx;
		Function<Double, Double> g = x -> (f.apply(x) + f.apply(x + h)) / 2.0;
		return dx * sum__(g, a, e -> e + dx, b -dx);
	}
	
	public static double integral_simpson(Function<Double, Double> f, double a, double b, int m) {
		double h = (b - a) / (double) m;
		double dx = h / 2.0;
		Function<Integer, Double> g = i -> 1 / 6.0 * f.apply(a + (i - 1) * h) + 2 / 3.0 * f.apply(a + (i - 1) * h + dx) + 1 / 6.0 * f.apply(a + i * h);
		return h * sum___(g, 1, e -> e + 1, m);
	}
	
	public static double integral_cotes(Function<Double, Double> f, double a, double b, double dx){
		double h = dx / 4.0;
		Function<Double, Double> g = x -> 7 / 90.0 * f.apply(x) + 16 / 45.0 * f.apply(x + h) + 2 / 15.0 * f.apply(x + 2 * h)
		 		+ 16 / 45.0 * f.apply(x + 3 * h) + 7 / 90.0 * f.apply(x + dx);
		return dx * sum__(g, a, e -> e + dx, b - dx);
	}
	
	public static double integral_cotes(Function<Double, Double> f, double a, double b, int m) {
		double h = (b - a) / (double) m;
		double dx = h / 4.0;
		Function<Integer, Double> g = i -> 7 / 90.0 * f.apply(a + (i - 1) * h) + 16 / 45.0 * f.apply(a + (i - 1) * h + dx)
		 + 2 / 15.0 * f.apply(a + (i - 1) * h + 2 * dx) + 16 / 45.0 * f.apply(a + (i - 1) * h + 3 * dx) + 7 / 90.0 * f.apply(a + i * h);
		return h * sum___(g, 1, e -> e + 1, m);
	} 
	
	private static double sum___(Function<Integer, Double> term, int min, Function<Integer, Integer> next, int max){
		return sum___(term, min, next, max, 0).invoke();
	}
	private static TailCall<Double> sum___(Function<Integer, Double> term, int min, Function<Integer, Integer> next, int max, double result) {
		if(min > max) {
			return TailCalls.done(result);
		}
		return TailCalls.call(() -> sum___(term, next.apply(min), next, max, result + term.apply(min)));
	}
	
	public static double integral_trapezoid(Function<Double, Double> f, double a, double b, int m){
		double h = (b - a) / (double) m;
		double dx = h;
		Function<Integer, Double> g = i -> 0.5 * f.apply(a + (i - 1) * dx) + 0.5 * f.apply(a + i * dx);
		return h * sum___(g, 1, e -> e + 1, m);
	}
	
	
}
