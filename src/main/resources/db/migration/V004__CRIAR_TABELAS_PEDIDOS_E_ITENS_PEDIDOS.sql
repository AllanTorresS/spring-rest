create table item_pedido (
       id int8 not null,
        observacao varchar(255),
        preco_total numeric(19, 2),
        preco_unitario numeric(19, 2),
        quantidade int4,
        pedido_id int8 not null,
        produto_id int8 not null,
        primary key (id)
    );

create table pedido (
       id int8 not null,
        data_cancelamento timestamp,
        data_confirmacao timestamp,
        data_criacao timestamp,
        data_entrega timestamp,
        endereco_bairro varchar(255),
        endereco_cep varchar(255),
        endereco_complemento varchar(255),
        endereco_logradouro varchar(255),
        endereco_numero varchar(255),
        status varchar(255),
        subtotal numeric(19, 2),
        taxa_frete numeric(19, 2),
        valor_total numeric(19, 2),
        usuario_cliente_id int8 not null,
        endereco_cidade_id int8,
        forma_pagamento_id int8 not null,
        restaurante_id int8 not null,
        primary key (id)
    );

alter table item_pedido
       add constraint FK_PEDIDO_ID
       foreign key (pedido_id)
       references pedido;

alter table item_pedido
       add constraint FK_PRODUTO_ID
       foreign key (produto_id)
       references produto;

alter table pedido
       add constraint FK_USUARIO_CLIENTE_ID
       foreign key (usuario_cliente_id)
       references usuario;

alter table pedido
       add constraint FK_ENDERECO_CIDADE_ID
       foreign key (endereco_cidade_id)
       references cidade;

alter table pedido
       add constraint FK_FORMA_PAGAMENTO_ID
       foreign key (forma_pagamento_id)
       references forma_pagamento;

alter table pedido
       add constraint FK_RESTAURANTE_ID
       foreign key (restaurante_id)
       references restaurante;