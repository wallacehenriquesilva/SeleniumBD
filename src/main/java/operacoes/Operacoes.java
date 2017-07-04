package operacoes;

import controller.ProdutoController;
import crawler.MercadoLivre;
import model.ProdutoModel;
import navegador.BrowserDriver;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by FINCH-WALLACE on 04/07/2017.
 */
public class Operacoes {
    Scanner scan = new Scanner(System.in);
    int op = 0;
    String condicao=null;

    public void menu() {
        montaMenu();
    }

    private void exibeLista(ArrayList<ProdutoModel> list) {
        list.forEach(System.out::println);
        montaMenu();
    }

    private void montaMenu() {
        System.out.println("-----------------------------");
        System.out.println("- 1 - Popular lista         -");
        System.out.println("- 2 - Listar todos os dados -");
        System.out.println("- 3 - Pesquisar             -");
        System.out.println("- 4 - Alterar               -");
        System.out.println("- 5 - Excluir               -");
        System.out.println("- 6 - Sair                  -");
        System.out.println("-----------------------------");
        op = Integer.parseInt(scan.nextLine());
        testaCondicao();
    }

    private void testaCondicao() {
        ArrayList<ProdutoModel> listProduto;
        ProdutoController produtoController = new ProdutoController();

        if (op > 0 && op < 7) {
            while (op != 6) {
                switch (op) {
                    case 1:
                        populaLista();
                        break;
                    case 2:
                        listProduto = produtoController.get();
                        exibeLista(listProduto);
                        break;
                    case 3:
                        System.out.println("Digite o valor pesquisado");
                        condicao = scan.nextLine();
                        listProduto = produtoController.consultar(condicao);
                        exibeLista(listProduto);
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Digite o id do produto que será excluido");
                        op = Integer.parseInt(scan.nextLine());
                        produtoController.excluir(op);
                        break;

                    default:
                        break;
                }
                System.exit(0);
            }
        } else {
            System.out.println("Digite o valor de uma opção válida!!!");
            montaMenu();
        }
    }

    private void populaLista() {
        System.out.println("Digite o item pesquisado");
        condicao = scan.nextLine().replace(" ", "-").toLowerCase();

        BrowserDriver browser = new BrowserDriver();
        MercadoLivre ml = new MercadoLivre();
        //ml.search(browser, "tv-plasma");
        ml.search(browser, condicao);
        System.out.println("---------------------");
        montaMenu();

        //System.out.println(condicao);

    }
}
