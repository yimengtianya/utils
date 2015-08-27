package com.sean.wang.utils.matrix;

public class Matrix2By2 extends SquareMatrix{

	public Matrix2By2(double[][] matrix) {
		super(matrix);
		if(col != 2 || row != 2){
			
		}
	}
	
	public SquareMatrix inv(){
		double det = det();
		if(det == 0)
			return null;
		return new SquareMatrix(new double[][]{{matrix[1][1] / det, - matrix[0][1] / det}, {- matrix[1][0] / det, matrix[0][0] / det}});
	}
	
	public double det(){
		return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
	}
	
}
