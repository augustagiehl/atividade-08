package com.bomgosto.comanda;

import com.bomgosto.comanda.dto.ComandaItemDetail;
import com.bomgosto.comanda.dto.ComandaTotal;
import com.bomgosto.faturamento.FaturamentoDiario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comandas")
public class ComandaController {

    private final ComandaRepository repository;

    public ComandaController(ComandaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/itens")
    public List<ComandaItemDetail> listarComandasComItens() {
        return repository.listarComandasComItens();
    }

    @GetMapping("/totais")
    public List<ComandaTotal> listarTotaisPorComanda() {
        return repository.listarTotaisPorComanda();
    }

    @GetMapping("/totais/multiplos-cafes")
    public List<ComandaTotal> listarTotaisComMaisDeUmCafe() {
        return repository.listarTotaisComMaisDeUmCafe();
    }

    @GetMapping("/faturamento-diario")
    public List<FaturamentoDiario> calcularFaturamentoDiario() {
        return repository.calcularFaturamentoDiario();
    }
}
