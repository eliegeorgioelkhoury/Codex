package com.mymonty.business.repository;

import com.mymonty.business.entity.PendingTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingTransferRepository extends JpaRepository<PendingTransfer, Long> {
}
