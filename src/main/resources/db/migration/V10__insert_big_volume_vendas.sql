
-- Insere vendas aleatórias no período de 01/10/2025 a 23/10/2025 (23 dias).

-- VENDEDOR 1: Lucas Kenzo (5 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 1, DATEADD('DAY', FLOOR(RAND() * 10), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 5);

-- VENDEDOR 2: Bianca Ferreira (7 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 2, DATEADD('DAY', FLOOR(RAND() * 9), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 7);

-- VENDEDOR 7: Gabriel Garcia (16 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 7, DATEADD('DAY', FLOOR(RAND() * 18), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 16);

-- VENDEDOR 8: Ingrid de Freitas (17 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 8, DATEADD('DAY', FLOOR(RAND() * 22), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 17);

-- VENDEDOR 3: Higor Lacerda (3 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 3, DATEADD('DAY', FLOOR(RAND() * 3), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 3);

-- VENDEDOR 4: Lucas Messi (18 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 4, DATEADD('DAY', FLOOR(RAND() * 19), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 18);

-- VENDEDOR 5: Patrick Ribeiro (12 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 5, DATEADD('DAY', FLOOR(RAND() * 11), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 12);

-- VENDEDOR 6: Thiago Detoni (19 Vendas)
INSERT INTO venda (fk_vendedor, data_venda, valor_total_venda)
SELECT 6, DATEADD('DAY', FLOOR(RAND() * 23), DATE '2025-10-01'), (RAND() * 2000) + 100.0
FROM SYSTEM_RANGE(1, 19);