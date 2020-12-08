package com.array;

/**
 * Pesquisa na matriz classificada
 * 
 * Problema
 * 
 * Dada uma matriz cujas linhas e colunas são classificadas, pesquise um
 * elemento nessa matriz.
 * 
 * Solução
 * 
 * Começamos a partir do elemento superior direito da matriz. Se o elemento de
 * pesquisa for maior que o elemento movemos abaixo, se for menor, movemos para
 * a esquerda. E continuamos o processo acima. Desta forma, ou encontraremos o
 * elemento ou chegaremos a uma posição onde a esquerda ou o fundo não são
 * possíveis. Em uma matriz N * M, a complexidade da pesquisa é O (N + M). 
 * Na matriz N * N, a complexidade é O (2 * N) = O (N)
 * 
 * @author skopo
 *
 */
public class SearchInSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix =
			  {
			  { 5, 7, 8, 9 },
			  { 6, 9, 11, 13 },
			  { 7, 11, 12, 14 },
			  { 8, 13, 16, 17} };
		
		int k = 17;
		boolean result = contains(matrix, k);
		System.out.println("Contem => "+ result +" = "+ k);
	}
	
	private static boolean contains(int[][] matrix, int k) {

		int row = matrix.length;
		int col = matrix[0].length;
		int currentRow = 0;
		int currentCol = col - 1;

		while (currentRow != row && currentCol != -1) {
			if (matrix[currentRow][currentCol] == k)
				return true;
			else if (matrix[currentRow][currentCol] > k)
				currentCol--;
			else
				currentRow++;
		}
		return false;
	}
}
