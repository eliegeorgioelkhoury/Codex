package com.mymonty.business.service.impl;

import com.mymonty.business.dto.DashboardResponseDto;
import com.mymonty.business.mapper.DashboardMapper;
import com.mymonty.business.repository.ExpenseItemRepository;
import com.mymonty.business.repository.PendingTransferRepository;
import com.mymonty.business.repository.TransactionRecordRepository;
import com.mymonty.business.repository.WalletRepository;
import com.mymonty.business.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final WalletRepository walletRepository;
    private final ExpenseItemRepository expenseItemRepository;
    private final PendingTransferRepository pendingTransferRepository;
    private final TransactionRecordRepository transactionRecordRepository;
    private final DashboardMapper dashboardMapper;

    @Override
    public DashboardResponseDto getDashboard() {
        var wallets = walletRepository.findAll().stream().map(dashboardMapper::toDto).toList();
        var expenses = expenseItemRepository.findAll().stream().map(dashboardMapper::toDto).toList();
        var pendingTransfers = pendingTransferRepository.findAll().stream().map(dashboardMapper::toDto).toList();
        var transactions = transactionRecordRepository.findAll().stream().map(dashboardMapper::toDto).toList();

        var totalAmount = wallets.stream().map(wallet -> wallet.balance()).reduce(BigDecimal.ZERO, BigDecimal::add);

        return new DashboardResponseDto(totalAmount, wallets, expenses, pendingTransfers, transactions);
    }
}
