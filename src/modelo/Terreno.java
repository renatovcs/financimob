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

    public String gerarLinhaTexto(int sequencia) {
        return (sequencia + " Condições de empréstimo para um tereno\n" + 
        "Valor do imóvel: "              + String.format("%.2f", this.consultarValorImovel())  	     + "\n" + 
        "Valor do financiamento: "       + String.format("%.2f", this.consultarValorFinanciamento())  + "\n" + 
        "Valor da taxa de juros anual: " + String.format("%.2f", this.taxaJurosAnual)                 + "\n" + 
        "Prazo do financiamento: "       + this.prazoFinanciamento                                           + "\n" + 
        "Zona de localização: "          +     (this.zonaLocalizacao == 1 ? "residencial" : "comercial")     + "\n\n" );

    }


}
