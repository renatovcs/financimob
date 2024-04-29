package modelo;

public abstract class Financiamento {
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;
    double valorFinanciamento;

    public Financiamento(double valorImovelDesejado, int prazoFinanciamentoAnos, double taxaJurosAnual ) {
        this.valorImovel = valorImovelDesejado;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    protected double calcularPagamentoMensal;

    protected double calcularTotalPagamento;

    public double consultarValorImovel() {
        return this.valorImovel;
    }

    public double consultarValorFinanciamento() {
        return this.valorFinanciamento;
    }


}
