INSERT INTO Categoria (id, tipo) VALUES ('P', 'Produto');
INSERT INTO Categoria (id, tipo) VALUES ('F', 'Ferramenta');
INSERT INTO Categoria (id, tipo) VALUES ('M', 'Material');

INSERT INTO `Produto` (`codigoInterno`, `codigoExterno`, `descricao`, `nome`, `unidade`, `categoria_id`) VALUES (1, 'cod001', 'Coca-Cola lata 350ml', 'Coca Lata', 'unit', 'P');
INSERT INTO `Produto` (`codigoInterno`, `codigoExterno`, `descricao`, `nome`, `unidade`, `categoria_id`) VALUES (2, 'cod002', 'Coca-Cola lata 2l', 'Coca pet', 'unit', 'P');

INSERT INTO `Endereco` (`id`, `bairro`, `cep`, `cidade`, `complemento`, `numero`, `rua`, `uf`) VALUES (1, 'Centro', '81820', 'Curitiba', 'casa', '123', 'Rua rua', 'PR');

INSERT INTO `Filial` (`id`, `nome`, `endereco_id`) VALUES (1, 'Filial A', 1);
INSERT INTO `Filial` (`id`, `nome`, `endereco_id`) VALUES (2, 'Filial B', 1);
