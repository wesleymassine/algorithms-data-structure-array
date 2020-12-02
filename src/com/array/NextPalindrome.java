package com.array;

/** Próximo palíndromo maior
 * 
 * Problema 
 * Dado um inteiro, encontre o inteiro maior imediato que é um
 * palíndromo, por exemplo, 1234212 -> 1234321, 345676 -> 346643.
 * 
 * Solução 
 * Deixe o dígito dos inteiros ser abcdef. Como o número de dígitos é
 * par, vamos dividi-lo em duas partes, abc e def. Agora invertemos a primeira
 * parte e ela se torna cba. se cba for maior que def, então abccba é a
 * resposta. Se for menor, incrementamos a primeira parte e ela se torna (abc +
 * 1) = suponha xyz, então a resposta seria xyzzyx. Agora vamos verificar o que
 * acontece quando o número de dígitos é ímpar. Seja o inteiro abcdefg.
 * 
 * Dividimos em 3 partes. ABCDEFG. se cba for maior que efg, a resposta será
 * abcdcba. Se for menor, então abcd é incrementado em 1. Suponha (abcd + 1) =
 * wxyz. Então, a resposta é wxyzyxw.
 * 
 * @author skopo
 *
 */
public class NextPalindrome {

	public static void main(String[] args) {
		
		int palindrome = 112100;
		System.out.println(nextPalindrome(palindrome));
	}
	
	public static int nextPalindrome(int num) {
		return nextPalindrome(num, true);
	}
	
	private static int nextPalindrome(int num, boolean fistTime) {
		String numString = "" + num;
		int leftEndIndex = -1;
		int rightStartIndex = -1;
		boolean isOld = numString.length() % 2 == 1;

		if (isOld) {
			leftEndIndex = numString.length() / 2;
			rightStartIndex = leftEndIndex + 1;
		} else {
			leftEndIndex = rightStartIndex = numString.length() / 2;
		}

		String leftHalf = numString.substring(0, leftEndIndex);
		String rightHalf = numString.substring(rightStartIndex);

		String leftReversed = new StringBuffer(leftHalf).reverse().toString();
		String palindrome = null;

		if (Integer.parseInt(leftReversed) > Integer.parseInt(rightHalf) || !fistTime) {
			if (isOld)
				palindrome = leftHalf + numString.charAt(leftEndIndex) + leftReversed;
			else
				palindrome = leftHalf + leftReversed;

			return Integer.parseInt(palindrome);

		} else {
			if (isOld) {
				String leftAndMiddle = leftHalf + numString.charAt(leftEndIndex);
				int incrementedLeft = Integer.parseInt(leftAndMiddle) + 1;

				return nextPalindrome(Integer.parseInt(incrementedLeft + rightHalf), false);
			} else {
				int incrementedLeft = Integer.parseInt(leftHalf) + 1;
				return nextPalindrome(Integer.parseInt(incrementedLeft + rightHalf), false);
			}

		}

	}
}
