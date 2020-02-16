package org.any.stock.analyzer.contract;

import org.any.stock.analyzer.model.Profit;

public interface Analyzer {


    Profit getMaxProfit(Long[] tradeHistory);


}
