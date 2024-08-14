package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Stock;
import com.Neueda.PortfolioManagementBackend.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    private StockRepo stockrepo;

    public List<Stock> getAllStocks(Date d)
    {

        return stockrepo.findByIdTradeDate(d);

    }

    public Double sumOfStockPrice()
    {
        return stockrepo.sumOfStockPrice();
    }

    public Map<String, List<?>> sumOfStockPriceByInstrument()
    {
        return convertToMapSum(stockrepo.sumOfStockPriceByInstrument());
    }

    public Map<String, List<?>> convertToMapSum(List<Object> stockData) {
        List<Double> prices = stockData.stream()
                .map(data -> (Double) ((Object[]) data)[0])
                .collect(Collectors.toList());

        List<String> names = stockData.stream()
                .map(data -> ((String) ((Object[]) data)[1]).toLowerCase().replace("bond", "bond "))
                .collect(Collectors.toList());

        return Map.of(
                "price", prices,
                "name", names
        );
    }


    public Map<String, List<?>> getTimeSeriesStock(String id)
    {
        return convertToMap(stockrepo.getTimeSeriesStock(id));
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Map<String, List<?>> convertToMap(List<Object> stockData) {
        List<Double> prices = stockData.stream()
                .map(data -> (Double) ((Object[]) data)[0])
                .collect(Collectors.toList());

        List<String> dates = stockData.stream()
                .map(data -> dateFormat.format((Date) ((Object[]) data)[1]))
                .collect(Collectors.toList());

        return Map.of(
                "dates", dates,
                "prices", prices
        );
    }


}