package main;

import conexao.ConexaoBD;
import crawler.MercadoLivre;
import model.ProdutoModel;
import navegador.BrowserDriver;
import operacoes.Operacoes;

import java.util.ArrayList;

/**
 * Created by FINCH-WALLACE on 03/07/2017.
 */
public class App {

    public static void main(String args[]) {
        //BrowserDriver browser = new BrowserDriver();

        System.out.println("---------------------");
        System.out.println("-- Selenium com BD --");
        System.out.println("---------------------");

        ConexaoBD.getConexao();
        System.out.println(ConexaoBD.getStatus());

        /*MercadoLivre ml = new MercadoLivre();
        ml.search(browser, "tv-plasma");
        System.out.println("---------------------");*/

        Operacoes operacoes = new Operacoes();
        operacoes.menu();


    }
}
