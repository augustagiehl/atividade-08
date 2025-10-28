package com.bomgosto.cardapio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cardapio")
public class CardapioController {

    private final MenuItemRepository repository;

    public CardapioController(MenuItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MenuItem> listarOrdenadoPorNome() {
        return repository.findAllByOrderByNomeAsc();
    }
}
