package com.sean.wang.utils.matrix;

public class Matrix {
	protected double[][] matrix;
	protected final int row;
	protected final int col;
	
	public Matrix(double[][] matrix){
		this.matrix = matrix;
		row = matrix.length;
		col = matrix[0].length;
	}
	public Matrix(int[][] matrix){
		for(int i = 0, row = matrix.length; i < row; i++){
			for(int j = 0, col = matrix[0].length; j < col; j++){
				this.matrix[i][j] = matrix[i][j];
			}
		}
		row = matrix.length;
		col = matrix[0].length;
	}
	
	public static double[] saxpy(double a, double[] x,  double[] y){
		double[] result = new double[x.length];
		for(int i = 0, len = x.length; i < len; i++)
			result[i] = x[i] * a + y[i];
		return result;
	}
	public static double[] gaxpy(double[][] A, double[] x, double[] y){
		double[] result = new double[A.length];
		for(int i = 0, len = A.length; i < len; i++){
			for(int j = 0, len2 = x.length; j < len2; j++){
				result[i] += A[i][j] * x[j];
			}
			result[i] += y[i];
		}
		return result;
	}
	
	public Matrix add(Matrix m2){
		double[][] mat = m2.toArray();
		if(row != mat.length || row != mat[0].length)
			return null;
		double[][] result = new double[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				result[i][j] = matrix[i][j] + mat[i][j];
			}
		}
		return new Matrix(result);
	}
	public Matrix minus(Matrix m2){
		double[][] mat = m2.toArray();
		if(row != mat.length || row != mat[0].length)
			return null;
		double[][] result = new double[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				result[i][j] = matrix[i][j] - mat[i][j];
			}
		}
		return new Matrix(result);
	}
	public Matrix trans(){
		double[][] result = new double[col][row];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				result[j][i] = matrix[i][j];
			}
		}
		return new Matrix(result);
	}
	public Matrix cdot(Matrix m2){
		double[][] mat = m2.toArray();
		if(col != mat.length)
			return null;
		double[][] result = new double[row][mat[0].length];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < mat[0].length; j++){
				for(int k = 0; k < col; k++){
					result[i][j] += matrix[i][k] * mat[k][j];
				}
			}
		}
		return new Matrix(result);
	}
	
	public Matrix mul(double factor){
		double[][] result = new double[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				result[i][j] = matrix[i][j] * factor;
			}
		}
		return new Matrix(result);
	}
	
	public double[][] toArray(){
		return matrix;
	}
	public String toString(){
		String str = "";
		return str;
	}
	
}

