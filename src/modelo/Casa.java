package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private double seguroObrigatorio = 80;
    public double areaConstruida = 0;
    public double areaTerreno = 0;
    public double valorDesconto = -1;
    public double valorJuros = 0;


    public Casa (double valorImovelDesejado, int prazoFinanciamentoAnos, double taxaJurosAnual, double seguroObrigatorio) {
        super(valorImovelDesejado, prazoFinanciamentoAnos, taxaJurosAnual);

        this.seguroObrigatorio = seguroObrigatorio;

        this.valorFinanciamento = calcularTotalPagamento();
        
    }

    private boolean validarDesconto(double valorJuros, double valorDesconto) throws DescontoMaiorDoQueJurosException {

        float valorJuros2f = Math.round(valorJuros * 100.0f) / 100.0f;
        float valorDesconto2f = Math.round(valorDesconto * 100.0f) / 100.0f;
        
        if (valorDesconto2f > valorJuros2f) {            
            throw new DescontoMaiorDoQueJurosException("Desconto consedido não pode ser superior ao valor dos juros calculados.");
        }

        return true;
    }

    public void informarDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;

        this.valorJuros = (this.valorImovel / (this.prazoFinanciamento * 12)) * (this.taxaJurosAnual /12);

        try {
            validarDesconto(this.valorJuros, this.valorDesconto);
        } catch (DescontoMaiorDoQueJurosException e) {
            System.out.print("\n" + e);
            System.out.print("\nValor do desconto concedido: R$ " + String.format("%.2f", this.valorDesconto));
            System.out.print("\nValor dos juros calculados:  R$ " + String.format("%.2f", this.valorJuros));
            System.out.print("\n");

            this.valorDesconto = -1;
        }

         
    }
    
    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual /12)) + this.seguroObrigatorio;
    }

    protected double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * (this.prazoFinanciamento * 12);
    }

    public double consultarValorFinanciamento() {
        return this.calcularTotalPagamento();
    }

    public String gerarLinhaTexto(int sequencia) {

        StringBuilder sb = new StringBuilder();

        sb.append(sequencia + " Condições do empréstimo para casa\n");
        sb.append("Valor do imóvel: " + String.format("%.2f", this.consultarValorImovel()) + "\n");
        sb.append("Valor do financiamento: " + String.format("%.2f", this.consultarValorFinanciamento()) + "\n");
        sb.append("Valor da taxa de juros anual: " + String.format("%.2f", this.taxaJurosAnual) + "\n");
        sb.append("Prazo do financiamento: " + this.prazoFinanciamento + "\n");
        sb.append("Valor do seguro obrigatório: " + String.format("%.2f", this.seguroObrigatorio) + "\n");
        sb.append("Área construída: " + String.format("%.2f", this.areaConstruida) + "\n");
        sb.append("Área do terreno: " + String.format("%.2f", this.areaTerreno) + "\n");
        sb.append("Valor do desconto concedido: " + String.format("%.2f", this.valorDesconto) + "\n\n");

        this.linhaTexto = sb.toString();

        return this.linhaTexto;

    }

}
