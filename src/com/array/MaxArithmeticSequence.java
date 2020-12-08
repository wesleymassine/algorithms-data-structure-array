package com.array;

/**
 * Sequência aritmética máxima em uma matriz
 * 
 * Problema
 * 
 * Você recebe uma matriz de inteiros. Encontre o comprimento da seqüência
 * aritmética mais longa na matriz. Uma sequência aritmética consiste em
 * elementos contíguos de matriz que estão em progressão aritmética.
 * 
 * Solução
 * 
 * Fazemos iterações na matriz e encontramos a diferença entre os elementos
 * consecutivos e acompanhamos a contagem mais longa da mesma diferença. Se a
 * diferença atual for diferente da diferença anterior, redefinimos a contagem.
 * Se o comprimento da diferença de corrida mais longa for k. Então, a seqüência
 * aritmética mais longa tem comprimento k + 1.
 * 
 * @author skopo
 *
 */

public class MaxArithmeticSequence {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 6, 9, 12, 15, 34, 23 };
		findMaxArithmeticSequence(arr);
	}

	private static void findMaxArithmeticSequence(int[] arr) {
		int maxLength = 0;
		int currentLength = 0;
		int prevDiff = 0;

		for (int i = 1; i < arr.length; i++) {
			if (i == 1) {
				prevDiff = arr[i] - arr[0];
				currentLength = maxLength = 2;
				continue;
			}

			if (prevDiff == arr[i] - arr[i - 1]) {
				currentLength++;
				if (currentLength > maxLength)
					maxLength = currentLength;
			} else {
				currentLength = 2;
				prevDiff = arr[i] - arr[i - 1];
			}
		}
		System.out.println("Max arithmetic sequence length = " + maxLength);
	}
}
