package org.any.stock.analyzer.model;

import java.util.Date;

public class Profit {

    private Date tradingDate;
    private Long profit;
    private Long buyPrice;
    private Date buyTime;
    private Long sellPrice;
    private Date sellTime;

    public Date getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(Date tradingDate) {
        this.tradingDate = tradingDate;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public Long getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Long buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }
}
