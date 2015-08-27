package com.sean.wang.utils;

public class HydroCode2D {
	
	public static double[] strainRate(double[][] p, double[][] v){
		double A = Geom.area(p);
		double[] sr = new double[3];
		for(int i = 0, len = p.length; i < len; i++){
			sr[0] += (v[i][0] + v[(i + 1) % len][0]) * (p[(i + 1) % len][1] - p[i][1]);
			sr[1] += - (v[i][1] + v[(i + 1) % len][1]) * (p[(i + 1) % len][0] - p[i][0]);
			sr[2] += - (v[i][0] + v[(i + 1) % len][0]) * (p[(i + 1) % len][0] - p[i][0])
					+ (v[i][1] + v[(i + 1) % len][1]) * (p[(i + 1) % len][1] - p[i][1]);
		}
		sr[0] /= 2 * A;
		sr[1] /= 2 * A;
		sr[2] /= 4 * A;
		
		return sr;
	}
	
}
