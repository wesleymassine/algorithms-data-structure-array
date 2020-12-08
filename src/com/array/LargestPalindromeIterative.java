package com.array;

/**
 * Encontre o maior palíndromo iterativo
 * 
 * Problema Uma string é chamada de palíndromo quando é a mesma ao ler caractere
 * por caractere do lado esquerdo ou direito. Dada qualquer string arbitrária,
 * encontre a maior substring nela, que é um palíndromo.
 * 
 * Força bruta Uma string de comprimento n tem substring O (n ^ 2). Isso ocorre
 * porque startIndex pode variar de 0 a n e endIndex pode variar de startIndex a
 * n. Agora, para verificar se cada uma dessas substrings é um palíndromo ou
 * não, precisamos ter a operação O (n). Portanto, a complexidade geral seria O
 * (n ^ 3).
 * 
 * Melhor Solução Usaremos uma abordagem iterativa para resolver este problema
 * em complexidade de tempo O (n ^ 2) usando uma quantidade constante de espaço
 * extra. O que iremos melhorar na força bruta é o momento de verificar se a
 * substring escolhida é um palíndromo ou não. Em vez de um tempo O (n) para
 * verificar o palíndromo, iremos checá-lo no tempo O (1). Isso será feito
 * usando as informações coletadas durante a escolha da substring. Sempre
 * escolheremos uma substring para verificação de palíndromo que tenha um
 * palíndromo interno logo abaixo do periférico. Portanto, quando verificamos os
 * caracteres de duas extremidades, podemos dizer conclusivamente se a substring
 * completa é um palíndromo ou não. Para fazer isso, escolheremos uma substring
 * de comprimento que é axiomaticamente palíndromo. Então cresceremos
 * radialmente. Em qualquer ponto, se encontrarmos um não palíndromo, pararemos
 * esse centro e passaremos para o próximo centro. Para um número par de letras,
 * precisamos escolher o centro como a lacuna entre duas letras. Para isso,
 * escolhemos um total de 2n-1 centros para verificar. Ao encontrar o palíndromo
 * sempre que um raio do palíndromo for maior do que o máximo armazenado
 * anteriormente, atualizaremos o centro e o raio do maior palíndromo.
 * 
 * @author skopo
 *
 */
public class LargestPalindromeIterative {

	public static void main(String[] args) {
		String str = "abccbabacbcacba";
		String result = findLargestPalindrome(str);
		System.out.println(result);
	}

	private static String findLargestPalindrome(String str) {

		if (str == null || str.length() == 0)
			return "";

		int centers = 2 * str.length() - 1;
		int radii = str.length() - 1;
		int maxCenter = 0;
		int maxRadius = 0;

		for (int center = 0; center < centers; ++center) {

			for (int radius = 0; radius <= radii; ++radius) {
				if (center - radius < 0 || center + radius >= centers) {
					break;
				} else if ((center + radius) % 2 == 1) {
					continue;
				} else if (str.charAt((center - radius) / 2) != str.charAt((center + radius) / 2)) {
					break;
				} else {
					if (radius > maxRadius) {
						maxRadius = radius;
						maxCenter = center;
					}
				}
			}

		}
		return str.substring((maxCenter - maxRadius) / 2, (maxCenter + maxRadius) / 2 + 1);
	}
}