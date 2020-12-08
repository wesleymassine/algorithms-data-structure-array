package com.array;

/**
 * Soma da matriz exceto elemento atual 
 * Problema 
 * 
 * Substitua um elemento da matriz
 * a (i) por sum (a) -a (i) sem usar o operador '-'. Onde soma (a) = a (0) + a
 * (1) + ... + a (n) 
 * 
 * Solução 
 * 
 * Primeiro, vamos adicionar os números da esquerda
 * para a direita e colocá-los em um novo array de forma que cada elemento do
 * novo array e (i) = a (0) + a (1) + ... + a ( i-1). Então faremos a mesma
 * coisa da direita para a esquerda. Desta forma, o iº elemento incluirá todos
 * os elementos de sua esquerda e direita, mas não o elemento a (i). Como
 * estamos sempre fazendo uma soma, não precisamos de um operador '-'.
 * 
 * @author skopo
 *
 */
public class ArraySumExceptCurrent {
	
	public static void main(String[] args) {

		int[]arr = {3,1,4,5,3,4,12,3};
		int[] result = new int[arr.length];
		int i = 0;
		int sum = 0;
		
		while(i < arr.length) {
			int temp = arr[i];
			result[i++] = sum;
			sum += temp;
		}
		
		i--;
		sum = 0;
		
		while(i >= 0) {
			int temp = arr[i];
			result[i--] += sum;
			sum += temp;
		}
		
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[j]+", ");
		}
	}	
}