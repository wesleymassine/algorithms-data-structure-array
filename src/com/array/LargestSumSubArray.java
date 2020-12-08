package com.array;

/**
 * Maior submatriz de soma 
 * 
 * Problema 
 * Dado um array inteiro, encontre o subarray
 * que tem a maior soma.
 * 
 * Solução Manteremos dois ponteiros no início do array. Continuaremos
 * incrementando o ponteiro final e calcularemos a soma atual. Se em qualquer
 * índice a soma atual for maior que a soma máxima, atualizaremos a soma máxima
 * e os índices correspondentes. Se a soma atual for zero ou negativa em
 * qualquer ponto, isso significa que o subarray atual não fará parte do
 * subconjunto de soma máxima. Neste cenário, movemos o ponteiro para o próximo
 * índice e continuamos o processo. A complexidade deste algoritmo é O (n)
 * porque o loop while pode ser executado no máximo 2 * n vezes
 * 
 * @author skopo
 *
 */
public class LargestSumSubArray {

	public static void main(String[] args) {
		int[] arr = { 4, 3, -5, 0, 6, -8, 12, 3, -9, 2, 5, 8, -3, 4, 8, 0, 3, -3, -5, -9, 4, 2 };
		
		maxSumSubArray(arr);
	}
	
	private static void maxSumSubArray(int[] arr) {

		int currentStart = 0;
		int currentEnd = 0;
		int currentSum = 0;

		int maxStart = 0;
		int maxEnd = 0;
		int maxSum = 0;

		while (currentEnd != arr.length) {

			currentSum += arr[currentEnd];

			if (currentSum > maxSum) {
				maxSum = currentSum;
				maxStart = currentStart;
				maxEnd = currentEnd;
			}

			if (currentSum <= 0) {
				currentStart = currentEnd + 1;
				currentSum = 0;
			}
			
			currentEnd++;
		}
		System.out.println("Maximum sum = " + maxSum);
		System.out.println("Indexes (" + maxStart + ", " + maxEnd + ")");
	}
}
