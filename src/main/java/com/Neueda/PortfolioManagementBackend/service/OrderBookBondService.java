package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.model.OrderBookBond;
import com.Neueda.PortfolioManagementBackend.model.Stock;
import com.Neueda.PortfolioManagementBackend.model.TradeBook;
import com.Neueda.PortfolioManagementBackend.repository.BondRepo;
import com.Neueda.PortfolioManagementBackend.repository.OrderBookBondRepo;
import com.Neueda.PortfolioManagementBackend.repository.TradeBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderBookBondService {

    public OrderBookBondService(){

    }

    @Autowired
    private OrderBookBondRepo orderBookBondRepo;

    @Autowired
    BondRepo bondrepo;

    @Autowired
    private TradeBookRepo tradeBookRepo;



   /* public List<OrderBookBond> getBondByTickerSymbol(String id)
    {
        return orderBookBondRepo.findByBond_Id_TickerSymbol(id);
    }*/


    public Bond getBondDetails(String tickerSymbol, Date tradeDate) {
        Bond bond = bondrepo.findById_TickerSymbolAndId_TradeDate(tickerSymbol, tradeDate);
        return bond ;
    }

    public List<OrderBookBond> getOrderBookBonds() { return orderBookBondRepo.findAll(); }

    public List<OrderBookBond> getOrderbondDetails(String tickerSymbol, Date tradeDate) {
        return orderBookBondRepo.findByBond_Id_TickerSymbolAndBond_Id_TradeDate(tickerSymbol,tradeDate);

    }


    public void buyBonds(String ticker_symbol, int volume){

        Bond b =getBondDetails(ticker_symbol,java.sql.Date.valueOf(LocalDate.now()));
        List<OrderBookBond> orders=getOrderbondDetails(ticker_symbol,java.sql.Date.valueOf(LocalDate.now()));
        //System.out.println(orders.get(0));
        if(orders.isEmpty()) {
            System.out.println("inside if");
            OrderBookBond o = new OrderBookBond();
            o.setBond_price(b.getBondPrice());
            o.setAsset_name(b.getIssuer());
            o.setMaturityAmount(b.getMaturityAmount());
            o.setMaturityDate(b.getMaturityDate());
            o.setBond(b);
            o.setQuantity(1);
            orderBookBondRepo.save(o);

        }

       else {
            System.out.println("inside else");
            OrderBookBond o1=orders.get(0);
            int q=o1.getQuantity()+volume;
            o1.setQuantity(q);
            o1.setMaturityAmount(o1.getMaturityAmount()+(b.getMaturityAmount()*volume));
            o1.setBond_price(o1.getBond_price()+(b.getBondPrice()*volume));

            orderBookBondRepo.save(o1);
        }

        TradeBook trade = new TradeBook();
        trade.setTicker_symbol(ticker_symbol);
        trade.setAmount(b.getBondPrice());
        trade.setAction("Buy");
        trade.setCategory("Bond");
        trade.setDate(Date.valueOf(LocalDate.now()));
        trade.setVolume(volume);
        trade.setAsset_name(b.getIssuer());
        tradeBookRepo.save(trade);
    }
}