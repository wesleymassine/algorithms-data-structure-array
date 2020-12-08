package com.array;

/**
 * Problema
 * 
 * Dada uma matriz que contém inteiros positivos e negativos. Encontre a
 * submatriz que possui a soma máxima.
 * 
 * Força bruta Há um intervalo total de O (n ^ 2) linhas e O (n ^ 2) colunas.
 * Portanto, submatriz total de O (n ^ 4). Para encontrar a soma de qualquer
 * submatriz, precisamos fazer uma operação O (n ^ 2). Portanto, o algoritmo de
 * força bruta terá uma complexidade de O (n ^ 6).
 * 
 * Melhor Solução
 * 
 * Criaremos uma matriz do mesmo tamanho para manter a soma vertical da matriz
 * original. Por exemplo verticalSum [i, j] = arr [0, j] + arr [1, j] + ... +
 * arr [i, j]. Agora vamos pegar o intervalo de linhas e mover da esquerda para
 * a direita para encontrar a soma máxima. Existem O (n ^ 2) intervalos de
 * linhas possíveis. O intervalo de linhas será um intervalo de rowStart a
 * rowEnd. Ambas as variáveis ​​podem variar de 1 a n. Portanto, há O (n ^ 2)
 * rowRange possível. Para qualquer linha inicial, começamos com uma linha e
 * movemos da esquerda para a direita. Em seguida, pegamos 2 linhas e movemos da
 * esquerda para a direita. Enquanto fazemos isso, mantemos uma soma de matriz
 * que mantém a soma vertical do intervalo de linha selecionado. Esta matriz de
 * soma e matriz de soma vertical nos ajudarão a encontrar a soma de uma nova
 * submatriz no tempo O (1). Portanto, a complexidade de tempo total será O (n ^
 * 3). O (n ^ 2) para o intervalo de linhas, e teremos uma operação O (coluna)
 * dentro disso.
 * 
 * @author skopo
 *
 */

public class LargestSumSubMatrix {

	public static void main(String[] args) {
		  int[][] arr = {
			  { 1, -2, -7, 0 },
			  { -6, 2, 9, 2 },
			  { -4, -2, -1, 4 },
			  { -1, -8, 0, -4 } };
		  
		  int[] leftRightTopBottom = new int[4];
		  int maxsum = findMaximumSumSubMatrix(arr, leftRightTopBottom);
		  
		  System.out.println("Max sum: "+ maxsum);
		  System.out.println("indices left right top bottom");
		  
		  for (int index : leftRightTopBottom)
			  System.out.println(index + ", ");
	}

	private static int findMaximumSumSubMatrix(int[][] arr, int[] leftTopRightBottom) {

		leftTopRightBottom[0] = 0;
		leftTopRightBottom[1] = 0;
		leftTopRightBottom[2] = 0;
		leftTopRightBottom[3] = 0;

		int rows = arr.length;
		int cols = arr[0].length;

		int[] sum = new int[cols];
		int[] pos = new int[cols];

		int localMax;
		int maxSum = arr[0][0];
		int[][] verticalSum = new int[rows][cols];

		for (int iRow = 0; iRow < rows; iRow++) {
			for (int jCol = 0; jCol < cols; jCol++) {
				if (jCol == 0) {
					verticalSum[jCol][iRow] = arr[jCol][iRow];
				} else {
					verticalSum[jCol][iRow] = arr[jCol][iRow] + verticalSum[jCol - 1][iRow];
				}
			}
		}

		for (int iRow = 0; iRow < rows; iRow++) {

			for (int k = iRow; k < rows; k++) {

				for (int index = 0; index < cols; index++) {
					sum[index] = 0;
					pos[index] = 0;
				}

				localMax = 0;
				int tmp = 0;

				if (iRow > 0) {
					tmp = verticalSum[iRow - 1][0];
				}

				sum[0] = verticalSum[k][0] - tmp;

				for (int j = 1; j < cols; j++) {
					tmp = 0;

					if (iRow > 0) {
						tmp = verticalSum[iRow - 1][j];
					}

					if (sum[j - 1] > 0) {
						sum[j] = sum[j - 1] + verticalSum[k][j] - tmp;
						pos[j] = pos[j - 1];
					} else {
						sum[j] = verticalSum[k][j] - tmp;
						pos[j] = j;
					}

					if (sum[j] > sum[localMax]) {
						localMax = j;
					}
				}

				if (sum[localMax] > maxSum) {
					maxSum = sum[localMax];
					leftTopRightBottom[0] = pos[localMax];
					leftTopRightBottom[1] = localMax;
					leftTopRightBottom[2] = iRow;
					leftTopRightBottom[3] = k;
				}
			}
		}
		return maxSum;
	}
}