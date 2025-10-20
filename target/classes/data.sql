CREATE TABLE vendedor (
    id_vendedor   INT AUTO_INCREMENT PRIMARY KEY,
    nome_vendedor VARCHAR(255) NOT NULL
);

INSERT INTO vendedor (nome_vendedor)
VALUES ('Lucas Kenzo');
INSERT INTO vendedor (nome_vendedor)
VALUES ('Bianca Ferreira');
INSERT INTO vendedor (nome_vendedor)
VALUES ('Higor Lacerda');
INSERT INTO vendedor (nome_vendedor)
VALUES ('Lucas Messi');
INSERT INTO vendedor (nome_vendedor)
VALUES ('Patrick Ribeiro');
INSERT INTO vendedor (nome_vendedor)
VALUES ('Thiago Detoni');
INSERT INTO vendedor (nome_vendedor)
VALUES ('Gabriel Garcia');
INSERT INTO vendedor (nome_vendedor)
VALUES ('Ingrid de Freitas');

CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome_prod VARCHAR(150) NOT NULL,
    valor_unitario DECIMAL(10, 2),
    descricao VARCHAR(255)
);

CREATE TABLE venda (
    id_venda INT AUTO_INCREMENT PRIMARY KEY,
    vendedor_id INT NOT NULL,
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    valor_total_venda DECIMAL(10, 2),

    FOREIGN KEY (vendedor_id) REFERENCES vendedor (id_vendedor)
);

-- Tabela intermediária (torna dinâmico os itens vendidos)
CREATE TABLE item_venda (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    venda_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    preco_venda DECIMAL(10, 2) NOT NULL,

    -- Restrição que garante q um produto só pode ser vendido uma vez por transação
    UNIQUE (venda_id, produto_id),

    FOREIGN KEY (venda_id) REFERENCES venda (id_venda),
    FOREIGN KEY (produto_id) REFERENCES produto (id_produto)
);

-- PRODUTOS
INSERT INTO produto (nome_prod, valor_unitario, descricao)
VALUES ('Smartphone Sansung Pro 14', 5299.99, 'Telefone de última geração com tela OLED e 256GB.');
INSERT INTO produto (nome_prod, valor_unitario, descricao)
VALUES ('AppleWatch', 4000.50, 'Relógio inteligente para monitoramento de saúde e exercícios.');
INSERT INTO produto (nome_prod, valor_unitario, descricao)
VALUES ('Notebook Gamer XZ', 8490.00, 'Laptop de alta performance com placa de vídeo dedicada.');
INSERT INTO produto (nome_prod, valor_unitario, descricao)
VALUES ('Tablet Lite 10"', 1499.00, 'Tablet leve e rápido para estudos e entretenimento.');
INSERT INTO produto (nome_prod, valor_unitario, descricao)
VALUES ('Caixa de Som JBL', 2550.00, 'Caixa de som Bluetooth com bateria de longa duração e som potente.');
INSERT INTO produto (nome_prod, valor_unitario, descricao)
VALUES ('Webcam Logitech c920 Full HD', 210.35, 'Câmera para videoconferência com alta resolução 1080p.');


-- VENDAS
INSERT INTO venda (vendedor_id, valor_total_venda)
VALUES (1, 5849.99);
INSERT INTO venda (vendedor_id, valor_total_venda)
VALUES (2, 8001.00);
INSERT INTO venda (vendedor_id, valor_total_venda)
VALUES (8, 16980.00);
INSERT INTO venda (vendedor_id, valor_total_venda)
VALUES (4, 1499.00);
INSERT INTO venda (vendedor_id, valor_total_venda)
VALUES (7, 631.05);

-- Venda 1: 1 Smartphone + 1 Caixa de Som
INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_venda)
VALUES (1, 1, 1, 5299.99);
INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_venda)
VALUES (1, 5, 1, 550.00);

-- Venda 2: 2 AppleWatchs
INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_venda)
VALUES (2, 2, 2, 4000.50);

-- Venda 3: 2 Notebooks Gamer
INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_venda)
VALUES (3, 3, 2, 8490.00);

-- Venda 4: 1 Tablet
INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_venda)
VALUES (4, 4, 1, 1499.00);

-- Venda 5: 3 Webcams
INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_venda)
VALUES (5, 6, 3, 210.35);

SELECT * FROM INFORMATION_SCHEMA.TABLES;