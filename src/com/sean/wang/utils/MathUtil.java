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
}
