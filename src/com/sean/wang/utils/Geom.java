package com.sean.wang.utils;

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
}
