package org.any.stock.analyzer.service;

import org.any.stock.analyzer.contract.Analyzer;
import org.any.stock.analyzer.model.Profit;

/**
 * Simple implementation of Analyzer
 *
 * @see org.any.stock.analyzer.contract.Analyzer
 */
public class SimpleAnalyzer implements Analyzer {

    public Profit getMaxProfit(final int[] tradeHistory) {

        if (tradeHistory == null) {
            throw new IllegalArgumentException();
        }

        final int historyLength = tradeHistory.length;

        if (historyLength == 0) {
            return new Profit();
        }

        int highestProfit = 0;
        Profit profit = new Profit();

        for (int buyIndex = 0; buyIndex < historyLength; buyIndex++) {

            int buyPrice = tradeHistory[buyIndex];


            // Should not be able to buy when price is 0 or negative
            if(buyPrice <= 0){
                continue;
            }

            int sellIndex = buyIndex + 1;
            if (sellIndex > historyLength) {
                break;
            }

            for (; sellIndex < historyLength; sellIndex++) {

                int sellPrice = tradeHistory[sellIndex];

                int possibleProfit = sellPrice - buyPrice;

                if (possibleProfit > highestProfit) {
                    highestProfit = possibleProfit;
                    profit.setBuyPrice(buyPrice);
                    profit.setSellPrice(sellPrice);
                    profit.setProfit(highestProfit);
                }

            }

        }

        return profit;
    }
}
