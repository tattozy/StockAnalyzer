package org.any.stock.analyzer.service;

import org.any.stock.analyzer.model.Profit;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class SimpleAnalyzerTest {

    private SimpleAnalyzer analyzer;

    @Before
    public void setup() {
        analyzer = new SimpleAnalyzer();
    }

    @Test
    public void shouldCalculateProfitWhenBestBuyValueIsBeforeBestSellValue() {

        int bestBuyValue = 7;
        int bestSellValue = 18;
        int expectedProfitValue = bestSellValue - bestBuyValue;

        int[] tradeHistory = { 10, 8, 9, bestBuyValue, 9, 8, 10, 8, bestSellValue, 11, 8, 9, 10 };

        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatProfit(maxProfit, matches(expectedProfitValue), matches(bestBuyValue), matches(bestSellValue));

    }

    @Test
    public void shouldCalculateProfitWhenLowestValueIsAfterBestSellValue() {

        int lowestValue = 5;
        int bestBuyValue = 7;
        int bestSellValue = 18;
        int expectedProfitValue = bestSellValue - bestBuyValue;

        int[] tradeHistory = { 10, 8, 9, bestBuyValue, 9, 8, 10, 8, bestSellValue, lowestValue, 8, 9, 10 };

        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatProfit(maxProfit, matches(expectedProfitValue), matches(bestBuyValue), matches(bestSellValue));

    }

    @Test
    public void shouldCalculateProfitWhenHighestValueIsBeforeBestBuyValue() {

        int lowestValue = 5;
        int bestBuyValue = 6;
        int bestSellValue = 18;
        int highestValue = 19;
        int expectedProfitValue = bestSellValue - bestBuyValue;

        int[] tradeHistory = { 10, 8, highestValue, 9, bestBuyValue, 9, 8, 10, 8, bestSellValue, lowestValue, 8, 9, 10 };

        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatProfit(maxProfit, matches(expectedProfitValue), matches(bestBuyValue), matches(bestSellValue));

    }

    @Test
    public void shouldCalculateProfitWhenBestSellValueIsLast() {

        int bestBuyValue = 5;
        int bestSellValue = 18;
        int expectedProfitValue = bestSellValue - bestBuyValue;

        int[] tradeHistory = { 10, 8,  9, bestBuyValue, 9, 8, 10, 8, 6, 8, 9, 10, bestSellValue };

        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatProfit(maxProfit, matches(expectedProfitValue), matches(bestBuyValue), matches(bestSellValue));

    }

    @Test
    public void shouldCalculateProfitExcludingNegativeValue() {

        int bestBuyValue = 5;
        int bestSellValue = 18;
        int expectedProfitValue = bestSellValue - bestBuyValue;

        int[] tradeHistory = { 10, 8,  9, bestBuyValue, 9, 8, -5, 8, 6, 8, 9, 10, bestSellValue };

        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatProfit(maxProfit, matches(expectedProfitValue), matches(bestBuyValue), matches(bestSellValue));

    }

    @Test
    public void shouldFindNoProfitWhenNoGoodSellPrice() {


        int[] tradeHistory = { 10, 8, 8, 5, 4, 3, 3, 2, 1, 0, -1 };

        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatNoProfitIsFound(maxProfit);

    }

    @Test
    public void shouldFindNoProfitWhenNegativeTrading() {


        int[] tradeHistory = { -8, -6, -6, -2, -5, -5, -3, -1, 0 };

        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatNoProfitIsFound(maxProfit);

    }



    @Test(expected = IllegalArgumentException.class)
    public void shouldReportInvalidInputWhenNullData() {
        int[] tradeHistory = null;
        analyzer.getMaxProfit(tradeHistory);

    }

    @Test
    public void shouldNotFailWhenNoData() {

        int[] tradeHistory = {};
        final Profit maxProfit = analyzer.getMaxProfit(tradeHistory);

        assertThatNoProfitIsFound(maxProfit);

    }


    //TODO test for edges, no good sell price, just one price

    private void assertThatProfit(Profit maxProfit, int expectedProfitValue, int bestBuyValue, int bestSellValue) {
        assertThat("Did not get a Profit result", maxProfit, is(notNullValue()));
        assertThat("Profit does not match expected", maxProfit.getProfit(), is(expectedProfitValue));
        assertThat("Buy price does not match expected", maxProfit.getBuyPrice(), is(bestBuyValue));
        assertThat("Sell Price does not match expected", maxProfit.getSellPrice(), is(bestSellValue));
    }

    private void assertThatNoProfitIsFound(Profit maxProfit) {
        assertThat(maxProfit, is(notNullValue()));
        assertThat(maxProfit.getProfit(), is(nullValue()));
    }

    private int matches(int expectation){
        return expectation;

    }

}
