package util;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner entrada;

    public InterfaceUsuario() {
        this.entrada = new Scanner(System.in);
    }

    public double pedirValorImovel(){
        double valor = 0;

        System.out.printf("Informe o valor do imóvel desejado:\n");

        try {
            valor = this.entrada.nextDouble();

        } catch (Exception e) {
            System.out.printf("Valor do imóvel inválido!\n\n" + e);
            return 0;

        } finally {
            if (valor <= 0) System.out.printf("Valor deve ser maior que zero!\n\n");

        }

        return valor;
        
    }

    public int pedirPrazoFinanciamento(){
        int prazo = 0;

        System.out.printf("Informe o prazo do financiamento:\n");

        try {
            prazo = this.entrada.nextInt();

        } catch (Exception e) {
            System.out.printf("Prazo de financiamento inválido!\n\n" + e);
            return 0;

        } finally {
            if (prazo <= 0) System.out.printf("Prazo de financiamento inválido!\n\n");

        }

        return prazo; 

    }

    public double pedirTaxaJuros() {
        double taxa = 0;

        System.out.printf("Informe o valor da taxa de juros:\n");

        try {
            taxa = this.entrada.nextDouble();
            
        } catch (Exception e) {
            System.out.printf("Valor da taxa de juros inválida!\n\n" + e);
            return 0;

        } finally {
            if (taxa <= 0) System.out.printf("Valor da taxa de juros deve ser maior que zero!\n\n");
        }
        
        return taxa;

    }

    public int pedirZonaLocalizacao(){
        int zona = 0;

        System.out.printf("Informe o tipo de zona do imóvel (1) resisencial ou (2) comercial:\n");

        try {
            zona = this.entrada.nextInt();

        } catch (Exception e) {
            System.out.printf("Zona inválida!\n\n" + e);
            return 0;

        } finally {
            if ( zona <= 0 & zona >= 3) System.out.printf("Zona deve ser (1) resisencial ou (2) comercial!\n\n");
        }

        return zona;

    }


    public int pedirVagasGaragem(){
        int vaga = -1;

        System.out.printf("Informe quantas vagas na garagem o imóvel possui:\n");

        try {
            vaga = this.entrada.nextInt();
        } catch (Exception e) {
            System.out.printf("Quantidade inválida!\n\n" + e);
            return -1;
        } finally {
            if (vaga <= -1 || vaga > 10) System.out.printf("Quantidade de vagas deve ser entre 0 e 10!\n\n");
        }
        
        return vaga;

    }
    
    public int pedirNumeroAndar(){
        int andar = -1;

        System.out.printf("Informe o andar do imóvel:\n");

        try {
            andar = this.entrada.nextInt();
        } catch (Exception e) {
            System.out.printf("Andar inválido!\n\n" + e);
        } finally {
            if ( andar <= -1 || andar > 200) System.out.printf("Andar deve estar entre 0 de 200!\n\n");
        }

        return andar;
    }    

    public double pedirAreaConstruida(){
        double area = 0;

        System.out.printf("Informe a área construída total do imóvel:\n");

        try {
            area = this.entrada.nextDouble();
        } catch (Exception e) {
            System.out.printf("Valor da área inválido!\n\n" + e);
        } finally {
            if (area <= 0) System.out.printf("Valor da área deve ser maior que zero!\n\n");
        }       

        return area;
    }

    public double pedirAreaTerreno(){
        double area = 0;

        System.out.printf("Informe a área do terreno do imóvel:\n");

        try {
            area = this.entrada.nextDouble();
        } catch (Exception e) {
            System.out.printf("Valor da área inválido!\n\n" + e);
        } finally {
            if (area <= 0) System.out.printf("Valor da área deve ser maior que zero!\n\n");
        }       

        return area;

    }

}
