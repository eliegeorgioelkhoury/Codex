package com.mymonty.business.controller;

import com.mymonty.business.dto.PendingTransferDto;
import com.mymonty.business.entity.enums.TransferStatus;
import com.mymonty.business.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PatchMapping("/{id}/status")
    public PendingTransferDto updateStatus(@PathVariable("id") Long transferId, @RequestBody UpdateTransferStatusRequest request) {
        return transferService.updateTransferStatus(transferId, request.status());
    }

    public record UpdateTransferStatusRequest(TransferStatus status) {
    }
}
