package com.sean.test;

import java.util.Arrays;

import com.sean.wang.utils.ArrUtil;
import com.sean.wang.utils.Geom;

import junit.framework.TestCase;

public class GeomTest extends TestCase{
	public void testCounterClockwise(){
		double[][] elem = {{1,0},{2,0},{2,1},{1,1}};
		assertEquals(true, Geom.counterClockwise(elem));
		double[][] elem2 = {{2, 0},{1,0},{2,1},{1,1}};
		assertEquals(false, Geom.counterClockwise(elem2));
	}
	
	public void testArea(){
		double[][] b = new double[][]{{0, 0}, {0, 1}, {1, 0}};
		System.out.println(Geom.area2(b));
		
		double[][] c = new double[][]{
				{8.9322134, -9.037956},
				{8.9322134, 8.962044},
				{26.932143, 8.962044},
				{26.932143, -9.037956}};
		System.out.println(Geom.area(c));
	}
	
	public void testArea3D(){
		double[][] a = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		System.out.println(Geom.area3D(a));
		System.out.println(Math.sqrt(3) / 2.0);
		
		double[][] b = new double[][]{{10.14, 12.34, 0.1},{7.24, 11.38, 0.1},{7.46, 8.48, 0.1}, {11.5, 7.72, 0.1},{13.58, 8.9, 0.1}};
		System.out.println(Geom.area3D(b));
		
		double[][] c = new double[][]{{0, 0, 2}, {-0.09, -1.13, 0}, {2, 0, 0}};
		System.out.println(Geom.area3D(c));
		
		double[][] d = new double[][]{{-10.59106, 8.13667, 0},{-11.62734, 4.27045, 0},{-10.55071, -3.21174, 0}, 
			{-6.68331, -9.06848, 0},{3.49245, -9.48052, 0}, {10.88683, -5.23115, 0},{5.22729, 7.50165, 0}};
		System.out.println(Geom.area3D(d));
		
		double[][] e = new double[][]{{8.9322134, 19.949138, -9.037956}, 
			 							{8.9322134, 19.949138, 8.962044},
			 							{26.932143, 19.949138, 8.962044	},
			 							{26.932143, 19.949138, -9.037956}};
		System.out.println(Geom.area3D(e));
		
		double[][] f = new double[][]{{-49.946406,-19.9668,-19.9668},
										{-49.940093,-9.037956,-19.949138},
										{-49.948473,-9.0794237,-9.0441736},
										{-49.940093,-19.949138,-9.037956}};
		System.out.println(Geom.area3D(f));
	}
	
	public void testVolume(){
		double[][] vertices = {{0, 0, 0}, 
								 {-20, 0, 0}, 
								 {-20, -20, 0}, 
								 {0, -20, 0}, 
								 {0, 0, 20}, 
								 {-20, 0, 20}, 
								 {-20, -20, 20}, 
								 {0, -20, 20}};
		int[][] faces_id = {{0, 1, 2, 3}, {4, 5, 6, 7}, 
							  {0, 3, 7, 4}, {1, 2, 6, 5}, 
							  {4, 0, 1, 5}, {2, 3, 7, 6}};
		int[] element = {0, 1, 2, 3, 4, 5};
		double[][][] faces = new double[element.length][][];
		for(int i = 0; i < faces.length; i++) {
			int[] face_id = faces_id[i];
			faces[i] = ArrUtil.select(vertices, face_id);
		}
		System.out.println(Geom.volume(faces));
	}
	
