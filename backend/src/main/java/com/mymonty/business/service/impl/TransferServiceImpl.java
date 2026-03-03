package com.mymonty.business.service.impl;

import com.mymonty.business.dto.PendingTransferDto;
import com.mymonty.business.entity.enums.TransferStatus;
import com.mymonty.business.exception.ResourceNotFoundException;
import com.mymonty.business.mapper.DashboardMapper;
import com.mymonty.business.repository.PendingTransferRepository;
import com.mymonty.business.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final PendingTransferRepository pendingTransferRepository;
    private final DashboardMapper dashboardMapper;

    @Override
    @Transactional
    public PendingTransferDto updateTransferStatus(Long transferId, TransferStatus status) {
        var transfer = pendingTransferRepository.findById(transferId)
                .orElseThrow(() -> new ResourceNotFoundException("Pending transfer not found with id: " + transferId));
        transfer.setStatus(status);
        return dashboardMapper.toDto(pendingTransferRepository.save(transfer));
    }
}
