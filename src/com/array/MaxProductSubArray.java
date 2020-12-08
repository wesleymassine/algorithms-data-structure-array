package com.array;

/**
 * Submatriz de produto máximo
 * 
 * Problema
 * 
 * Dado um array de inteiros com números negativos e zero, encontre o subarray
 * com produto máximo, ou seja, encontre os elementos contíguos do array que
 * produzem o produto máximo.
 * 
 * Solução Onde quer que haja 0 que divide a matriz em subarrays. Precisamos
 * encontrar o produto máximo desses subarrays individualmente e retornar o
 * maior produto. Dentro desse subproblema, se houver um número par de elementos
 * negativos, o produto máximo é o produto completo do array. Se houver um
 * número ímpar de elementos negativos, faça duas subarrays, uma vez deixando o
 * elemento negativo mais à esquerda e uma vez deixando o elemento negativo mais
 * à direita. O máximo desses dois produtos será devolvido.
 * 
 * @author skopo
 *
 */
public class MaxProductSubArray {
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, -1, 4, 0, 5, -6, -5, -6, 2, 0, 3, -4, 3, -2, 4, -3 };
		
		int[] returnIndices = new int[2];
		
		long maxProduct = findMaxProduct(arr, returnIndices);
		
		System.out.println("Maximun product " + maxProduct);
		System.out.println("Indices "+ returnIndices[0] + " - " + returnIndices[1]);
	}

	private static long findMaxProduct(int[] arr, int[] returnIndices) {

		int startIndex = 0;
		long maxProduct = 0;
		int[] indices = new int[2];

		for (int index = 0; index < arr.length; ++index) {
			if (arr[index] == 0 && index >= startIndex) {

				long product = findMaxProductWithoutZero(arr, startIndex, index - 1, indices);

				if (product > maxProduct) {
					maxProduct = product;
					returnIndices[0] = indices[0];
					returnIndices[1] = indices[1];
				}

				startIndex = index + 1;

			} else if (index == arr.length - 1) {

				long product = findMaxProductWithoutZero(arr, startIndex, index, indices);

				if (product > maxProduct) {
					maxProduct = product;
					returnIndices[0] = indices[0];
					returnIndices[1] = indices[1];
				}
			}
		}
		return maxProduct;
	}

	private static long findMaxProductWithoutZero(int[] arr, int startIndex, int endIndex, int[] returnIndices) {

		if (startIndex > endIndex || startIndex < 0 || endIndex >= arr.length)
			return 0;

		int negativeCount = 0;
		int firstNegativeIndex = -1;
		int lastNegativeIndex = -1;

		for (int index = startIndex; index <= endIndex; ++index) {

			if (arr[index] < 0) {
				negativeCount++;
				if (firstNegativeIndex == -1)
					firstNegativeIndex = index;
				lastNegativeIndex = index;
			}
		}

		if (negativeCount % 2 == 0) {
			return findMaxProductWithoutNegative(arr, startIndex, endIndex, returnIndices);
		} else {
			int[] indices = new int[2];
			long maxProduct = findMaxProductWithoutNegative(arr, firstNegativeIndex + 1, endIndex, indices);

			returnIndices[0] = indices[0];
			returnIndices[1] = indices[1];

			long maxProduct2 = findMaxProductWithoutNegative(arr, startIndex, lastNegativeIndex - 1, indices);

			if (maxProduct2 > maxProduct) {
				maxProduct = maxProduct2;
				returnIndices[0] = indices[0];
				returnIndices[1] = indices[1];
			}

			return maxProduct;
		}
	}

	private static long findMaxProductWithoutNegative(int[] arr, int startIndex, int endIndex, int[] indices) {

		if (startIndex > endIndex || startIndex < 0 || endIndex >= arr.length)
			return 0;

		long product = 1;

		for (int index = startIndex; index <= endIndex; ++index)
			product *= arr[index];

		indices[0] = startIndex;
		indices[1] = endIndex;

		return product;
	}
}
