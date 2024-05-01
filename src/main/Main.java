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
        salvaListaFinanciamentos(listaFinanciamentos);
        recuperaListaFinanciamentos(listaFinanciamentos);
        serializaListaFinanciamentos(listaFinanciamentos);
        desserializaListaFinanciamentos(listaFinanciamentos);

    }

    static ArrayList<Financiamento> solicitarDadosFinanciamento(int quantidadeCasa, int quantidadeApartamento, int quantidadeTerreno) {

        int     prazoFinanciamento = 0;
        double  valorImovel = 0;
        double  taxaJurosAnual = 0;
        
        InterfaceUsuario interfaceUsuario  = new InterfaceUsuario();
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<Financiamento>();

        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.printf("\n\nRENATO CURVELO - SOMATIVA 2");
        System.out.printf("\n\nBem vindo ao sistema de simulação de empréstimos!\nInforme os valores solicitados e veja dos resultados.\n\n");

        while (valorImovel == 0) valorImovel = interfaceUsuario.pedirValorImovel();

        while (taxaJurosAnual == 0) taxaJurosAnual = interfaceUsuario.pedirTaxaJuros();

        while (prazoFinanciamento == 0) prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();

        for (int i = 1; i <= quantidadeCasa; i++) {
            Casa financimob = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 80);

            while (financimob.areaConstruida <= 0) financimob.areaConstruida = interfaceUsuario.pedirAreaConstruida(i);

            while (financimob.areaTerreno <= 0) financimob.areaTerreno = interfaceUsuario.pedirAreaTerreno(i);

            while (financimob.valorDesconto < 0) financimob.informarDesconto(interfaceUsuario.pedirValorDesconto(i));

            listaFinanciamentos.add(financimob);
        }

        for (int i = 1; i <= quantidadeApartamento; i++) {
            Apartamento financimob = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

            while (financimob.vagasGaragem == -1) financimob.vagasGaragem = interfaceUsuario.pedirVagasGaragem(i);

            while (financimob.numeroAndar == -1) financimob.numeroAndar = interfaceUsuario.pedirNumeroAndar(i);

            listaFinanciamentos.add(financimob);
        }

        for (int i = 1; i <= quantidadeTerreno; i++) {
            Terreno financimob = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual);

            while (financimob.zonaLocalizacao == 0) financimob.zonaLocalizacao = interfaceUsuario.pedirZonaLocalizacao(i);

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

            int i = 1;
            for (Financiamento 	financSelecionado : listaFinanciamentos) {
                escritor.write(financSelecionado.gerarLinhaTexto(i));
                i++;
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

        System.out.println("Inicio da leitura do arquivo de texto.\n");

        try {
            leitor = new FileReader("arquivoTexto.txt");

            int caractereLido;
       
            while ((caractereLido = leitor.read()) != -1) {
                System.out.print((char)caractereLido);
            }
                
            leitor.close();

            System.out.println("\n\nFim da leitura do arquivo de texto.\n\n");

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

        System.out.println("Inicio da leitura do arquivo serializado.\n");

        try {
            
            inputStream = new ObjectInputStream(new FileInputStream("listaFinanciamento.test"));
            
            Object objeto = null;
            int i = 1;
            while((objeto = inputStream.readObject()) != null) {
                if (objeto instanceof Financiamento) {
                    System.out.println(((Financiamento)objeto).gerarLinhaTexto(i));
                    i++;
                }
            }
           
            inputStream.close();

        } catch (EOFException e) {
            System.out.println("\n\nFim da leitura do arquivo serializado.\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

    }
}
