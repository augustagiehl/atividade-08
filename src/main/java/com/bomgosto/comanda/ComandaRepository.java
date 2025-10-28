package com.bomgosto.comanda;

import com.bomgosto.comanda.dto.ComandaItemDetail;
import com.bomgosto.comanda.dto.ComandaTotal;
import com.bomgosto.faturamento.FaturamentoDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {

    @Query("""
            SELECT new com.bomgosto.comanda.dto.ComandaItemDetail(
                c.id,
                c.data,
                c.mesa,
                c.nomeCliente,
                m.nome,
                m.descricao,
                ci.quantidade,
                m.precoUnitario,
                m.precoUnitario * ci.quantidade
            )
            FROM Comanda c
            JOIN c.itens ci
            JOIN ci.cardapio m
            ORDER BY c.data, c.id, m.nome
            """)
    List<ComandaItemDetail> listarComandasComItens();

    @Query("""
            SELECT new com.bomgosto.comanda.dto.ComandaTotal(
                c.id,
                c.data,
                c.mesa,
                c.nomeCliente,
                SUM(m.precoUnitario * ci.quantidade)
            )
            FROM Comanda c
            JOIN c.itens ci
            JOIN ci.cardapio m
            GROUP BY c.id, c.data, c.mesa, c.nomeCliente
            ORDER BY c.data, c.id
            """)
    List<ComandaTotal> listarTotaisPorComanda();

    @Query("""
            SELECT new com.bomgosto.comanda.dto.ComandaTotal(
                c.id,
                c.data,
                c.mesa,
                c.nomeCliente,
                SUM(m.precoUnitario * ci.quantidade)
            )
            FROM Comanda c
            JOIN c.itens ci
            JOIN ci.cardapio m
            GROUP BY c.id, c.data, c.mesa, c.nomeCliente
            HAVING COUNT(DISTINCT m.id) > 1
            ORDER BY c.data, c.id
            """)
    List<ComandaTotal> listarTotaisComMaisDeUmCafe();

    @Query("""
            SELECT new com.bomgosto.faturamento.FaturamentoDiario(
                c.data,
                SUM(m.precoUnitario * ci.quantidade)
            )
            FROM Comanda c
            JOIN c.itens ci
            JOIN ci.cardapio m
            GROUP BY c.data
            ORDER BY c.data
            """)
    List<FaturamentoDiario> calcularFaturamentoDiario();
}
