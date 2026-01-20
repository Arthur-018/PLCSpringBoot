-- V2: Migration para adcionar a coluna de empresa na tabela de plano de contas

ALTER TABLE tb_planodecontas
ADD COLUMN empresa VARCHAR(255);