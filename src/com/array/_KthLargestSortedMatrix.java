package com.array;

//REVER

/**
 * Encontre o maior elemento K na matriz classificada 
 * 
 * Problema 
 * Dado um array ou matriz 2D que é classificado por suas linhas e colunas. Encontre o maior
 * elemento k desta matriz. 
 *  
 * Solução 
 * Primeiro, tentaremos encontrar a solução
 * para o problema de reorganização da matriz. Se um elemento é removido da
 * matriz, como podemos reorganizar a matriz para que as propriedades originais
 * da matriz permaneçam as mesmas, ou seja, ordenadas por suas linhas e colunas.
 * Como a matriz é classificada por linhas e colunas, pegue qualquer elemento,
 * seus elementos superior e esquerdo serão menores que o elemento e os
 * elementos direito e inferior serão maiores que o elemento. vamos assumir que
 * o elemento é um. Se a for removido da matriz, verificaremos a esquerda e a
 * parte superior. Vamos supor que a esquerda seja maior que o topo. Se
 * colocarmos a esquerda no lugar de um, left <a e a<right => left <right, que
 * mantém a ordenação da linha. como a> esquerda, inferior> a => inferior>
 * esquerda e já assumimos que esquerda> superior Portanto, essas duas equações
 * provam que a classificação por coluna também é mantida. Equações semelhantes
 * surgirão se o topo for maior do que o esquerdo e substituirmos o lugar vago
 * pelo topo. Assim, podemos substituir o elemento removido pelo maior de cima e
 * à esquerda. e então continue o processo para o próximo local removido até que
 * não haja mais nada para remover. Portanto, esse rearranjo ocorre em uma
 * matriz N * M em complexidade O (N + M).
 * 
 * Agora, para resolver o problema original, apenas removemos o elemento
 * inferior direito k vezes e reorganizamos após cada remoção. À direita, o
 * elemento inferior é o mais alto na matriz, após remover k-1 vezes podemos
 * encontrar o maior elemento k-ésimo nessa posição. A complexidade total se
 * tornará O (K (M + N)) Em uma matriz N * N, é O (K (2N)) = O (KN)
 * 
 * @author skopo
 *
 */
public class _KthLargestSortedMatrix {
	
	public static void main(String[] args) {
		
		int[][] matrix =
			  {
			  { 5, 7, 8, 9 },
			  { 6, 9, 10, 13 },
			  { 7, 11, 12, 15 },
			  { 8, 13, 16, 17 } };
		
		int k = 8;
		int result = findKthLargest(matrix, k);
		System.out.println(result);
	}
	
	private static int findKthLargest(int[][] matrix, int k) {
		
		for (int i = 0; i < k - 1; ++i)
			   reArrange(matrix, matrix.length - 1, matrix[0].length - 1);
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}
	
	private static void reArrange(int[][] matrix, int row, int col) {
		
		int newRow = 0;
		int newCol = 0;
		
		if (row == 0 && col == 0) {
			matrix[row][col] = Integer.MIN_VALUE;
			return;
		} else if (row == 0) {
			newRow = row;
			newCol = col - 1;
		} else if (col == 0) {
			newRow = row -1;
			newCol = col;
		} else if (matrix[row][col -1] > matrix[row - 1][col]) {
			newRow = row;
			newCol = col - 1;
		} else {
			newRow = row - 1;
			newCol = col;
		}
		
		matrix[row][col] = matrix[newRow][newCol];	
		reArrange(matrix, newRow, newCol);
	}
}