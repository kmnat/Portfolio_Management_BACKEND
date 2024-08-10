package com.Neueda.PortfolioManagementBackend.RESTController;

import com.Neueda.PortfolioManagementBackend.model.*;
import com.Neueda.PortfolioManagementBackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("assets")
public class Controller {
    @Autowired
    private OrderBookStockService orderBookStockService;
    @Autowired
    private OrderBookBondService orderBookBondService;

    @Autowired
    private TradeBookService tradeBookService;
    @Autowired
    private StockService stockService;

    @Autowired
    private CashflowService cashService;

    @Autowired
    private BondService bondService;

    @GetMapping("/bonds")
    public List<Bond> getAllBonds()
    {
        return bondService.getAllBonds();
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks()
    {
        return stockService.getAllStocks();
    }

    @GetMapping("/cashflow")
    public List<CashflowBook> getCashflow()
    {
        return cashService.getCashflowBook();
    }

    @GetMapping("/tradeBook")
    public List<TradeBook> getTradeBook()
    {
        return tradeBookService.getTradeBook();
    }

    @GetMapping("/order_stocks")
    public List<OrderBookStock> getOrderStocks() { return  orderBookStockService.getOrderBookStocks();}


    @GetMapping("/order_bonds")
    public List<OrderBookBond> getOrderBonds() { return  orderBookBondService.getOrderBookBonds();}


    // 5.1
    @GetMapping("/bond_price_sum")
    public Double getBondPriceSum(){ return bondService.sumOfBondPrice(); }

    @GetMapping("/stock_price_sum")
    public Double getStockPriceSum(){ return stockService.sumOfStockPrice(); }

    //5.2
    @GetMapping("/bond_price_sum_instr")
    public List<Object> getBondPriceSumByInstrument(){ return bondService.sumOfBondPriceByInstrument(); }

    @GetMapping("/stock_price_sum_instr")
    public List<Object> getStockPriceSumByInstrument(){ return stockService.sumOfStockPriceByInstrument(); }

    //5.3
    @GetMapping("/timeseries/bond/{id}")
    public List<Object> getTimeSeriesBond(@PathVariable String id){ return bondService.getTimeSeriesBond(id);}

    @GetMapping("/timeseries/stock/{id}")
    public List<Object> getTimeSeriesStock(@PathVariable String id){ return stockService.getTimeSeriesStock(id);}

    //5.4
    @GetMapping("/cashflow_pnl")
    public List<Object> getPnlCashflow(){ return cashService.pnlCashFlow();}

    //5.5
    @GetMapping("/cashflow_pnl_all")
    public List<Object> getAllPnlCashflow(){ return cashService.getAllPnlCashFlow();}

}

