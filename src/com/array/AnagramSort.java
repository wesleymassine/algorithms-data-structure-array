package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classifique para aproximar os anagramas 
 * 
 * Problema
 * 
 * Dada uma matriz de strings, classifique-a de forma que os anagramas fiquem
 * lado a lado. Uma palavra é chamada de anagrama de outra palavra, se uma puder
 * ser formada reorganizando as letras da outra, sem qualquer adição ou exclusão
 * de letras. 
 * 
 * Solução
 * 
 * Como dois anagramas têm exatamente o mesmo conjunto de letras e a mesma
 * contagem de letras, se classificarmos as letras de dois anagramas, elas serão
 * exatamente iguais. Agora, se usarmos essa sequência classificada de uma
 * palavra como sua chave de comparação na classificação, basicamente duas
 * palavras com a mesma sequência classificada ficarão lado a lado. Usamos essa
 * técnica para obter essa solução. Criamos uma classe de contêiner para as
 * palavras e usamos a sequência classificada dessa palavra como comparador
 * dessa classe. Agora classificamos a matriz de contêineres. Em seguida, a
 * partir dos contêineres classificados, recriamos a matriz de strings na mesma
 * ordem.
 * 
 * @author skopo
 *
 */
public class AnagramSort {
	
	public static void main(String[] args) {
		String[]arr={"dog","listen","tip","enlist","pit","god","man","top","pot"};
		
		sort(arr);
		
		for(String str:arr) {
			System.out.print(str + ", ");
		}
	}
	
	private static void sort(String[] arr) {
		List list = new ArrayList();
		
		for (String str : arr) {
			list.add(new Anagram(str));
		}
		
		Collections.sort(list);
		
		for (int i=0; i < arr.length; ++i) {
			  arr[i]=list.get(i).toString();
		}
	}

}
