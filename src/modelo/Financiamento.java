package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable{
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;
    double valorFinanciamento;
    String linhaTexto;

    public Financiamento(double valorImovelDesejado, int prazoFinanciamentoAnos, double taxaJurosAnual ) {
        this.valorImovel = valorImovelDesejado;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    protected double calcularPagamentoMensal;

    protected double calcularTotalPagamento;

    public String gerarLinhaTexto() {
        return this.linhaTexto;
    }

    public double consultarValorImovel() {
        return this.valorImovel;
    }

    public double consultarValorFinanciamento() {
        return this.valorFinanciamento;
    }


}
