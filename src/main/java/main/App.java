package main;

import conexao.ConexaoBD;
import operacoes.Operacoes;



/**
 * Created by FINCH-WALLACE on 03/07/2017.
 */
public class App {

    public static void main(String args[]) {
        System.out.println("---------------------");
        System.out.println("-- Selenium com BD --");
        System.out.println("---------------------");

        ConexaoBD.getConexao();
        System.out.println(ConexaoBD.getStatus());

        Operacoes operacoes = new Operacoes();
        operacoes.menu();

        System.out.println("_______________");
        System.out.println("__ Finalizou __");
        System.out.println("_______________");


    }
}
