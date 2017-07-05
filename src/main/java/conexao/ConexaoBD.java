package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by FINCH-WALLACE on 30/06/2017.
 */
public class ConexaoBD {

    public static String status = "Não conectou...";

    //Método Construtor da Classe//
    public ConexaoBD() {

    }

    //Método de Conexão//
    public static Connection getConexao() {
        Connection connection = null;          //atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driverName);

            // Configurando conexão com o banco de dados//
            String serverName = "127.0.0.1:3620";    //caminho do servidor do BD
            String mydatabase = "databasename=ML";        //nome do banco de dados
            String url = "jdbc:sqlserver://" + serverName + "; " + mydatabase;
            String username = "sa";        //usuario
            String password = "wallace123";      //senha
            connection = DriverManager.getConnection(url, username, password);
            //connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:3620; databasename=ML","sa","wallace123");

            //Testa conexão//
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }


            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.\n"
            + e);
            return connection; //
        }

    }

    //Método que retorna o status da  conexão//
    public static String getStatus() {
        return status;
    }

    //Método que fecha a conexão//
    public static boolean fechaConexao() {
        try {
            ConexaoBD.getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia a conexão//
    public static Connection reiniciaConexao() {
        fechaConexao();
        return ConexaoBD.getConexao();
    }
}
