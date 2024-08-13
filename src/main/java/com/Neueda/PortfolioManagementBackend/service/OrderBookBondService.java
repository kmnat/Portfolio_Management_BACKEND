package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.model.OrderBookBond;
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

    public List<OrderBookBond> getOrderBookBonds() { return orderBookBondRepo.findAll(); }



    @Autowired
    BondRepo bondrepo;

    @Autowired
    private TradeBookRepo tradeBookRepo;



    public List<OrderBookBond> getBondByTickerSymbol(String id)
    {
        return orderBookBondRepo.findByBond_Id_TickerSymbol(id);
    }


    public Bond getbondDetails(String tickerSymbol, Date tradeDate) {
        Bond bond = bondrepo.findById_TickerSymbolAndId_TradeDate(tickerSymbol, tradeDate);
        return  bond ;
    }


    public void buyBonds(String ticker_symbol, int volume){



        String asset_name;

        Bond b =getbondDetails(ticker_symbol,java.sql.Date.valueOf(LocalDate.now()));
        OrderBookBond o = new OrderBookBond();
        o.setBond_price(b.getBondPrice());
        o.setAsset_name(b.getIssuer());
        o.setMaturityAmount(b.getMaturityAmount());
        o.setMaturityDate(b.getMaturityDate());
        o.setBond(b);
        orderBookBondRepo.save(o);


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