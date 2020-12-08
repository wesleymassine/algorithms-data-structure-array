package com.array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Dois números faltando 
 * 
 * Problema
 * 
 * Você recebe uma matriz de números naturais de 1 a n em uma matriz onde faltam
 * dois números. Portanto, o tamanho do array fornecido é n-2. Você terá que
 * encontrar os dois números que faltam. 
 * 
 * Solução
 * 
 * Podemos usar um mapa hash ou um array de marcadores de tamanho n para
 * resolver este problema em tempo O (n). Mas isso usaria O (n) espaço extra.
 * Podemos resolver este problema em tempo O (n) e usando espaço extra
 * constante.
 * 
 * Calcularemos a soma de n-2 números e a soma dos n-2 números ao quadrado em
 * uma iteração. Como sabemos, a soma de todos os números de 1 a n é n * (n + 1)
 * / 2. E a soma de todos os números ao quadrado de 1 a n é n * (n + 1) * (2n +
 * 1) / 6 Portanto, podemos encontrar a soma e a soma quadrada do número ausente
 * subtraindo-o da soma total e a soma quadrada de n números. Portanto, agora
 * sabemos a + be a ^ 2 + b ^ 2. A partir disso, podemos calcular aeb, os dois
 * números que faltam.
 * 
 * @author skopo
 *
 */
public class TwoMisingNumbers {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1; i < 100; i++) {
			list.add(i);
		}
		
		
		list.remove(new Integer(12));
		list.remove(new Integer(79));
		
		Integer[] missing = getTwoMissingNumbers(list);
		
		System.out.println(missing[0]+", "+missing[1]);
		
	}
	
	private static Integer[] getTwoMissingNumbers(ArrayList list) {
		
		int n = list.size() + 2;
		int expectedSum= n * (n+1) / 2;
		int expectedSquaredSum = n * (n+1) * (2 * n+1) / 6;
		int sum = 0;
		int squaredSum = 0;
				
//		for(int num : list) {
//			sum += num;
//			squaredSum += num*num;
//		}
		
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			num = (int) list.get(i);
			sum += num;
			squaredSum += num*num;
		}
	
		int xplusy = expectedSum - sum;
		int xsquareplusysquare = expectedSquaredSum - squaredSum;
		
		int twoxy = xplusy * xplusy - xsquareplusysquare;
		int xminusy = (int) Math.sqrt(xsquareplusysquare - twoxy); 
		
		int x = (xplusy + xminusy) / 2;
		int y = (xplusy + xminusy) / 2;
		
		return new Integer[] {x, y};
	}
}


