INSERT INTO empresa (razao_social, nome_fantasia, cnpj, endereco, bairro, cidade, uf, cep)
  VALUES ('MARKUS DO C SOUZA ME', 'MKS TECNOLOGIA', '20.828.917/0001-96', 'QUADRA 101 LT 6 BL B AP 810', 'ÁGUAS CLARAS', 'BRASÍLIA', 'DF', '71907-180');

INSERT INTO cliente (razao_social, nome_fantasia, cnpj, endereco, bairro, cidade, uf, cep, centro_de_custo, situacao, nome_wifi, empresa_id)
  VALUES ('VITOR E LARA LIMPEZA ME', 'VILA LIMPEZA', '46.738.344/0001-01', 'QNN 30 ÁREA ESPECIAL G LOTE 480', 'CEILÂNDIA SUL', 'BRASÍLIA', 'DF', '72220-307', 'LPI001',  'ATIVO', 'VILA546', 1);

INSERT INTO banheiro (nome, localizacao, quantidade_boxes, limitador_limpeza, codigo_sensor, cliente_id)
  VALUES ('TANF', 'TÉRREO ALA NORTE', 3, 20, '123456', 1);

INSERT INTO funcao (descricao, situacao)
  VALUES ('ENCARREGADO', 'ATIVO');

INSERT INTO escala_trabalho (descricao, situacao)
  VALUES ('8X1', 'ATIVO');

INSERT INTO funcionario (nome, primeiro_nome, ultimo_nome, matricula, telegram_chat_id, situacao, funcao_id, cliente_id, escala_trabalho_id)
  VALUES ('MARKUS SOUZA', 'Markus', 'Souza', 'VLL001', 350976028, 'ATIVO', 1, 1, 1);
  
INSERT INTO funcionario (nome, primeiro_nome, ultimo_nome, matricula, telegram_chat_id, situacao, funcao_id, cliente_id, escala_trabalho_id)
  VALUES ('LUCIANO MAEDA', 'Luciano', 'Maeda', 'VLL001', 462491517, 'ATIVO', 1, 1, 1);

