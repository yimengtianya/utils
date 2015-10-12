package com.sean.wang.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Function;

import static com.sean.wang.utils.ArgumentCheck.*;

public class Geom {
	public static double distSq(double[] p1, double[] p2) {
		if (p1.length != p2.length) {
			return -1;
		}
		double l = 0;
		for (int i = 0, len = p1.length; i < len; i++) {
			l += Math.pow(p1[i] - p2[i], 2);
		}
		return l;
	}

	public static double dist(double[] p1, double[] p2) {
		return Math.sqrt(distSq(p1, p2));
	}
	
	public static double[] normal(double[] p1, double[] p2){
		double[] vec = {p1[0] - p2[0], p1[1] - p2[1]};
		if(vec[0] == 0) {
			return new double[]{1, 0};
		}
		return new double[]{- vec[1] / vec[0], 1};
	}

	public static double[] middle(double[] p1, double[] p2) {
		if (p1.length != p2.length) {
			return null;
		}
		double[] mid = new double[p1.length];
		for (int i = 0, len = p1.length; i < len; i++) {
			mid[i] = (p1[i] + p2[i]) / 2.0;
		}
		return mid;
	}

	public static double[] centroid(double[]... p) {
		int len = p[0].length;
		for (int i = 0; i < p.length; i++) {
			if (p[i].length != len) {
				return null;
			}
		}
		double[] c = new double[len];
		for (int i = 0, plen = p.length; i < plen; i++) {
			for (int j = 0; j < c.length; j++) {
				c[j] += p[i][j] / (double) plen;
			}
		}
		return c;
	}

	public static double[] centroidOf(double[][] p) {
		int len = p[0].length;
		for (int i = 0; i < p.length; i++) {
			if (p[i].length != len) {
				return null;
			}
		}
		double[] c = new double[len];
		for (int i = 0, plen = p.length; i < plen; i++) {
			for (int j = 0; j < c.length; j++) {
				c[j] += p[i][j] / (double) plen;
			}
		}
		return c;
	}

	public static double area(double[]... polygon) {
		double area = 0;
		for (int i = 0, len = polygon.length; i < len; i++) {
			area += (polygon[i][0] + polygon[(i + 1) % len][0]) / 2.0 * (-polygon[i][1] + polygon[(i + 1) % len][1]);
		}
		return Math.abs(area);
	}

	public static double area2(double[]... polygon) {
		double area = 0;
		for (int i = 0, len = polygon.length; i < len; i++) {
			area += 0.5 * (polygon[i][0] + polygon[(i + 1) % len][0]) * (polygon[(i + 1) % len][1] - polygon[i][1]);
		}
		return area;
	}
	
	public static double area3D(double[]... polygon){
		checkArgument(polygon.length >= 3, "the number of points in a polygon should be at least 3");
		double[] normal = normal(polygon);
		double prj_area = 0;
		double norm = 0;
		if(Math.abs(normal[0]) > 0.00001) {
			prj_area = area3D_projection(p -> new double[]{p[1], p[2]}, polygon);
			norm = Vec3.norm(Vec3.unitizing(normal, 0));
		} 
		else if(Math.abs(normal[1]) > 0.00001) {
			prj_area = area3D_projection(p -> new double[]{p[0], p[2]}, polygon);
			norm = Vec3.norm(Vec3.unitizing(normal, 1));
		} 
		else if(Math.abs(normal[2]) > 0.00001) {
			prj_area = area3D_projection(p -> new double[]{p[0], p[1]}, polygon);
			norm = Vec3.norm(Vec3.unitizing(normal, 2));
		} 
		return norm * prj_area;
	}

	public static double[] normal(double[]... polygon){
		double[] vec1 = ArrUtil.minus(polygon[1], polygon[0]);
		double[] vec2 = ArrUtil.minus(polygon[2], polygon[0]);
		return Vec3.croPd(vec1, vec2);
	}
	
	private static double area3D_projection(Function<double[], double[]> prj, double[]... polygon){
		double[][] project = new double[polygon.length][2];
		for(int i = 0; i < polygon.length; i++) {
			project[i] = prj.apply(polygon[i]);
		}
		return area(project);
	}
	
	public static double volume(double[][][] faces){
		double volume = 0;
		double[][] centers = new double[faces.length][];
		for(int i = 0, len = faces.length; i < len; i++) {
			centers[i] = centroid(faces[i]);
		}
		double[] pcenter = centroid(centers);
		for(int i = 0, len = faces.length; i < len; i++) {
			double faceArea = area3D(faces[i]);
			double center_x = centers[i][0];
			double[] normal = normal(faces[i]);
			
			Vec3.unitizing_(normal);
			double[] out_direct = Vec3.minus(centers[i], pcenter);
			if(Vec3.dotPd(out_direct, normal) < 0) {
				Vec3.negative_(normal);
			}
			volume += center_x * normal[0] * faceArea;
		}
		return volume;
	}
	
//	public static double[] intersection(double[][] l1, double[][] l2){
//		
//	}
	
