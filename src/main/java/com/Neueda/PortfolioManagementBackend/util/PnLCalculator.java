package com.Neueda.PortfolioManagementBackend.util;

public class PnLCalculator {
    public static double calculatePnL(double buyPrice, double sellPrice, int volume){
        return (sellPrice-buyPrice)*volume;
    }
}
