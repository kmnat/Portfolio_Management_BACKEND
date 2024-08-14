package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.model.CashflowBook;
import com.Neueda.PortfolioManagementBackend.repository.CashflowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CashflowService {

    @Autowired
    private CashflowRepo cashflowRepo;

    public List<CashflowBook> getCashflowBook()
    {
        return cashflowRepo.findAll();
    }

    public Map<String, List<?>> pnlCashFlow()

    {
        return convertToMapSum(cashflowRepo.pnlCashFlow());
    }

    public Map<String, List<?>> convertToMapSum(List<Object> cashData) {
        List<Double> prices = cashData.stream()
                .map(data -> (Double) ((Object[]) data)[0])
                .collect(Collectors.toList());

        List<String> names = cashData.stream()
                .map(data -> ((String) ((Object[]) data)[1]).toLowerCase())
                .collect(Collectors.toList());

        return Map.of(
                "pnl", prices,
                "name", names
        );
    }

    public Map<String, List<?>> getAllPnlCashFlow(){ return convertToMapAll(cashflowRepo.allPnlCashFlow()); }

    public Map<String, List<?>> convertToMapAll(List<Object> cashData) {
        // Extract the first Double value from each Object[] as "price"
        List<Double> prices = cashData.stream()
                .map(data -> (Double) ((Object[]) data)[0])
                .collect(Collectors.toList());

        // Extract the second Double value from each Object[] as "value1"
        List<Double> values1 = cashData.stream()
                .map(data -> (Double) ((Object[]) data)[1])
                .collect(Collectors.toList());

        // Extract the third Double value from each Object[] as "value2"
        List<Double> values2 = cashData.stream()
                .map(data -> (Double) ((Object[]) data)[2])
                .collect(Collectors.toList());
        List<String> names = cashData.stream()
                .map(data -> ((String) ((Object[]) data)[3]).toLowerCase())
                .collect(Collectors.toList());

        // Return a map with the three lists
        return Map.of(
                "re_pnl", prices,
                "un_pnl", values1,
                "net_pnl", values2,
                "name",names
        );
    }
}

