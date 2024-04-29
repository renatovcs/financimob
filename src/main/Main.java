package main;

import modelo.Financiamento;
import modelo.Terreno;
import modelo.Apartamento;
import modelo.Casa;
import util.InterfaceUsuario;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    static void salvaListaFinanciamentos(ArrayList<Financiamento> listaFinanciamentos) {

        FileWriter escritor = null;

        try {
            escritor = new FileWriter("arquivoTexto.txt");

            int contadorLetras = 0;

            for (Financiamento 	financSelecionado : listaFinanciamentos) {
                escritor.write(financSelecionado.gerarLinhaTexto());

                //while (contadorLetras < financSelecionado. .length()) {}
            }

            escritor.flush();
            escritor.close();

        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void recuperaListaFinanciamentos(ArrayList<Financiamento> listaFinanciamentos) {

        FileReader leitor = null;

        try {
            leitor = new FileReader("arquivoTexto.txt");

            int contadorLetras = 0;

            for (Financiamento 	financSelecionado : listaFinanciamentos) {
                leitor.read();

                //while (contadorLetras < financSelecionado. .length()) {}
            }

            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }    

    static void serializaListaFinanciamentos(ArrayList<Financiamento> listaFinanciamentos) {

        ObjectOutputStream outputStream = null;

        try {
            
            outputStream = new ObjectOutputStream(new FileOutputStream("listaFinanciamento.test"));
            
            for (Financiamento 	financSelecionado : listaFinanciamentos) {
                outputStream.writeObject(financSelecionado);
            }

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void desserializaListaFinanciamentos(ArrayList<Financiamento> listaFinanciamentos) {

        ObjectInputStream inputStream = null;

        try {
            
            inputStream = new ObjectInputStream(new FileInputStream("listaFinanciamento.test"));
            
            Object objeto = null;

            while((objeto = inputStream.readObject()) != null) {
                if (objeto instanceof Financiamento) {
                    System.out.println(((Financiamento)objeto).gerarLinhaTexto());
                }
            }
           
            inputStream.close();
            
        } catch (EOFException e) {
            System.out.println("Fim do arquivo.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

    }
}
