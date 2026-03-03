package com.mymonty.business.dto;

import com.mymonty.business.entity.enums.TransferStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDto(
        Long id,
        LocalDate transactionDate,
        String sourceWallet,
        String destination,
        TransferStatus status,
        BigDecimal amount,
        BigDecimal fees
) {
}
