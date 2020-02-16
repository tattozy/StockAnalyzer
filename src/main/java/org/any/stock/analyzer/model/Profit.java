package org.any.stock.analyzer.model;

/**
 * Encapsulates the values that make up a profit by storing buy and sell values
 * <p>
 * Should be using another data type for stock values in real life will most probably have decimal points,
 * however it uses int as challenge mention price in dollars not cents
 * <p>
 *
 * Used Integer as profit could be 0, if not difference is found between buy and sell price and could be null if not trading data is found.
 */
public class Profit {

    private Integer profit;
    private Integer buyPrice;
    private Integer sellPrice;

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }
}
