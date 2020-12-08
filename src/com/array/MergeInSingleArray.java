package com.array;

/**
 * Mesclar duas matrizes classificadas em uma única matriz com espaço 
 * 
 * Problema
 * 
 * Uma matriz classificada possui M elementos e N espaços em branco. Outra
 * matriz possui N elementos classificados. mesclar essas duas matrizes na
 * primeira matriz de tamanho M + N 
 * 
 * Solução
 * 
 * Comece a preencher a matriz a partir do verso. Isso é das posições em branco
 * da primeira matriz. Como o espaço é igual ao tamanho do segundo array, ele
 * nunca substituirá os valores originais do primeiro array.
 * 
 * @author skopo
 *
 */
public class MergeInSingleArray {
	
	public static void main(String[] args) {
		
		int M = 10;
		int N = 12;
		
		int[] array1 = new int[M + N];
		int[] array2 = new int[N];
		
		fillElementsSorted(array1, M);
		fillElementsSorted(array2, N);
		
		printArray(array1);
		printArray(array2);
		
		merge(array1, array2, M, N);
		
		printArray(array1);
	}
	
	private static void printArray(int[] array) {
		for(int i : array)
			System.out.println(i + ",");
		System.out.println();
	}
	
	private static void merge(int[] array1, int[] array2, int M, int N) {
		
		int index = M + N - 1;
		int i = M - 1;
		int j = N - 1;
		
		while(true) {
			
			if (array1[i] > array2[j])
				array1[index--] = array1[i--];
			else
				array1[index--] = array2[j--];
			
			if (j < 0)
				break;
			
			if (i < 0) {
				while (index >= 0) {
					array1[index] = array2[index];
					index--;
				}
				break;
			}
		}
	}
	
	private static void fillElementsSorted(int[] array1, int fillCount) {
		
		array1[0] = (int) (Math.random() * 5);
		
		for (int i = 1; i < fillCount; ++i) {
			array1[i] = array1[i - 1] + (int) (Math.random() * 5);
		}
	}
}