	public void testVolume2(){
		int[] element = {0, 1, 2, 3, 4, 149};
		int[][] faces_id = {{0, 1, 2, 3}, {4, 5, 6, 7}, 
							  {0, 3, 7, 4}, {1, 2, 6, 5},  
							  {4, 0, 1, 5}, {2, 3, 7, 6}};
		double[][] vertices = {{-49.946406,-19.9668,-19.9668},
								 {-27.029812,-19.9668,-19.9668},
								 {-27.067649,-9.037956,-19.949138},
								 {-49.940093,-9.037956,-19.949138},
								 {-49.940093,-19.949138,-9.037956},
								 {-27.067649,-19.949138,-9.037956},
								 {-27.128985,-9.0794237,-9.0441736},
								 {-49.948473,-9.0794237,-9.0441736}};
		double[][][] faces = new double[element.length][][];
		for(int i = 0; i < faces.length; i++) {
			int[] face_id = faces_id[i];
			faces[i] = ArrUtil.select(vertices, face_id);
		}
		System.out.println(Geom.volume(faces));
	}
	
	public void testVolume3(){
		int[] element = {0,1,2,3,4,5};
		int[][] faces_id = {{ 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 0, 4, 5, 1 }, { 3, 7, 6, 2 }, { 0, 3, 7, 4 },
				{ 1, 2, 6, 5 }};
		double[][] vertices = {{-27.128985, -9.0794237, -9.0441736},
						{-9.1290562, -9.0794237, -9.0441736},
						{-9.1290562, 8.9205763, -9.0441736},
						{-27.128985, 8.9205763, -9.0441736},
						{-27.128985, -9.0794237, 8.9558264},
						{-9.1290562, -9.0794237, 8.9558264},
						{-9.1290562, 8.9205763, 8.9558264},
						{-27.128985, 8.9205763, 8.9558264}};
		double[][][] faces = new double[element.length][][];
		for(int i = 0; i < faces.length; i++) {
			int[] face_id = faces_id[i];
			faces[i] = ArrUtil.select(vertices, face_id);
		}
		System.out.println(Geom.volume(faces));
	}
	public void testVolume4(){
		int[] element = {0,1,2,3,4,5};
		int[][] faces_id = {{ 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 0, 4, 5, 1 }, { 3, 7, 6, 2 }, { 0, 3, 7, 4 },
				{ 1, 2, 6, 5 }};
		double[][] vertices = {{-9.0677195, 8.962044, -19.949138},
				{8.9322134, 8.962044, -19.949138},
				{8.9700512, 19.9668, -19.9668},
				{-9.0298808, 19.9668, -19.9668},
				{-9.1290562, 8.9205763, -9.0441736},
				{8.8708781, 8.9205763, -9.0441736},
				{8.9322134, 19.949138, -9.037956},
				{-9.0677195, 19.949138, -9.037956}};
		double[][][] faces = new double[element.length][][];
		for(int i = 0; i < faces.length; i++) {
			int[] face_id = faces_id[i];
			faces[i] = ArrUtil.select(vertices, face_id);
		}
		System.out.println(Geom.volume(faces));
	}
	
	
	
	public void testNormal(){
		double[][] vertices = {{0, 0, 0}, {-20, 0, 0}, {-20, -20, 0}, {0, -20, 0}, 
				{0, 0, 20}, {-20, 0, 20}, {-20, -20, 20}, {0, -20, 20}};
		int[][] faces_id = {{0, 1, 2, 3}, {4, 5, 6, 7}, {0, 3, 7, 4}, 
				{1, 2, 6, 5}, {0, 1, 5, 4}, {2, 3, 7, 6}};
		double[][][] faces = new double[faces_id.length][][];
		for(int i = 0; i < faces.length; i++) {
			int[] face_id = faces_id[i];
			faces[i] = ArrUtil.select(vertices, face_id);
		}
		for(int i = 0; i < faces.length; i++) {
			System.out.println(Arrays.toString(Geom.normal(faces[i])));
		}
	}
	
	public void testNorm(){
		int n = 10000;
		double[][] v = new double[n][2];
		for(int i = 0; i < n; i++) {
			v[i][0] = Math.random() * 10000;
			v[i][1] = Math.random() * 10000;
		}
		
		long s = System.nanoTime();
		
		for(int i = 0; i < n - 1; i++) {
//			Geom.Line.norm(v[i], v[i + 1]);
			Geom.distSq(v[i], v[i + 1]);
		}
		
		long e = System.nanoTime();
		System.out.println(e - s);
	}
}
