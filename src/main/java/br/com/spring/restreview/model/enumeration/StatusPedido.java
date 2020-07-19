package br.com.spring.restreview.model.enumeration;

public enum StatusPedido {

    CRIADO("Criado"),
    CONFIRMADO("Confirmado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private String nome;

    StatusPedido(String nome) {
        this.nome = nome;
    }

    public StatusPedido[] getValues() {
        return StatusPedido.values();
    }
}
