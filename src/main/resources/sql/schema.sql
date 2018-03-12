CREATE TABLE IF NOT EXISTS empresa (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  bairro varchar(150) NOT NULL,
  cep varchar(9) NOT NULL,
  cidade varchar(70) NOT NULL,
  cnpj varchar(18) NOT NULL,
  endereco varchar(100) NOT NULL,
  nome_fantasia varchar(200) NOT NULL,
  razao_social varchar(200) NOT NULL,
  uf varchar(2) NOT NULL,
  empresa_pai_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_EMPRESA_PAI (empresa_pai_id),
  CONSTRAINT FK_EMPRESA_PAI FOREIGN KEY (empresa_pai_id) REFERENCES empresa (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS cliente (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  bairro varchar(150) NOT NULL,
  cep varchar(9) NOT NULL,
  cidade varchar(70) NOT NULL,
  cnpj varchar(18) NOT NULL,
  endereco varchar(100) NOT NULL,
  nome_fantasia varchar(200) NOT NULL,
  razao_social varchar(200) NOT NULL,
  uf varchar(2) NOT NULL,
  centro_de_custo varchar(255) NOT NULL,
  nome_wifi varchar(70) NOT NULL,
  situacao varchar(7) DEFAULT NULL,
  empresa_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_EMPRESA (empresa_id),
  CONSTRAINT FK_EMPRESA FOREIGN KEY (empresa_id) REFERENCES empresa (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS banheiro (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  limitador_limpeza int(11) NOT NULL,
  localizacao varchar(70) NOT NULL,
  nome varchar(100) NOT NULL,
  quantidade_boxes int(11) NOT NULL,
  cliente_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_NOME_BANHEIRO (nome),
  KEY FK_CLIENTE (cliente_id),
  CONSTRAINT FK_CLIENTE FOREIGN KEY (cliente_id) REFERENCES cliente (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS sensor (
  banheiro_id bigint(20) NOT NULL,
  nome_wifi varchar(70) NOT NULL,
  numero varchar(10) NOT NULL,
  PRIMARY KEY (banheiro_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS escala_trabalho (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  descricao varchar(15) NOT NULL,
  situacao varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS funcao (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  descricao varchar(20) NOT NULL,
  situacao varchar(7) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id),
  UNIQUE KEY UK_DESCRICAO_FUNCAO (descricao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS papel (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  nome varchar(15) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id),
  UNIQUE KEY UK_NOME_PAPEL (nome)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS procedimento_operacional_padrao (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  documento longtext NOT NULL,
  situacao varchar(7) DEFAULT NULL,
  titulo varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS tarefa (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  nome varchar(70) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS usuario (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  login varchar(9) NOT NULL,
  senha varchar(100) NOT NULL,
  situacao varchar(7) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id),
  UNIQUE KEY UK_LOGIN (login)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
