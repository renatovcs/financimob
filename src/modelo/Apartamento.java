package modelo;

public class Apartamento extends Financiamento {
    private double taxaMensal = 0;
    private int prazoFinanciamentoMeses = 0;
    public int vagasGaragem = 0;
    public int numeroAndar = 0;

    public Apartamento (double valorImovelDesejado, int prazoFinanciamentoAnos, double taxaJurosAnual) {

        super(valorImovelDesejado, prazoFinanciamentoAnos, taxaJurosAnual);

        this.valorFinanciamento = calcularTotalPagamento();
    }

    public double calcularPagamentoMensal() {

        this.taxaMensal = this.taxaJurosAnual/12;

        this.prazoFinanciamentoMeses = this.prazoFinanciamento*12;
        
        return this.valorImovel*Math.pow((1+this.taxaMensal), this.prazoFinanciamentoMeses)/Math.pow((1+this.taxaMensal),(prazoFinanciamentoMeses-1));
    }    

    protected double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * (this.prazoFinanciamento * 12);
    }

    public String gerarLinhaTexto() {
        return ("apartamento\n" + 
            String.format("%.2f", this.consultarValorImovel())  	      + "\n" + 
            String.format("%.2f", this.consultarValorFinanciamento())  + "\n" + 
            String.format("%.2f", this.taxaJurosAnual)                 + "\n" + 
            this.prazoFinanciamento             + "\n" + 
            this.vagasGaragem                   + "\n" + 
            this.numeroAndar                    + "\n" );

    }


}
