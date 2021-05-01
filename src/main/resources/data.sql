INSERT INTO CATEGORIA (CODIGO, TIPO) VALUES ('P', 'Produto');
INSERT INTO CATEGORIA (CODIGO, TIPO) VALUES ('M', 'Material');

INSERT INTO FILIAL (CODIGO, NOME) VALUES (1, 'Filial 1');
INSERT INTO FILIAL (CODIGO, NOME) VALUES (2, 'Filial 2');

insert into Produto (codigoInterno, codigoExterno, nome, descricao, unidade, categoria_codigo) values (1, 'cod001', 'Coca-cola lata 350ml', 'Coca-cola lata', 'unid', 'P');
insert into Produto (codigoInterno, codigoExterno, nome, descricao, unidade, categoria_codigo) values (2, 'cod002', 'Coca-cola lata 2l', 'Coca-cola Pet', 'unid', 'P');
