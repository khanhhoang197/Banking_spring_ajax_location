package com.khanhhoang.controller;

import com.khanhhoang.model.Transfer;
import com.khanhhoang.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/transfers")
public class TransferController {
    @Autowired
    private ITransferService transferService;

    @GetMapping
    public ModelAndView showListHistory() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/list");

        List<Transfer> transfers = transferService.findAll();

        BigDecimal getAllFeesAmount = transferService.getSumFeesAmount();

        modelAndView.addObject("transfers", transfers);
        modelAndView.addObject("allFeesAmount", getAllFeesAmount);

        return modelAndView;
    }
}