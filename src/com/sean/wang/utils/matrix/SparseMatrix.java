package com.sean.wang.utils.matrix;

public class SparseMatrix {
	private double[][] sparseMatrix;
	public SparseMatrix(double[][] matrix){
		sparseMatrix = matrix;
	}
	
//	public SparseMatrix add(SparseMatrix m2m){
//		double[][] m2 = m2m.toArray();
//		
//	}
	
	public double[][] toArray(){
		return sparseMatrix;
	}
}
