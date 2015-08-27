package com.sean.test;

import java.util.function.Function;

import com.sean.wang.utils.MathUtil;

import junit.framework.TestCase;

public class MathUtilTest extends TestCase{
	public void testMin(){
		assertEquals(10.0, MathUtil.min(20, 30, 10));
		assertEquals(0.1, MathUtil.min(0.1, 10, 0.1));
		
	}
	
	public void testSum(){
		long s = System.nanoTime();
		double result2 = MathUtil.sum(e -> e * e * e, 1, e -> e + 1, 100);
		
		long end = System.nanoTime();
	//	System.out.println(end - s);
		
		s = System.nanoTime();
		double result = MathUtil.sum_(e -> e* e* e, 1, e -> e + 1, 100);
		end = System.nanoTime();
	//	System.out.println(end - s);
		
		assertEquals(result2, result);
	}
	
	public void testIntegral(){
		double result = MathUtil.integral(e -> e*e*e * e, 0, 1, 0.1);
		System.out.println(result);
		
		double result2 = MathUtil.integral(e-> e* e* e * e, 0, 1, 10);
		System.out.println(result2);
	}
	
	public void test(){
		double result = MathUtil.integral(t -> f(t), 0, 0.04, 100);
		System.out.println(result);
		
		double inc = 0.001;
		for(double i = 0; i < 0.03;){
			double u = u(25, 30, i);
			double v = v(25, 30, i);
			System.out.println(i + "\t" +u + "\t" + v);
			i += inc;
		}

	}
	
	private double f(double t){
		double end_time = 0.015;
		double pk_time = 0.001;
		double pk_value = 10_000_000;
		if(t <= 0)
			return 0;
		if(t <= pk_time && t > 0)
			return pk_value * t / pk_time; 
		if(t < end_time) 
			return pk_value * (end_time - t) / (end_time - pk_time);
		return 0;
	}
	
	private double u(double x, double y, double t){
		
		double vp = 4200;
		double vs = 2456;
		double rho = 2490;
		
		double theta;
		if(y != 0)
			theta = Math.atan(x / y);///////////////////////////////////
		else 
			theta = Math.PI / 2.0;
		
		double r = Math.sqrt(x * x + y * y);
		
		Function<Double, Double> kernal1 = tau -> {
			double s = tau * tau - r * r / (vp * vp);
			if(s == 0){
				s = Math.pow(10, -30);
			}
			if(s < 0)
				s = -s;
			return Math.sqrt(s);
		};

		Function<Double, Double> kernal2 = tau -> {
			double s = tau * tau - r * r / (vs * vs);
			if(s == 0)
				s = Math.pow(10, -30);
			if(s < 0)
				s = -s;
			return Math.sqrt(s);
		};
		
		double in1 = MathUtil.integral(tau -> f(t - tau) / kernal1.apply(tau), r / vp, t, 0.000001);
		double in2 = MathUtil.integral(tau -> f(t - tau) * kernal1.apply(tau), r / vp, t, 0.000001);
		double in3 = MathUtil.integral(tau -> f(t - tau) / kernal2.apply(tau), r / vs, t, 0.000001);
		double in4 = MathUtil.integral(tau -> f(t - tau) * kernal2.apply(tau), r / vs, t, 0.000001);
		
		double coor = Math.cos(theta) * Math.sin(theta) / (rho * Math.PI);
		double result = coor * MathUtil.H(t - r / vp) * (1 / (2 * vp * vp) * in1 + 1 / (r * r) * in2)
				- coor * MathUtil.H(t - r / vs) * (1 / (2 * vs * vs) * in3 + 1 / (r * r) * in4);
		
		return result;
	}
	
	private double v(double x, double y, double t){
		double vp = 4200;
		double vs = 2456;
		double rho = 2490;
		
		double theta;
		if(y != 0)
			theta = Math.atan(x / y);
		else 
			theta = Math.PI / 2.0;
		
		double r = Math.sqrt(x * x + y * y);
		
		Function<Double, Double> kernal1 = tau -> {
			double s = tau * tau - r * r / (vp * vp);
			if(s == 0){
				s = Math.pow(10, -30);
			}
			if(s < 0)
				s = -s;
			return Math.sqrt(s);
		};

		Function<Double, Double> kernal2 = tau -> {
			double s = tau * tau - r * r / (vs * vs);
			if(s == 0)
				s = Math.pow(10, -30);
			if(s < 0)
				s = -s;
			return Math.sqrt(s);
		};
		
		double in1 = MathUtil.integral(tau -> f(t - tau) / kernal1.apply(tau), r / vp, t, 0.000001);
		double in2 = MathUtil.integral(tau -> f(t - tau) * kernal1.apply(tau), r / vp, t, 0.000001);
		double in3 = MathUtil.integral(tau -> f(t - tau) / kernal2.apply(tau), r / vs, t, 0.000001);
		double in4 = MathUtil.integral(tau -> f(t - tau) * kernal2.apply(tau), r / vs, t, 0.000001);
		
		double coo = (Math.pow(Math.cos(theta), 2) - Math.pow(Math.sin(theta), 2)) / (r * r);
		
		double result = 1 / (2 * Math.PI * rho) * MathUtil.H(t - r / vp) 
				* (Math.pow(Math.cos(theta), 2) / (vp * vp) * in1 + coo * in2) 
				+1 / (2 * Math.PI * rho) * MathUtil.H(t - r / vs) * (Math.pow(Math.sin(theta), 2) / (vs * vs) 
						* in3 - coo * in4);
		return result;
	}
	
}





















