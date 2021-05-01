INSERT INTO CATEGORIA (CODIGO, TIPO) VALUES ('P', 'Produto');
INSERT INTO CATEGORIA (CODIGO, TIPO) VALUES ('M', 'Material');
INSERT INTO CATEGORIA (CODIGO, TIPO) VALUES ('F', 'Ferramenta');

INSERT INTO FILIAL (CODIGO, NOME) VALUES (1, 'Filial 1');
INSERT INTO FILIAL (CODIGO, NOME) VALUES (2, 'Filial 2');

insert into Produto (codigoInterno, codigoExterno, nome, descricao, unidade, categoria_codigo) values (1, 'cod001', 'Coca-cola lata 350ml', 'Coca-cola lata', 'unid', 'P');
insert into Produto (codigoInterno, codigoExterno, nome, descricao, unidade, categoria_codigo) values (2, 'cod002', 'Coca-cola lata 2l', 'Coca-cola Pet', 'unid', 'P');

INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('EA', 'E', 'Entrada por aquisição (acompanhada de uma nota de compra)');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('ED', 'E', 'Entrada por devolução (nota de devolução)');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('ET', 'E', 'Entrada por transferência (nota de transferência)');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('SV', 'S', 'Saída por venda (acompanha de uma nota de venda)');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('SD', 'S', 'Saída por devolução (nota de devolução)');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('SP', 'S', 'Saída por perda (doc)');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('SR', 'S', 'Saída por roubo');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('SC', 'S', 'Saída por consumo (documento que registra uma requisição)');
INSERT INTO NOTATIPO (CODIGO, MOVIMENTACAO, DESCRICAO) VALUES ('ST', 'S', 'Saída para transferência entre filiais (nota de transferência)');
