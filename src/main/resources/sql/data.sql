INSERT INTO empresa (razao_social, nome_fantasia, cnpj, endereco, bairro, cidade, uf, cep)
  VALUES ('MARKUS DO C SOUZA ME', 'MKS TECNOLOGIA', '20.828.917/0001-96', 'QUADRA 101 LT 6 BL B AP 810', 'ÁGUAS CLARAS', 'BRASÍLIA', 'DF', '71907-180');

  
INSERT INTO empresa (razao_social, nome_fantasia, cnpj, endereco, bairro, cidade, uf, cep, empresa_pai_id)
  VALUES ('LORENA E CAROLINE INFORMÁTICA ME', 'L&C INFORMÁTICA', '42.618.260/0001-75', 'CL 518 BLOCO B SALA 222', 'SANTA MARIA', 'BRASÍLIA', 'DF', '72548-832', 1);

  
INSERT INTO empresa (razao_social, nome_fantasia, cnpj, endereco, bairro, cidade, uf, cep, empresa_pai_id)
  VALUES ('LARA E PIETRA INFORMÁTICA LTDA', 'LP INFORMÁRICA', '10.570.046/0001-08', 'SHIS QI 26 CONJUNTO 3 LOTE 480', 'LAGO SUL', 'BRASÍLIA', 'DF', '71670-030', 2);
  
  
INSERT INTO cliente (razao_social, nome_fantasia, cnpj, endereco, bairro, cidade, uf, cep, centro_de_custo, situacao, nome_wifi, empresa_id)
  VALUES ('VITOR E LARA LIMPEZA ME', 'VILA LIMPEZA', '46.738.344/0001-01', 'QNN 30 ÁREA ESPECIAL G LOTE 480', 'CEILÂNDIA SUL', 'BRASÍLIA', 'DF', '72220-307', 'LPI001',  'ATIVA', 'VILA546', 3);
  

INSERT INTO banheiro (nome, localizacao, quantidade_boxes, limitador_limpeza, cliente_id)
  VALUES ('BANHEIRO 1', 'TÉRREO', 3, 15, 1);
  
  
INSERT INTO sensor (numero, nome_wifi)
  VALUES ('B001', 'VILA546');
