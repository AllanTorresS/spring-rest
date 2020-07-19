create table cidade (id int8 not null, nome varchar(255), estado_id int8, primary key (id));
create table cozinha (id int8 not null, nome varchar(255), primary key (id));
create table estado (id int8 not null, nome varchar(255), primary key (id));
create table forma_pagamento (id int8 not null, descricao varchar(255), primary key (id));
create table grupo_permissao (grupo_id int8 not null, permissao_id int8 not null);
create table grupos (id int8 not null, nome varchar(255), primary key (id));
create table permissao (id int8 not null, descricao varchar(255), nome varchar(255), primary key (id));
create table produto (id int8 not null, ativo boolean not null, descricao varchar(255) not null, nome varchar(255) not null, preco numeric(19, 2) not null, restaurante_id int8 not null, primary key (id));
create table restaurante (id int8 not null, data_atualizacao timestamp, data_cadastro timestamp, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255), taxa_frete numeric(19, 2), cozinha_id int8, endereco_cidade_id int8, primary key (id));
create table restaurante_forma_pagamento (restaurante_id int8 not null, forma_pagamento_id int8 not null);
create table usuario (id int8 not null, data_cadastro timestamp not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id));
create table usuario_grupo (usuario_id int8 not null, grupo_id int8 not null);


alter table cidade add constraint FK_ESTADO_ID foreign key (estado_id) references estado;
alter table grupo_permissao add constraint FK_PERMISSAO_ID foreign key (permissao_id) references permissao;
alter table grupo_permissao add constraint FK_GRUPO_ID foreign key (grupo_id) references grupos;
alter table produto add constraint FK_RESTAURANTE_ID foreign key (restaurante_id) references restaurante;
alter table restaurante add constraint FK_COZINHA_ID foreign key (cozinha_id) references cozinha;
alter table restaurante add constraint FK_ENDERECO_CIDADE_ID foreign key (endereco_cidade_id) references cidade;
alter table restaurante_forma_pagamento add constraint FK_FORMA_PAGAMENTO_ID foreign key (forma_pagamento_id) references forma_pagamento;
alter table restaurante_forma_pagamento add constraint FK_RESTAURANTE_ID foreign key (restaurante_id) references restaurante;
alter table usuario_grupo add constraint FK_GRUPO_ID foreign key (grupo_id) references grupos;
alter table usuario_grupo add constraint FK_USUARIO_ID foreign key (usuario_id) references usuario;

