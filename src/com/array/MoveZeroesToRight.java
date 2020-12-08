package com.array;

/**
 * Mova zeros para a direita com troca mínima
 * 
 * Problema 
 * Você recebe um array inteiro que contém alguns zeros. Mova os zeros
 * para o lado direito da matriz com o número mínimo de trocas. A ordem da
 * matriz original pode ser destruída.
 * 
 * Solução 
 * Podemos fazer isso em no máximo n / 2 swaps. Movemos um índice da
 * esquerda para a direita e outro da direita para a esquerda. Se obtivermos um
 * número diferente de zero no índice direito e zero no índice esquerdo,
 * trocamos os números. Se no lado direito obtivermos um zero, apenas movemos o
 * ponteiro para o lado esquerdo e se obtivermos um diferente de zero no índice
 * esquerdo, então o movemos para o lado direito. Continuamos esse processo até
 * que os dois ponteiros se encontrem.
 * 
 * @author skopo
 *
 */
public class MoveZeroesToRight {

	public static void main(String[] args) {
		int[] arr = { 0, 5, 0, 2, 3, 0, 3, 5, 0 };

		moveZeroesToRight(arr);

		for (int num : arr) {
			System.out.print(num + ", ");
		}
	}

	private static void moveZeroesToRight(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] == 0 && arr[end] != 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			} else {
				if (arr[start] != 0)
					start++;
				if (arr[end] == 0)
					end--;
			}
		}
	}
}
