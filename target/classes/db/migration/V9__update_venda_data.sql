-- Atualiza a data da Venda com ID 6 (que foi criada no teste) para simular um dia anterior (2025-10-22).
UPDATE venda
SET data_venda = '2025-10-22'
WHERE id_venda = 6;