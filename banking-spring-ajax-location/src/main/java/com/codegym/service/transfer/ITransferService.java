package com.codegym.service.transfer;


import com.codegym.service.IGeneralService;
import com.codegym.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface ITransferService extends IGeneralService<Transfer> {

    BigDecimal getSumFeesAmount();
}