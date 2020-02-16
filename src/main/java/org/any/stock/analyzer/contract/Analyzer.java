package org.any.stock.analyzer.contract;

import org.any.stock.analyzer.model.Profit;

public interface Analyzer {

    /**
     * Interface to be used by the implementation and client of an Analyzer that gets the max profit possible
     * from 1 buy and 1 sell transaction given some trade data.
     *
     * @param tradeHistory - The stock price history where:
     *
     *       - The indices are the time in minutes past trade opening time, which was 10:00am local time.
     *       - The values are the price in dollars of the Latitude Financial stock at that time.
     *                     Should be using another data type for stock values in real life will most probably have decimal points,
     *                     just using int as challenge mention price in dollars.
     *
     * @return - A Profit object that describes the profit found.
     */
    Profit getMaxProfit(int[] tradeHistory);


}
