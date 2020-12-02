package com.array;

/** Encontre o máximo e o mínimo
 * 
 * Problema 
 * Dado um array de inteiros, encontre o máximo e o mínimo do array.
 * 
 * Restrição Encontre a resposta em número mínimo de comparações.
 * 
 * Força bruta: Podemos manter duas variáveis ​​chamadas max e min. Podemos
 * iterar na lista e comparar cada número com o mínimo e o máximo, se o número
 * for maior que o máximo atualize a varivale máx, se o número for menor que o
 * mínimo, atualize o mínimo. Nesta solução de força bruta, o número de
 * comparação é 2 * n.
 * 
 * Melhor solução: Em vez de comparar cada número com máximo e mínimo, podemos
 * primeiro comparar os números em pares uns com os outros. Em seguida, compare
 * o número maior com o máximo e o número menor com o mínimo. desta forma, o
 * número de comparação para um par de números é 3. Portanto, o número de
 * comparações é 1,5 * n.
 * 
 * @author skopo
 *
 */
public class FindMinMax {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 5, 1, 2, 6, 9, 2, 10, 11 };

		int max = arr[0];
		int min = arr[0];
		int i = 0;

		for (; i < arr.length / 2; i++) {

			int num1 = arr[i * 2];
			int num2 = arr[i * 2 + 1];

			if (num1 >= num2) {

				if (num1 > max)
					max = num1;
				if (num2 < min)
					min = num2;

			} else {

				if (num2 > max)
					max = num2;
				if (num1 < min)
					min = num1;
			}
		}

		if (i * 2 < arr.length) {

			int num = arr[i * 2];

			if (num > max)
				max = num;
			if (num < min)
				min = num;
		}

		System.out.println("maximum= " + max);
		System.out.println("minimum= " + min);
	}
}
