package com.array;

/**
 * Problema
Dadas duas cordas, descubra se uma corda pode ser formada girando outra corda.

Solução
Suponha que a corda b seja formada girando a corda a. Concatenamos a string a com a string a. em seguida, encontre a substring b nessa concatenação.

 * @author skopo
 *
 */
public class RotateString {
	
	public static void main(String[] args) {
		String string1 = "rotation";
		String string2 = "tionrota";
		
		System.out.println(isRotationPossible(string1, string2));
	}
	
	private static boolean isRotationPossible(String string1, String string2) {
		
		String str = string1 + string1;
		System.out.println(str);
		System.out.println(string2);
		
		return str.contains(string2) && string1.length() == string2.length();
	}
}
