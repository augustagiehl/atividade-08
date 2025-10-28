package com.bomgosto.comanda;

import com.bomgosto.cardapio.MenuItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comanda_item")
public class ComandaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardapio_id")
    private MenuItem cardapio;

    @Column(nullable = false)
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public MenuItem getCardapio() {
        return cardapio;
    }

    public void setCardapio(MenuItem cardapio) {
        this.cardapio = cardapio;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
