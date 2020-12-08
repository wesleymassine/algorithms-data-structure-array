package com.array;

/**
 * Encontrar várias matrizes classificadas de repetição
 * 
 * Problema Encontre a repetição em vários arrays classificados sem usar espaço
 * extra. Existem k matrizes classificadas. Precisamos descobrir se alguns
 * números estão se repetindo em qualquer uma dessas matrizes. Aqui, k é
 * constante e temos espaço extra na ordem de k, pois eles são constantes. A
 * restrição é não usar espaço extra na ordem do comprimento dos arrays.
 * 
 * Solução Vamos implementar uma solução que possui complexidade de O (n) e
 * usando espaço extra de O (k). No início, examinamos as matrizes individuais
 * em busca de repetições. Conforme os arrays são ordenados, se houver
 * repetições, os números ficarão lado a lado. Portanto, sempre verificamos dois
 * elementos adjacentes e relatamos a repetição. Agora, o caso complexo é
 * descobrir a repetição nos arrays. À medida que os arrays são classificados,
 * tentamos fazer uma mesclagem dos arrays como uma classificação por mesclagem.
 * Mas a única exceção é que não armazenamos o array resultante. Nós apenas
 * continuamos verificando a frente de cada matriz. Se alguma repetição for
 * encontrada na frente dos k arrays, nós os relatamos e movemos o ponteiro dos
 * arrays correspondentes para o próximo elemento. Se nenhuma repetição for
 * encontrada na primeira linha, movemos o ponteiro do número mínimo como uma
 * classificação por mesclagem. Quando o último elemento de cada array é
 * alcançado, concluímos a pesquisa. Desta forma, como sempre nos preocupamos
 * com a frente de cada array, nosso espaço extra não cresce na ordem do total
 * de elementos. Depende apenas do número de elementos frontais, ou seja, da
 * ordem de k.
 * 
 * @param arr
 */
public class FindRepetitionWithoutExtraSpace {

	public static void main(String[] args) {
		
		int[][]arr = {
					{8,12,13,16,17,22,24,29},
			    	{4,8,14, 16,18,23},
			    	{33,36,37,44,95,126},
			    	{5,7,15,18}
			    	};
		
		findRepetition(arr);
	}
	
	public static void findRepetition(int[][] arr) {
		
		int index[] = new int[arr.length];
		int frontNumber[] = new int[arr.length];
		int length[] = new int[arr.length];

		for (int i = 0; i < arr.length; ++i) {
			length[i] = arr[i].length;
		}

		boolean modifild = true;

		while (modifild) {
			
			modifild = false;

			for (int i = 0; i < arr.length; ++i) {
				if (index[i] < length[i]) {
					modifild = true;
					frontNumber[i] = arr[i][index[i]];
				} 
				else {
					frontNumber[i] = Integer.MAX_VALUE;
				}
			}

			int min = frontNumber[0];
			int minIndex = 0;

			for (int i = 1; i < arr.length; i++) {
				if (frontNumber[i] == min) {
					if (frontNumber[i] != Integer.MAX_VALUE)
						System.out.println(frontNumber[i]);
					index[i]++;
				} 
				else if (frontNumber[i] < min) {
					min = frontNumber[i];
					minIndex = i;
				}
			}
			index[minIndex]++;
		}
	}
}
