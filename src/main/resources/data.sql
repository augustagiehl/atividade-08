INSERT INTO cardapio (nome, descricao, preco_unitario) VALUES
    ('Espresso', 'Café espresso tradicional', 5.00),
    ('Cappuccino', 'Espresso com leite vaporizado e espuma', 8.50),
    ('Latte', 'Espresso com leite vaporizado suave', 7.50),
    ('Mocha', 'Espresso com chocolate e leite vaporizado', 9.00);

INSERT INTO comanda (data, mesa, nome_cliente) VALUES
    ('2024-04-01', 1, 'Ana Silva'),
    ('2024-04-01', 2, 'Bruno Costa'),
    ('2024-04-02', 3, 'Carla Souza'),
    ('2024-04-03', 1, 'Daniel Lima');

INSERT INTO comanda_item (comanda_id, cardapio_id, quantidade) VALUES
    (1, 1, 2),
    (1, 2, 1),
    (2, 3, 1),
    (2, 4, 1),
    (3, 2, 2),
    (4, 1, 1);
