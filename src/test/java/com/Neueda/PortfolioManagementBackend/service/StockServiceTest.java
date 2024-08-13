package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Stock;
import com.Neueda.PortfolioManagementBackend.repository.StockRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StockServiceTest {

    @Mock
    private StockRepo stockRepo;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStocks() {
        Stock stock1 = new Stock();
        Stock stock2 = new Stock();
        List<Stock> mockStockList = Arrays.asList(stock1, stock2);

        when(stockRepo.findAll()).thenReturn(mockStockList);

        List<Stock> result = stockService.getAllStocks();

        assertEquals(2, result.size());
        verify(stockRepo, times(1)).findAll();
    }

    @Test
    void testSumOfStockPrice() {
        when(stockRepo.sumOfStockPrice()).thenReturn(10000.0);

        Double result = stockService.sumOfStockPrice();

        assertEquals(10000.0, result);
        verify(stockRepo, times(1)).sumOfStockPrice();
    }

    @Test
    void testSumOfStockPriceByInstrument() {
        List<Object> mockList = Arrays.asList(new Object(), new Object());

        when(stockRepo.sumOfStockPriceByInstrument()).thenReturn(mockList);

        List<Object> result = stockService.sumOfStockPriceByInstrument();

        assertEquals(2, result.size());
        verify(stockRepo, times(1)).sumOfStockPriceByInstrument();
    }

    @Test
    void testGetTimeSeriesStock() {
        String id = "AAPL";
        List<Object> mockList = Arrays.asList(new Object(), new Object());

        when(stockRepo.getTimeSeriesStock(id)).thenReturn(mockList);

        List<Object> result = stockService.getTimeSeriesStock(id);

        assertEquals(2, result.size());
        verify(stockRepo, times(1)).getTimeSeriesStock(id);
    }
}
