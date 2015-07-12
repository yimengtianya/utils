package com.sean.wang.utils;

import java.text.DecimalFormat;

public class Geom{
	public static double distSq(double[] p1, double[] p2){
		if(p1.length != p2.length){
			return -1;
		}
		double l = 0;
		for(int i = 0, len = p1.length; i < len; i++){
			l += Math.pow(p1[i] - p2[i], 2);
		}
		return l;
	}
	public static double dist(double[] p1, double[] p2){
		return Math.sqrt(distSq(p1, p2));
	}
	
	public static double[] middle(double[] p1, double[] p2){
		if(p1.length != p2.length){
			return null;
		}
		double[] mid = new double[p1.length];
		for(int i = 0, len = p1.length; i < len; i++){
			mid[i] = (p1[i] + p2[i]) / 2.0;
		}
		return mid;
	}
	public static double[] centroid(double[]... p){
		int len = p[0].length;
		for(int i = 0; i < p.length; i++){
			if(p[i].length != len){
				return null;
			}
		}
		double[] c = new double[len];
		for(int i = 0, plen = p.length; i < plen; i++){
			for(int j = 0; j < c.length; j++){
				c[j] += p[i][j] / (double)plen;
			}
		}
		return c;
		
	}
	public static double[] centroidOf(double[][] p){
		int len = p[0].length;
		for(int i = 0; i < p.length; i++){
			if(p[i].length != len){
				return null;
			}
		}
		double[] c = new double[len];
		for(int i = 0, plen = p.length; i < plen; i++){
			for(int j = 0; j < c.length; j++){
				c[j] += p[i][j] / (double)plen;
			}
		}
		return c;
	}

	public static double area(double[][] polygon){
		double area = 0;
		for (int i = 0, len = polygon.length; i < len; i++) {
			area += (polygon[i][0] + polygon[(i + 1) % len][0]) / 2.0
					* (-polygon[i][1] + polygon[(i + 1) % len][1]);
		}
		return Math.abs(area);
	}
	
	public double circumRadius(double[][] triangle) {
		double[] p1 = triangle[0];
		double[] p2 = triangle[1];
		double[] p3 = triangle[2];
		double a1 = p2[0] - p1[0];
		double b1 = p2[1] - p1[1];
		double c1 = (p2[0] * p2[0] - p1[0] * p1[0] + p2[1] * p2[1] - p1[1]
				* p1[1]) / 2.0;
		double a2 = p3[0] - p2[0];
		double b2 = p3[1] - p2[1];
		double c2 = (p3[0] * p3[0] - p2[0] * p2[0] + p3[1] * p3[1] - p2[1]
				* p2[1]) / 2.0;
		double center_y = (c1 * a2 - c2 * a1) / (a2 * b1 - a1 * b2);
		double center_x = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1);
		DecimalFormat format = new DecimalFormat("000.00");
		center_x = Double.valueOf(format.format(center_x));
		center_y = Double.valueOf(format.format(center_y));

		return Math.sqrt(Math.pow(p1[0] - center_x, 2)
				+ Math.pow(p1[1] - center_y, 2));
	}
	
	public static class Triangle{
		public static double[] circumCenterOf(double[][] triangle){
			return null;
		}
		public static boolean inCircumCircle(double[][] triangle, double[] p){
			return false;
		}
	}
}
