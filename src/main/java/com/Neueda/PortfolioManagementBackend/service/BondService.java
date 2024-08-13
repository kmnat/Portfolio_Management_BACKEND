package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.repository.BondRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BondService {
    @Autowired
    private BondRepo bondrepo;



    public Double sumOfBondPrice()
    {
        return bondrepo.sumOfBondPrice();
    }

    public List<Object> sumOfBondPriceByInstrument()
    {
        return bondrepo.sumOfBondPriceByInstrument();
    }

    public Map<String, List<?>> getTimeSeriesBond(String id)
    {

        return convertToMap(bondrepo.getTimeSeriesBond(id));
    }


    public List<Bond> getAllBonds(Date d)
    {
        return bondrepo.findByIdTradeDate(d);
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

