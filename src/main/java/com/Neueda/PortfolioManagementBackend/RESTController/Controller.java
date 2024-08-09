package com.Neueda.PortfolioManagementBackend.RESTController;

import com.Neueda.PortfolioManagementBackend.model.*;
import com.Neueda.PortfolioManagementBackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
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
}

