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
        
        if (valorDesconto >  valorJuros) {            
            throw new DescontoMaiorDoQueJurosException("Desconto maior que os juros!");
        }

        return true;
    }

    public void informarDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;

        this.valorJuros = (this.valorImovel / (this.prazoFinanciamento * 12)) * (this.taxaJurosAnual /12);

        try {
            validarDesconto(this.valorJuros, this.valorDesconto);
        } catch (DescontoMaiorDoQueJurosException e) {
            
            System.out.printf("\nMsg exception:\n\n" + e);
            System.out.printf("\nValor do desconto:" + String.format("%.2f", this.valorDesconto));
            System.out.printf("\nValor dos juros:" + String.format("%.2f", this.valorJuros));
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

    public String gerarLinhaTexto() {

        StringBuilder sb = new StringBuilder();

        sb.append("casa\n");
        sb.append(String.format("%.2f", this.consultarValorImovel()) + "\n");
        sb.append(String.format("%.2f", this.consultarValorFinanciamento()) + "\n");
        sb.append(String.format("%.2f", this.taxaJurosAnual) + "\n");
        sb.append(this.prazoFinanciamento + "\n");
        sb.append(String.format("%.2f", this.seguroObrigatorio) + "\n");
        sb.append(String.format("%.2f", this.areaConstruida) + "\n");
        sb.append(String.format("%.2f", this.areaTerreno) + "\n");
        sb.append(String.format("%.2f", this.valorDesconto) + "\n");

        this.linhaTexto = sb.toString();

        return this.linhaTexto;

    }

}
