package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pedido;
import util.conexao;

public class PedidoDAO {

    public void cadastrar(Pedido p) throws ClassNotFoundException, SQLException {

        Connection con = conexao.getConexao();

        PreparedStatement comando = con.prepareStatement(
                "INSERT INTO tb_pedido (cliente, funcionario, dataEntrega, valorTotal, descricao, status)"
                + " VALUES (?, ?, ?, ?, ?, ?)"
        );

        comando.setString(1, p.getCliente());
        comando.setString(2, p.getFuncionario());
        comando.setDate(3, Date.valueOf(p.getDataEntrega()));
        comando.setDouble(4, p.getValorTotal());
        comando.setString(5, p.getDescricao());
        comando.setString(6, p.getStatus());

        comando.execute();

        comando.close();
        con.close();
        
        
        
    }
}
