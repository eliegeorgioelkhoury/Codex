package com.mymonty.business.dto;

import com.mymonty.business.entity.enums.ExpenseCategoryType;

import java.math.BigDecimal;

public record ExpenseDto(
        ExpenseCategoryType category,
        BigDecimal amount
) {
}
