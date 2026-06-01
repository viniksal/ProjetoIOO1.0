package util;

/**
 *
 * @author vinik
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PTOLEDO
 */
public class conexao {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        //Verificar em seu computador
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/aula_ioo"; //Verificar em seu computador
        String USERNAME = "root"; //Verificar em seu computador
        String PASSWORD = ""; //Verificar em seu computador
        
        // O método forName carrega e inicia o driver passado por parâmetro
        Class.forName(DRIVER);
        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
