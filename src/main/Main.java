package main;

import modelo.Financiamento;
import modelo.Terreno;
import modelo.Apartamento;
import modelo.Casa;
import util.InterfaceUsuario;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Financiamento> listaFinanciamentos = solicitarDadosFinanciamento(2, 2, 2);

        imprimirListaFinanciamentos(listaFinanciamentos);

    }

    static ArrayList<Financiamento> solicitarDadosFinanciamento(int quantidadeCasa, int quantidadeApartamento, int quantidadeTerreno) {

        int     prazoFinanciamento = 0;
        double  valorImovel = 0;
        double  taxaJurosAnual = 0;
        
        InterfaceUsuario interfaceUsuario  = new InterfaceUsuario();
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<Financiamento>();

        while (valorImovel == 0) valorImovel = interfaceUsuario.pedirValorImovel();

        while (taxaJurosAnual == 0) taxaJurosAnual = interfaceUsuario.pedirTaxaJuros();

        while (prazoFinanciamento == 0) prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();

        for (int i = 0; i < quantidadeCasa; i++) {
            Casa financimob = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 80);

            while (financimob.areaConstruida == 0) financimob.areaConstruida = interfaceUsuario.pedirAreaConstruida();

            while (financimob.areaTerreno == 0) financimob.areaTerreno = interfaceUsuario.pedirAreaTerreno();

            listaFinanciamentos.add(financimob);
        }

        for (int i = 0; i < quantidadeApartamento; i++) {
            Apartamento financimob = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

            while (financimob.vagasGaragem == 0) financimob.vagasGaragem = interfaceUsuario.pedirVagasGaragem();

            while (financimob.numeroAndar == 0) financimob.numeroAndar = interfaceUsuario.pedirNumeroAndar();

            listaFinanciamentos.add(financimob);
        }

        for (int i = 0; i < quantidadeTerreno; i++) {
            Terreno financimob = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual);

            while (financimob.zonaLocalizacao == 0) financimob.zonaLocalizacao = interfaceUsuario.pedirZonaLocalizacao();

            listaFinanciamentos.add(financimob);
        }


        return listaFinanciamentos;

    }

    static void imprimirListaFinanciamentos(ArrayList<Financiamento> listaFinanciamentos) {

        int     j = 1;
        double  valorTotalImoveis = 0;
        double  valorTotalFinanciamentos = 0;

        for (Financiamento 	financSelecionado : listaFinanciamentos) {
            
            valorTotalImoveis += financSelecionado.consultarValorImovel();
            valorTotalFinanciamentos += financSelecionado.consultarValorFinanciamento();

            System.out.print("Financiamento " + j + " - valor do imóvel: R$ " +  String.format("%.0f", financSelecionado.consultarValorImovel()) + ", valor do financiamento: R$ " + String.format("%.0f", financSelecionado.consultarValorFinanciamento()) + ". \n\n");

            j++;            
        }

        System.out.print("Total de todos os imóveis: R$ " + String.format("%.0f", valorTotalImoveis) + ", total de todos os financiamentos: R$ " + String.format("%.0f", valorTotalFinanciamentos) + "\n\n");

    }
}
