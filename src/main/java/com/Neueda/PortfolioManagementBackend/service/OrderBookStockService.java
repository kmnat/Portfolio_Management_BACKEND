package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.CashflowBook;
import com.Neueda.PortfolioManagementBackend.model.OrderBookStock;
import com.Neueda.PortfolioManagementBackend.model.Stock;
import com.Neueda.PortfolioManagementBackend.model.TradeBook;
import com.Neueda.PortfolioManagementBackend.repository.CashflowRepo;
import com.Neueda.PortfolioManagementBackend.repository.OrderBookStockRepo;
import com.Neueda.PortfolioManagementBackend.repository.StockRepo;
import com.Neueda.PortfolioManagementBackend.repository.TradeBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderBookStockService {

    public OrderBookStockService(){

    }

    @Autowired
    private OrderBookStockRepo orderBookStockRepo ;
    @Autowired
    StockRepo stockrepo;
    @Autowired
    private TradeBookRepo tradeBookRepo;

    @Autowired
    CashflowRepo cashflowRepo;

    public List<OrderBookStock> getOrderBookStocks() {
        return orderBookStockRepo.findAll();
    }



    public List<OrderBookStock> getStockByTickerSymbol(String id)
    {
        return orderBookStockRepo.findByStock_Id_TickerSymbol(id);

    }


    public Double getCurrentPrice(String tickerSymbol, Date tradeDate) {
        Stock stock = stockrepo.findById_TickerSymbolAndId_TradeDate(tickerSymbol, tradeDate);
        return  stock.getCurrentPrice() ;
    }

    public Stock getstockDetails(String tickerSymbol, Date tradeDate) {
        Stock stock = stockrepo.findById_TickerSymbolAndId_TradeDate(tickerSymbol, tradeDate);
        return  stock ;
    }

    public void buyStocks(String ticker_symbol, int volume){

        List<OrderBookStock> orders = getStockByTickerSymbol(ticker_symbol);

        String asset_name;
        double current_price=getCurrentPrice(ticker_symbol,Date.valueOf(LocalDate.now()));
        if (!orders.isEmpty()) {
            OrderBookStock order = orders.get(0);
            asset_name=order.getAsset_name();
            int newQuantity = (order.getVolume() + volume);
            double newAveragePrice = ((order.getBought_price()*order.getVolume() ) + (current_price * volume))/newQuantity;
            order.setBought_price(newAveragePrice);
            order.setVolume(newQuantity);
            orderBookStockRepo.save(order);
        }

        else{
            Stock s= getstockDetails(ticker_symbol,Date.valueOf(LocalDate.now()));
            asset_name=s.getCompanyName();
            OrderBookStock o = new OrderBookStock();
            o.setVolume(volume);
            o.setBought_price(current_price);
            o.setAsset_name(s.getCompanyName());
            o.setStock(s);
            orderBookStockRepo.save(o);
        }

        TradeBook trade = new TradeBook();
        trade.setTicker_symbol(ticker_symbol);
        trade.setAmount(current_price*volume);
        trade.setAction("Buy");
        trade.setCategory("Stock");
        trade.setDate(Date.valueOf(LocalDate.now()));
        trade.setVolume(volume);
        trade.setAsset_name(asset_name);
        tradeBookRepo.save(trade);

    }

    public void sellStocks(String ticker_symbol, int volume){

        List<OrderBookStock> orders = getStockByTickerSymbol(ticker_symbol);
        System.out.println(orders.get(0));

        if (!orders.isEmpty()) {
            OrderBookStock order = orders.get(0);
            int vol = order.getVolume();
            System.out.println("1 "+vol);
            double price = order.getBought_price();
            Date date=order.getStock().getId().getTradeDate();
            Double currentPrice = getCurrentPrice(ticker_symbol, date);

            if(volume<vol){
                order.setVolume(vol-volume);
                orderBookStockRepo.save(order);
                TradeBook trade = new TradeBook();
                trade.setTicker_symbol(ticker_symbol);
                System.out.println("3 "+(((double)order.getBought_price())/ vol)*volume);
                trade.setAmount(price*volume);
                trade.setAction("Sell");
                trade.setCategory("Stock");
                trade.setDate(Date.valueOf(LocalDate.now()));
                trade.setVolume(volume);
                trade.setAsset_name(order.getAsset_name());

                tradeBookRepo.save(trade);


                CashflowBook cashflowBook=new CashflowBook();
                cashflowBook.setAsset_name(order.getAsset_name());
                cashflowBook.setDate(Date.valueOf(LocalDate.now()));
                cashflowBook.setRealized_pnl((currentPrice-price)*volume);
                cashflowBook.setUnrealized_pnl(0);
                cashflowBook.setTicker_symbol(ticker_symbol);
                cashflowRepo.save(cashflowBook);

            }

            else if(vol==volume){

                orderBookStockRepo.delete(order);
                TradeBook trade = new TradeBook();
                trade.setTicker_symbol(ticker_symbol);
                trade.setAmount((price)*volume);
                trade.setAction("Sell");
                trade.setCategory("Stock");
                trade.setDate(date);
                trade.setVolume(volume);
                trade.setAsset_name(order.getAsset_name());
                tradeBookRepo.save(trade);

                CashflowBook cashflowBook=new CashflowBook();
                cashflowBook.setAsset_name(order.getAsset_name());
                cashflowBook.setDate(Date.valueOf(LocalDate.now()));
                cashflowBook.setRealized_pnl((currentPrice-price)*volume);
                cashflowBook.setUnrealized_pnl(0);
                cashflowBook.setTicker_symbol(ticker_symbol);
                cashflowRepo.save(cashflowBook);

            }



        }
    }


}