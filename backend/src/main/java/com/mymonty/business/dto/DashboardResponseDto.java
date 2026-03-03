package com.mymonty.business.dto;

import java.math.BigDecimal;
import java.util.List;

public record DashboardResponseDto(
        BigDecimal totalAvailableAmount,
        List<WalletDto> wallets,
        List<ExpenseDto> expenses,
        List<PendingTransferDto> pendingTransfers,
        List<TransactionDto> transactions
) {
}
