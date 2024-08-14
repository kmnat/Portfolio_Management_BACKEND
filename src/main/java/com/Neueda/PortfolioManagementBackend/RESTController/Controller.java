package com.Neueda.PortfolioManagementBackend.RESTController;

import com.Neueda.PortfolioManagementBackend.model.*;
import com.Neueda.PortfolioManagementBackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/sellStock")
    public void sellStocks(@RequestParam("quantity") Integer volume,@RequestParam("tickerSymbol") String tickerSymbol){
        orderBookStockService.sellStocks(tickerSymbol,volume);
    }

    @PostMapping("/buyStock")
    public void buyStocks(@RequestParam("quantity") Integer volume,@RequestParam("tickerSymbol") String tickerSymbol){
        orderBookStockService.buyStocks(tickerSymbol,volume);
    }

    @PostMapping("/buyBond")
    public void buyBond(@RequestParam("quantity") Integer volume,@RequestParam("tickerSymbol") String tickerSymbol){
        orderBookBondService.buyBonds(tickerSymbol,volume);
    }
    @GetMapping("/bonds")
    public List<Bond> getAllBonds()
    {

        Date d=java.sql.Date.valueOf(LocalDate.now());
        return bondService.getAllBonds(d);
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks()
    {
        Date d=java.sql.Date.valueOf(LocalDate.now());

        return stockService.getAllStocks(d);
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

    @GetMapping("/unrealised_pnl/{id}")
    public Double getUnrealisedPnl(@PathVariable String id){ return orderBookStockService.getCurrentPrice(id, Date.valueOf(LocalDate.now())); }

    //5.2
    @GetMapping("/bond_price_sum_instr")
    public Map<String, List<?>> getBondPriceSumByInstrument(){ return bondService.sumOfBondPriceByInstrument(); }

    @GetMapping("/stock_price_sum_instr")
    public  Map<String, List<?>> getStockPriceSumByInstrument(){ return stockService.sumOfStockPriceByInstrument(); }

    //5.3
    @GetMapping("/timeseries/bond/{id}")
    public Map<String, List<?>> getTimeSeriesBond(@PathVariable String id){
        return bondService.getTimeSeriesBond(id);
    }

    @GetMapping("/timeseries/stock/{id}")
    public Map<String, List<?>> getTimeSeriesStock(@PathVariable String id){

        return stockService.getTimeSeriesStock(id);

    }

    //5.4
    @GetMapping("/cashflow_pnl")
    public Map<String, List<?>> getPnlCashflow(){ return cashService.pnlCashFlow();}

    //5.5
    @GetMapping("/cashflow_pnl_all")
    public Map<String, List<?>> getAllPnlCashflow(){ return cashService.getAllPnlCashFlow();}



}

