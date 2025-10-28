package com.bomgosto.comanda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ComandaTotal(
        Long codigoComanda,
        LocalDate data,
        Integer mesa,
        String nomeCliente,
        BigDecimal valorTotal
) {
}
