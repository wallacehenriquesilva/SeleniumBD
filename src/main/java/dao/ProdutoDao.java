package dao;

import conexao.ConexaoBD;
import dao.querys.SQLQuerys;
import model.ProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FINCH-WALLACE on 03/07/2017.
 */
public class ProdutoDao implements GenericDao<ProdutoModel> {
    public void incluir(ProdutoModel obj) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //Cria uma conexão com o banco
            conn = ConexaoBD.getConexao();
            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(SQLQuerys.INSERT);
            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, String.valueOf(obj.getProPreco()));
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setString(2, obj.getProDesc());
            //Executa a sql para inserção dos dados
            pstm.execute();

            System.out.println("Inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir -->" + e);
        } finally {
            //Fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão --> " + e);
                e.printStackTrace();
            }
        }
    }

    public void alterar(ProdutoModel obj) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConexaoBD.getConexao();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(SQLQuerys.UPDATE);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, String.valueOf(obj.getProPreco()));
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setString(2, obj.getProDesc());

            pstm.setInt(4, obj.getProId());

            //Executa a sql para inserção dos dados
            pstm.execute();

            System.out.println("Alterado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao alterar --> " + e);
            e.printStackTrace();
        } finally {
            //Fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão --> " + e);
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ProdutoModel> consultar(String condicao) {
        ArrayList<ProdutoModel> listProdutos = new ArrayList<ProdutoModel>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConexaoBD.getConexao();

            pstm = conn.prepareStatement(SQLQuerys.SELECT_CONSULTA);
            //Condição de pesquisa por preço
            pstm.setString(1, String.valueOf(condicao));

            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                ProdutoModel produtoModel = new ProdutoModel();

                //Recupera o id do banco e atribui ele ao objeto
                produtoModel.setProId(rset.getInt("PRO_ID"));

                //Recupera o valor do banco e atribui ele ao objeto
                produtoModel.setProPreco(rset.getInt("PRO_VALOR"));

                //Recupera a descricao do banco e atribui ele ao objeto
                produtoModel.setProDesc(rset.getString("PRO_DESCRICAO"));


                //Adiciona o produto a lista de produtos
                listProdutos.add(produtoModel);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar --> " + e);
            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão --> " + e);
                e.printStackTrace();
            }
        }

        return listProdutos;
    }

    public ArrayList<ProdutoModel> get() {
        ArrayList<ProdutoModel> listProdutos = new ArrayList<ProdutoModel>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConexaoBD.getConexao();

            pstm = conn.prepareStatement(SQLQuerys.SELECT);

            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                ProdutoModel produtoModel = new ProdutoModel();

                //Recupera o id do banco e atribui ele ao objeto
                produtoModel.setProId(rset.getInt("PRO_ID"));

                //Recupera o valor do banco e atribui ele ao objeto
                produtoModel.setProPreco(rset.getInt("PRO_VALOR"));

                //Recupera a descricao do banco e atribui ele ao objeto
                produtoModel.setProDesc(rset.getString("PRO_DESCRICAO"));


                //Adiciona o produto a lista de produtos
                listProdutos.add(produtoModel);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar --> " + e);
            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão --> " + e);
                e.printStackTrace();
            }
        }

        return listProdutos;
    }

    public void excluir(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.getConexao();

            pstm = conn.prepareStatement(SQLQuerys.DELETE);

            pstm.setInt(1, id);

            pstm.execute();

            System.out.println("Produto " + id + " excluido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao apagar dado --> " + e);
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão --> " + e);
                e.printStackTrace();
            }
        }
    }

}