    public static class Line{
    	public static double norm(double[] p1, double[] p2){
    		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    	}
    }
	
	public static boolean counterClockwise(double[][] elem) {
		double[] center = centroid(elem);
		boolean counter = true;
		for (int i = 0, len = elem.length; i < len; i++) {
			double[] line1 = { elem[i][0] - center[0], elem[i][1] - center[1] };
			double[] line2 = { elem[(i + 1) % len][0] - center[0], elem[(i + 1) % len][1] - center[1] };
			counter = line1[0] * line2[1] - line1[1] * line2[0] > 0;
		}
		return counter;
	}

	public static class Triangle {
		public static boolean inCircumCircleOf(double[][] triangle, double[] p) {
			double[] p1 = triangle[0];
			double[] p2 = triangle[1];
			double[] p3 = triangle[2];
			double a1 = p2[0] - p1[0];
			double b1 = p2[1] - p1[1];
			double c1 = (p2[0] * p2[0] - p1[0] * p1[0] + p2[1] * p2[1] - p1[1] * p1[1]) / 2.0;
			double a2 = p3[0] - p2[0];
			double b2 = p3[1] - p2[1];
			double c2 = (p3[0] * p3[0] - p2[0] * p2[0] + p3[1] * p3[1] - p2[1] * p2[1]) / 2.0;
			double center_y = (c1 * a2 - c2 * a1) / (a2 * b1 - a1 * b2);
			double center_x = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1);
			return Math.pow(p1[0] - center_x, 2) + Math.pow(p1[1] - center_y, 2) > Math.pow(p[0] - center_x, 2)
					+ Math.pow(p[1] - center_y, 2);
		}

		public static boolean inCircumCircle(double[][] triangle, double[] p) {
			double[] p1 = { triangle[0][0], triangle[0][1],
					triangle[0][0] * triangle[0][0] + triangle[0][1] * triangle[0][1] };
			double[] p2 = { triangle[1][0], triangle[1][1],
					triangle[1][0] * triangle[1][0] + triangle[1][1] * triangle[1][1] };
			double[] p3 = { triangle[2][0], triangle[2][1],
					triangle[2][0] * triangle[2][0] + triangle[2][1] * triangle[2][1] };
			double a = (p2[1] - p1[1]) * (p3[2] - p1[2]) - (p3[1] - p1[1]) * (p2[2] - p1[2]);
			double b = -(p2[0] - p1[0]) * (p3[2] - p1[2]) + (p3[0] - p1[0]) * (p2[2] - p1[2]);
			double c = (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p2[1] - p1[1]) * (p3[0] - p1[0]);
			p = new double[] { p[0], p[1], p[0] * p[0] + p[1] * p[1] };
			double result = a * (p[0] - p1[0]) + b * (p[1] - p1[1]) + c * (p[2] - p1[2]);
			return (result < 0 && c > 0) || (result > 0 && c < 0);
		}

		public static double circumRadius(double[][] triangle) {
			double[] p1 = triangle[0];
			double[] p2 = triangle[1];
			double[] p3 = triangle[2];
			double a1 = p2[0] - p1[0];
			double b1 = p2[1] - p1[1];
			double c1 = (p2[0] * p2[0] - p1[0] * p1[0] + p2[1] * p2[1] - p1[1] * p1[1]) / 2.0;
			double a2 = p3[0] - p2[0];
			double b2 = p3[1] - p2[1];
			double c2 = (p3[0] * p3[0] - p2[0] * p2[0] + p3[1] * p3[1] - p2[1] * p2[1]) / 2.0;
			double center_y = (c1 * a2 - c2 * a1) / (a2 * b1 - a1 * b2);
			double center_x = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1);
			DecimalFormat format = new DecimalFormat("000.00");
			center_x = Double.valueOf(format.format(center_x));
			center_y = Double.valueOf(format.format(center_y));

			return Math.sqrt(Math.pow(p1[0] - center_x, 2) + Math.pow(p1[1] - center_y, 2));
		}
	}

	public static class Polygon {
		public static boolean isValid(List<double[]> points, List<int[]> segments) {
			if (points.size() != segments.size())
				return false;

			return true;
		}
	}

}
