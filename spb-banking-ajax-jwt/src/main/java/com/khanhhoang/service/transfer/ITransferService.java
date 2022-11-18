package com.khanhhoang.service.transfer;

import com.khanhhoang.model.Transfer;
import com.khanhhoang.model.dto.TransferHistoryDTO;
import com.khanhhoang.service.IGeneralService;

import java.math.BigDecimal;
import java.util.List;

public interface ITransferService extends IGeneralService<Transfer> {
    List<TransferHistoryDTO> getAllHistories();

    BigDecimal getSumFeesAmount();
}
