package com.mymonty.business.dto;

import com.mymonty.business.entity.enums.CurrencyCode;

import java.math.BigDecimal;

public record WalletDto(
        String name,
        CurrencyCode currency,
        BigDecimal balance,
        String flagEmoji
) {
}
