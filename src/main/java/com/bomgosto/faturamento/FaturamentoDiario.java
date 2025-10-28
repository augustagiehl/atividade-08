package com.bomgosto.faturamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FaturamentoDiario(
        LocalDate data,
        BigDecimal valorTotal
) {
}
