package modelo;

public class Apartamento extends Financiamento {
    private double taxaMensal = 0;
    private int prazoFinanciamentoMeses = 0;
    public int vagasGaragem = -1;
    public int numeroAndar = -1;

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

    public String gerarLinhaTexto(int sequencia) {
        return (sequencia + " Condições do empréstimo para apartamento\n" + 
            "Valor do imóvel: " + String.format("%.2f", this.consultarValorImovel())  	      + "\n" + 
            "Valor do financiamento: " + String.format("%.2f", this.consultarValorFinanciamento())  + "\n" + 
            "Valor da taxa de juros anual: " + String.format("%.2f", this.taxaJurosAnual)                 + "\n" + 
            "Prazo do financiamento: " + this.prazoFinanciamento             + "\n" + 
            "Quantidade de vagas na garagem: " + this.vagasGaragem                   + "\n" + 
            "Andar no prédio: " + this.numeroAndar                    + "\n\n" );

    }


}
