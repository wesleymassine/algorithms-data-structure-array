package com.array;

/**
 * Espiral de matriz de impressão
 * 
 * Problema Imprima uma matriz em espiral.
 * 
 * Solução Vamos primeiro imprimir a periferia da matriz com a ajuda de 4 loops
 * for. Em seguida, chame recursivamente essa função para fazer a mesma coisa
 * com retângulos concêntricos internos. Vamos passar essa informação por uma
 * variável chamada profundidade, que dirá quantas camadas de fora devem ser
 * ignoradas.
 * 
 * @author skopo
 *
 */
public class PrintMatrixSpiral {

	
	public static void main(String[] args) {
			
	int[][] matrix = { 
			{ 3, 4, 5, 6, 2, 5 },
			{ 2, 4, 6, 2, 5, 7 },
			{ 2, 5, 7, 8, 9, 3 },
			{ 2, 4, 7, 3, 5, 8 },
			{ 6, 4, 7, 3, 5, 7 }
			};

	printSpiral(matrix);
	
	}
	
	public static void printSpiral(int[][] matrix) {
		printSpiral(matrix, 0);
	}
	
	public static void printSpiral(int[][] matrix, int depth) {
		
		if (matrix == null && matrix.length == 0)
			return ;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		if (2 * depth > Math.min(rows, cols))
			return;
		
		for (int i = depth; i < cols - depth - 1; ++i) {
			System.out.println(matrix[depth][i] + ",");
		}
		
		for (int i = depth; i < rows - depth - 1; ++i) {
			System.out.println(matrix[i][cols - depth - 1] + ", ");
		}
		
		for (int i = rows - depth; i > depth; --i) {
			System.out.println(matrix[rows - depth - 1][i] + "," );
		}
		
		for (int i = rows - depth - 1; i > depth; --i) {
			System.out.println(matrix[i][depth] + ",");
		}
		printSpiral(matrix, ++depth);
	}
}
