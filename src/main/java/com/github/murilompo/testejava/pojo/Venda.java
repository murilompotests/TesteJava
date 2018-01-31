package com.github.murilompo.testejava.pojo;

import java.time.LocalDate;

public class Venda {

    private LocalDate data;
    private Vendedor vendedor;
    private Double valor;

    public Venda(LocalDate data, Vendedor vendedor, Double valor) {
        this.data = data;
        this.vendedor = vendedor;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Data: %s, Vendedor: %s, Valor: %s", this.data, this.vendedor.getNome(), this.valor);
    }

}
