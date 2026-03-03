package com.mymonty.business.dto;

import com.mymonty.business.entity.enums.PendingTransferType;
import com.mymonty.business.entity.enums.TransferStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PendingTransferDto(
        Long id,
        LocalDate transferDate,
        PendingTransferType transferType,
        String counterpart,
        BigDecimal amount,
        TransferStatus status
) {
}
