package com.Neueda.PortfolioManagementBackend.rest;

import com.Neueda.PortfolioManagementBackend.RESTController.Controller;
import com.Neueda.PortfolioManagementBackend.model.*;
import com.Neueda.PortfolioManagementBackend.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CashflowService cashflowService;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetCashflow() throws Exception {
        CashflowBook cashflow1 = new CashflowBook();
        CashflowBook cashflow2 = new CashflowBook();
        List<CashflowBook> mockCashflowList = Arrays.asList(cashflow1, cashflow2);

        when(cashflowService.getCashflowBook()).thenReturn(mockCashflowList);

        mockMvc.perform(get("/assets/cashflow")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }

//    @Test
//    void testGetPnlCashflow() throws Exception {
//        List<Object> mockList = Arrays.asList(new Object(), new Object());
//
//        when(cashflowService.pnlCashFlow()).thenReturn(mockList);
//
//        mockMvc.perform(get("/assets/cashflow_pnl")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{},{}]"));
//    }
//
//
//    @Test
//    void testGetAllPnlCashflow() throws Exception {
//        List<Object> mockList = Arrays.asList(new Object(), new Object());
//
//        when(cashflowService.getAllPnlCashFlow()).thenReturn(mockList);
//
//        mockMvc.perform(get("/assets/cashflow_pnl_all")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
}
