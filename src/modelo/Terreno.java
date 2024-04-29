package modelo;


public class Terreno extends Financiamento {
    public int zonaLocalizacao = 0;

    public Terreno (double valorImovelDesejado, int prazoFinanciamentoAnos, double taxaJurosAnual) {

        super(valorImovelDesejado, prazoFinanciamentoAnos, taxaJurosAnual);

        this.valorFinanciamento = calcularTotalPagamento();
    }

    public double calcularPagamentoMensal() {

        double valorbase = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual /12));

        return  valorbase + (valorbase * 100 / 2);

    }

    protected double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * (this.prazoFinanciamento * 12);
    }

    public double consultarValorFinanciamento() {
        return this.calcularTotalPagamento();
    }

    public String gerarLinhaTexto() {
        return ("tereno;" + 
            String.format("%.2f", this.consultarValorImovel())  	      + ";" + 
            String.format("%.2f", this.consultarValorFinanciamento())  + ";" + 
            String.format("%.2f", this.taxaJurosAnual)                 + ";" + 
            String.format("%.0f", this.prazoFinanciamento)             + ";" + 
            (this.zonaLocalizacao == 1 ? "residencial" : "comercial"));

    }


}
