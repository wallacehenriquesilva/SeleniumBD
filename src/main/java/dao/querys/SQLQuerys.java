package dao.querys;


/**
 * Created by FINCH-WALLACE on 04/07/2017.
 */
public class SQLQuerys {
    public static String INSERT = "INSERT INTO PRODUTO(PRO_VALOR, PRO_DESCRICAO) VALUES(?,?)";
    public static String DELETE = "DELETE FROM PRODUTO WHERE PRO_ID = ?";
    public static String UPDATE = "UPDATE PRODUTO SET PRO_VALOR = ?, PRO_DESCRICAO = ? WHERE PRO_ID = ?";
    public static String SELECT = "SELECT * FROM PRODUTO";
    public static String SELECT_CONSULTA = "SELECT * FROM PRODUTO WHERE PRO_VALOR = ?";
}
