package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.repository.BondRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BondServiceTest {

    @Mock
    private BondRepo bondRepo;

    @InjectMocks
    private BondService bondService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBonds() {
        Bond bond1 = new Bond();
        Bond bond2 = new Bond();
        when(bondRepo.findAll()).thenReturn(Arrays.asList(bond1, bond2));

        List<Bond> bonds = bondService.getAllBonds();

        assertEquals(2, bonds.size());
        verify(bondRepo, times(1)).findAll();
    }

    @Test
    void testSumOfBondPrice() {
        when(bondRepo.sumOfBondPrice()).thenReturn(1000.0);

        Double sum = bondService.sumOfBondPrice();

        assertEquals(1000.0, sum);
        verify(bondRepo, times(1)).sumOfBondPrice();
    }

//    @Test
//    void testSumOfBondPriceByInstrument() {
//        when(bondRepo.sumOfBondPriceByInstrument()).thenReturn(Arrays.asList(new Object[]{1000.0, "AAPL"}));
//
//        List<Object> result = bondService.sumOfBondPriceByInstrument();
//
//        assertEquals(1, result.size());
//        verify(bondRepo, times(1)).sumOfBondPriceByInstrument();
//    }

//    @Test
//    void testGetTimeSeriesBond() {
//        when(bondRepo.getTimeSeriesBond("AAPL")).thenReturn(Arrays.asList(new Object[]{300.5, "2023-01-01"}));
//
//        List<Object> timeSeries = bondService.getTimeSeriesBond("AAPL");
//
//        assertEquals(1, timeSeries.size());
//        verify(bondRepo, times(1)).getTimeSeriesBond("AAPL");
//    }
}
