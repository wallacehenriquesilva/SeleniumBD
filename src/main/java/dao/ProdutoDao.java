package dao;

import conexao.ConexaoBD;
import model.ProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Created by FINCH-WALLACE on 03/07/2017.
 */
public class ProdutoDao implements GenericDao<ProdutoModel> {
    public void incluir(ProdutoModel obj) {
/*
 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 * na base de dados
 */

        String sql = "INSERT INTO PRODUTO(PRO_VALOR, PRO_DESCRICAO)" +
                " VALUES(?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConexaoBD.getConexao();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, String.valueOf(obj.getProPreco()));
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setString(2, obj.getProDesc());

            //Executa a sql para inserção dos dados
            pstm.execute();

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
                e.printStackTrace();
            }
        }
    }

    public void alterar(ProdutoModel obj) {

    }

    public ArrayList<ProdutoModel> consultar(String filtro) {
        return null;
    }

    public void excluir(ProdutoModel obj) {

    }

    public ProdutoModel get(long id) {
        return null;
    }
}
