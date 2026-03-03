package com.mymonty.business.service;

import com.mymonty.business.dto.PendingTransferDto;
import com.mymonty.business.entity.enums.TransferStatus;

public interface TransferService {
    PendingTransferDto updateTransferStatus(Long transferId, TransferStatus status);
}
