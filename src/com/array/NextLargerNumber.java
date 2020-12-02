package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Encontre o próximo número maior 
 * 
 * Problema: 
 * Dado um número cujos dígitos são únicos,
 * encontre o próximo número maior que pode ser formado com esses dígitos.
 * 
 * Solução 
 * Se todos os dígitos estiverem em ordem decrescente da esquerda para a
 * direita, nenhum número maior será possível, pois esse é o maior número
 * possível com esses dígitos. Se eles não estiverem nessa ordem, um número
 * maior será possível. Precisamos encontrar o dígito mais à direita que seja
 * maior do que seu esquerdo imediato. Em seguida, podemos colocar o dígito
 * maior no lugar do dígito menor e, em seguida, organizar os dígitos restantes
 * em ordem crescente. Por exemplo, se o número for 3784, 8 é o dígito mais à
 * direita, que é maior do que a esquerda (7). Primeiro substituímos 7 por 8,
 * então ele se torna 38 .., em seguida, organizamos o 7 e o 4 em ordem
 * crescente. então se torna 3847
 * 
 * @author skopo
 *
 */

public class NextLargerNumber {
	
	public static void main(String[] args) {
		System.out.println("3784=>" + getNextLarger(3784));
		System.out.println("5963=>" + getNextLarger(5963));
		System.out.println("3784=>" + getNextLarger(3784));
		System.out.println("9531=>" + getNextLarger(9531));
		System.out.println("1234=>" + getNextLarger(1234));
		System.out.println("3=>" + getNextLarger(123));
	}

	private static int getNextLarger(int decimalNumber) {
		
		List digits = new ArrayList<Integer>();
		digits = numberToDigits(decimalNumber);
		
		int rigthBiggerIndex = -1;
		
		for (int i = digits.size() - 1; i > 0; i--) {
			int x = (int) digits.get(i);
			int y = (int) digits.get(i - 1);
			if (x > y) {
				rigthBiggerIndex = i;
				break;
			}
		} 
		
		if (rigthBiggerIndex != -1) {
			swap(digits, rigthBiggerIndex, rigthBiggerIndex - 1);
			sort(digits, rigthBiggerIndex, digits.size());
		}
		return digitsToNumber(digits);
	}
	
	private static List numberToDigits(int number) {
		List digits = new ArrayList<Integer>();
		while (number > 0) {
			digits.add(0, number % 10);
			number /= 10;
		}
		return digits;
	}
	
	private static int digitsToNumber(List<Integer> digits) {
		int number = 0;
		for (Integer digit : digits) {
			number *= 10;
			number += digit;
		}
		return number;
	}
	
	private static void sort(List<Integer> digits, int startIndex, int endIndex) {
		if (startIndex == endIndex)
			return;
		for (int k = startIndex; k < endIndex - 1; ++k)
			for (int l = startIndex + 1; l < endIndex; ++l) {
				if (digits.get(k) > digits.get(l))
					swap(digits, k, l);
			}
	}
	
	private static void swap(List<Integer> digits, int i, int j) {
		Integer temp = digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
	}
}
