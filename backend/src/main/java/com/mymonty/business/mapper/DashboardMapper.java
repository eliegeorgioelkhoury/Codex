package com.mymonty.business.mapper;

import com.mymonty.business.dto.ExpenseDto;
import com.mymonty.business.dto.PendingTransferDto;
import com.mymonty.business.dto.TransactionDto;
import com.mymonty.business.dto.WalletDto;
import com.mymonty.business.entity.ExpenseItem;
import com.mymonty.business.entity.PendingTransfer;
import com.mymonty.business.entity.TransactionRecord;
import com.mymonty.business.entity.Wallet;
import org.springframework.stereotype.Component;

@Component
public class DashboardMapper {

    public WalletDto toDto(Wallet wallet) {
        return new WalletDto(wallet.getName(), wallet.getCurrency(), wallet.getBalance(), wallet.getFlagEmoji());
    }

    public ExpenseDto toDto(ExpenseItem expenseItem) {
        return new ExpenseDto(expenseItem.getCategory(), expenseItem.getAmount());
    }

    public PendingTransferDto toDto(PendingTransfer pendingTransfer) {
        return new PendingTransferDto(
                pendingTransfer.getId(),
                pendingTransfer.getTransferDate(),
                pendingTransfer.getTransferType(),
                pendingTransfer.getCounterpart(),
                pendingTransfer.getAmount(),
                pendingTransfer.getStatus()
        );
    }

    public TransactionDto toDto(TransactionRecord transactionRecord) {
        return new TransactionDto(
                transactionRecord.getId(),
                transactionRecord.getTransactionDate(),
                transactionRecord.getSourceWallet(),
                transactionRecord.getDestination(),
                transactionRecord.getStatus(),
                transactionRecord.getAmount(),
                transactionRecord.getFees()
        );
    }
}
