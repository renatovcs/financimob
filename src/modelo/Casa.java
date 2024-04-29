package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private double seguroObrigatorio = 80;
    public double areaConstruida = 0;
    public double areaTerreno = 0;
    public double valorDesconto = 0;
    public double valorJuros = 0;


    public Casa (double valorImovelDesejado, int prazoFinanciamentoAnos, double taxaJurosAnual, double seguroObrigatorio) {
        super(valorImovelDesejado, prazoFinanciamentoAnos, taxaJurosAnual);

        this.seguroObrigatorio = seguroObrigatorio;

        this.valorFinanciamento = calcularTotalPagamento();
        
    }

    private boolean validarDesconto(double valorJuros, double valorDesconto) throws DescontoMaiorDoQueJurosException {
        throw new DescontoMaiorDoQueJurosException("Desconto maior que os juros!");
    }

    public void informarDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;

        this.valorJuros = (this.valorImovel / (this.prazoFinanciamento * 12)) * (this.taxaJurosAnual /12);

        try {
            validarDesconto(this.valorJuros, this.valorDesconto);
        } catch (DescontoMaiorDoQueJurosException e) {
            System.out.printf("Msg exceptio:\n\n" + e);
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

}
