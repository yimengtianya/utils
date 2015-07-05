package com.sean.wang.utils.matrix;

public class Matrix {
	private double[][] matrix;
	
	public Matrix(double[][] matrix){
		this.matrix = matrix;
	}
	public Matrix(int[][] matrix){
		for(int i = 0, row = matrix.length; i < row; i++){
			for(int j = 0, col = matrix[0].length; j < col; j++){
				this.matrix[i][j] = matrix[i][j];
			}
		}
	}
	
}

