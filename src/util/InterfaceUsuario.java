package util;

import java.util.Scanner;

import modelo.Casa;

public class InterfaceUsuario {

    private Scanner entrada;

    public InterfaceUsuario() {
        this.entrada = new Scanner(System.in);
    }

    public double pedirValorImovel(){
        double valor = 0;

        System.out.printf("Informe um valor de imóvel para as simulações em R$: ");

        try {
            valor = this.entrada.nextDouble();

        } catch (Exception e) {
            System.out.printf("\nValor do imóvel inválido!\n" + e);
            return 0;

        } finally {
            if (valor <= 0) System.out.printf("\nValor deve ser maior que zero!\n");

        }

        return valor;
        
    }

    public int pedirPrazoFinanciamento(){
        int prazo = 0;

        System.out.printf("Informe o prazo do financiamento em anos para todas as simulações: ");

        try {
            prazo = this.entrada.nextInt();

        } catch (Exception e) {
            System.out.printf("\nPrazo de financiamento inválido!\n" + e);
            return 0;

        } finally {
            if (prazo <= 0 || prazo > 40) {
                System.out.printf("\nPrazo de financiamento deve estar entre 1 e 40 anos!\n");
                prazo = 0;
            }

        }

        return prazo; 

    }

    public double pedirTaxaJuros() {
        double taxa = 0;

        System.out.printf("Informe o valor da taxa de juros para todas as simulações: ");

        try {
            taxa = this.entrada.nextDouble();
            
        } catch (Exception e) {
            System.out.printf("\nValor da taxa de juros inválida!\n" + e);
            return 0;

        } finally {
            if (taxa <= 0) System.out.printf("\nValor da taxa de juros deve ser maior que zero!\n");
        }
        
        return taxa;

    }

    public int pedirZonaLocalizacao(int sequencia){
        int zona = 0;

        System.out.printf("\nSimulação do terreno " + sequencia + " - Informe o tipo de zona do imóvel (1) resisencial ou (2) comercial: ");

        try {
            zona = this.entrada.nextInt();

        } catch (Exception e) {
            System.out.printf("\nZona inválida!\n" + e);
            return 0;

        } finally {
            if (zona <= 0 || zona >= 3) {
                System.out.printf("\nZona deve ser (1) resisencial ou (2) comercial!\n");
                zona = 0;
            }
        }

        return zona;

    }


    public int pedirVagasGaragem(int sequencia){
        int vaga = -1;

        System.out.printf("\nSimulação do apartamento " + sequencia + " - Informe quantas vagas na garagem o imóvel possui: ");

        try {
            vaga = this.entrada.nextInt();
        } catch (Exception e) {
            System.out.printf("\nQuantidade inválida!\n" + e);
            return -1;
        } finally {
            if (vaga <= -1 || vaga > 10) {
                System.out.printf("\nQuantidade de vagas deve ser entre 0 e 10!\n");
                vaga = -1;
            }
        }
        
        return vaga;

    }
    
    public int pedirNumeroAndar(int sequencia){
        int andar = -1;

        System.out.printf("\nSimulação do apartamento " + sequencia + " - Informe o andar do imóvel: ");

        try {
            andar = this.entrada.nextInt();
        } catch (Exception e) {
            System.out.printf("\nAndar inválido!\n" + e);
        } finally {
            if ( andar <= -1 || andar > 200) {
                System.out.printf("\nAndar deve estar entre 0 de 200!\n");
                andar = -1;
            }
        }

        return andar;
    }    

    public double pedirAreaConstruida(int sequencia){
        double area = 0;

        System.out.printf("\nSimulação da casa " + sequencia + " - Informe a área construída total da casa em m2: ");

        try {
            area = this.entrada.nextDouble();
        } catch (Exception e) {
            System.out.printf("\nValor da área inválido!\n" + e);
        } finally {
            if (area <= 0) System.out.printf("\nValor da área deve ser maior que zero!\n");
        }       

        return area;
    }

    public double pedirAreaTerreno(int sequencia){
        double area = 0;

        System.out.printf("\nSimulação da casa " + sequencia + " - Informe a área do terreno da casa em m2: ");

        try {
            area = this.entrada.nextDouble();
        } catch (Exception e) {
            System.out.printf("\nValor da área inválido!\n" + e);
        } finally {
            if (area <= 0) System.out.printf("\nValor da área deve ser maior que zero!\n");
        }       

        return area;

    }

    public double pedirValorDesconto(int sequencia, Casa casa){
        double desconto = -1;

        System.out.printf("\nSimulação da casa " + sequencia + " - Informe o desconto para o imóvel. Se não houver desconto informe 0: ");

        try {
            desconto = this.entrada.nextDouble();
            casa.informarDesconto(desconto);
        } catch (Exception e) {
            System.out.printf("\nValor do desconto inválido!\n" + e);
            return -1;

        } finally {
            if (desconto < 0) System.out.printf("\nValor do desconto deve ser maior ou igual a zero!\n");
        }       

        return desconto;

    }    

}
