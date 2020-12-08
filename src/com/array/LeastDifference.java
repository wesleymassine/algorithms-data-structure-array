package com.array;

import java.util.Arrays;

/** Menor diferença na matriz
 * 
 * Problema 
 * Encontre a menor diferença entre quaisquer dois elementos de um
 * array de inteiros. 
 * 
 * Solução 
 * Primeiro, podemos classificar os elementos do
 * array. Então, podemos iterar sobre o array e encontrar a diferença entre os
 * elementos consecutivos. O menor deles seria a menor diferença entre quaisquer
 * dois elementos da matriz. A complexidade será O (nlogn) por causa da etapa de
 * classificação.
 * 
 * @author skopo
 *
 */
public class LeastDifference {
	
	public static void main(String[] args) {
		int [] arr = {64, 57, 2, 78, 43, 73, 53, 86};
		
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		
		for (int i=0; i < arr.length-1;i++) {
			int diff = Math.abs(arr[i] - arr[i+1]);
			if (diff < minDiff)
				minDiff = diff;
		}
		System.out.println(minDiff);
	}
	
}
