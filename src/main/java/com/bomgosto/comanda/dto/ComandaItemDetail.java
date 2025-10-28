package com.bomgosto.comanda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ComandaItemDetail(
        Long codigoComanda,
        LocalDate data,
        Integer mesa,
        String nomeCliente,
        String nomeCafe,
        String descricaoCafe,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal precoTotalCafe
) {
}
