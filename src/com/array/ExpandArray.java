package com.array;
/**
 * Expanda a matriz 
 * 
 * Problema
 * 
 * Você recebe uma matriz de caracteres como esta a3b1c1d1e4f0g11. Você terá que
 * expandir a matriz repetindo os caracteres denotados pelos seguintes números.
 * Por exemplo, a matriz de caracteres acima será expandida para
 * aaabcdeeeeggggggggggg . A matriz fornecida terá espaços à direita mais do que
 * suficientes para que você possa modificar a matriz no local. 
 * 
 * Solução
 * 
 * Vamos resolver isso por recursão. Nosso primeiro local de leitura e de
 * escrita é 0. Como encontramos a3, sabemos que ele ocupará 3 espaços. Mas se
 * escrevermos agora, ele substituirá b. Portanto, sabemos por a3 que a próxima
 * gravação começará na 4ª posição e a leitura na 3ª posição. Portanto, chamamos
 * essa função recursiva para ler da 3ª posição e escrevê-la da 4ª posição.
 * Depois que a função recursiva retorna, escrevemos as 3 primeiras posições. A
 * recursão termina quando encontramos o caractere de espaço na posição de
 * leitura.
 * 
 * @author skopo
 *
 */
public class ExpandArray {
	
	public static void main(String[] args) {
		
		char[] arr = "a2b1c1d1e4f0g11                 ".toCharArray();
		
		expand(arr);
		
		for (char ch : arr)
			System.out.print(ch);
	}
	
	private static void expand(char[] arr) {
		expand(arr, 0, 0);
	}
	
	private static void expand(char[] arr, int startReading, int startWriting) {

		char ch = arr[startReading++];
	
		if (ch == ' ')
			return;
		
		int count = 0;
		
		while(Character.isDigit(arr[startReading])) {
			count = count * 10 + arr[startReading] - 48;
			startReading++;
		}
		
		expand(arr, startReading, startWriting + count);
		
		for (int i = 0; i < count; ++i) {
			arr[startWriting + i] = ch;
		}
	}
}


