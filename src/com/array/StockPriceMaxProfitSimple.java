package com.array;

/**
 * Maximize o lucro do estoque de forma simples Problema
 * 
 * Você recebe os preços de uma determinada ação por alguns dias. Você estava
 * autorizado a possuir no máximo uma ação a qualquer momento e não deve deter
 * nenhuma ação no final desse período. Descubra o lucro máximo que você pode
 * ter.
 * 
 * Solução A estratégia é vender o estoque no final de cada seqüência crescente.
 * E compre no final de uma sequência decrescente. Portanto, se em qualquer dia
 * o preço da ação for maior do que no dia anterior, os lucros das ações
 * aumentam no valor dessa diferença
 * 
 * @author skopo
 *
 */
public class StockPriceMaxProfitSimple {

	public static void main(String[] args) {
		
		int[] prices = { 400, 402, 435, 398, 378, 400, 432, 432, 402 };
		System.out.println(getMaxProfit(prices, false));
	}
	
	private static int getMaxProfit(int[] prices, boolean b) {

		if (prices.length == 0)
			return 0;

		int previousPrice = prices[0];
		int profit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > previousPrice) {
				profit += (prices[i] - previousPrice);
			}
			previousPrice = prices[i];
		}
		return profit;
	}
}
