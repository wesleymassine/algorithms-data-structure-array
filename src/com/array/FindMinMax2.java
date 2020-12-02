package com.array;

/** Encontre o máximo e o mínimo - Metodo de divisão e conquista
 * 
 * Discussão posterior Agora vamos pensar o que acontecerá se, em vez de dois
 * números, pegarmos três números e, em seguida, primeiro encontrarmos o maior e
 * o menor deles e, em seguida, compararmos esses dois números com o máximo e o
 * mínimo. Para encontrar o maior e o menor entre 3 números, precisamos de 3
 * comparações no pior caso e 2 comparações no melhor caso. O caso médio é 2,5.
 * 
 * Portanto, para 3 números, precisamos de um total de 5 comparações no pior
 * caso e 4,5 no caso médio. Portanto, no pior caso, as comparações por número
 * são 1,6 e o ​​caso médio 1,5. Da mesma forma, podemos deduzir que a
 * comparação do pior caso nunca é inferior a 1,5. e o melhor e o caso médio são
 * iguais no caso de pegar os números aos pares.
 * 
 * Método de divisão e conquista Nesta abordagem, estamos dividindo a lista em
 * duas partes, cada parte fornecendo recursivamente o mínimo e o máximo dessa
 * parte e, em seguida, dois mínimos máximos são comparados para decidir o
 * mínimo e o máximo finais. Recursivamente, quando a matriz é reduzida a apenas
 * um único elemento, o próprio elemento torna-se mínimo e máximo.
 * 
 * Código
 * 
 * @author skopo
 *
 */
public class FindMinMax2 {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 1, 2, 6, 9, 2, 10, 11, 12 };

		MinMax result = findMinMaxRecursive(arr, 0, arr.length - 1);

		System.out.println("maximum= " + result.max);
		System.out.println("minimum= " + result.min);
	}

	private static MinMax findMinMaxRecursive(int[] arr, int i, int j) {

		if (i > j)
			return null;
		if (i == j)
			return new MinMax(arr[i], arr[i]);
		else {
			MinMax left;
			MinMax right;

			left = findMinMaxRecursive(arr, i, (i + j) / 2);
			right = findMinMaxRecursive(arr, (i + j) / 2 + 1, j);

			if (left == null)
				return right;
			else if (right == null)
				return left;
			else {
				return new MinMax(Math.min(left.min, right.min), Math.max(left.max, right.max));
			}
		}
	}
}