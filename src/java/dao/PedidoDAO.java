package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pedido;
import util.conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Pedido> consultarTodos()
        throws ClassNotFoundException, SQLException {

    Connection con = conexao.getConexao();

    PreparedStatement comando =
            con.prepareStatement("SELECT * FROM db_grafica.tb_pedido");

    ResultSet rs = comando.executeQuery();

    List<Pedido> lista = new ArrayList<>();

    while (rs.next()) {

        Pedido p = new Pedido();

        p.setIdPedido(rs.getInt("idPedido"));
        p.setCliente(rs.getString("cliente"));
        p.setFuncionario(rs.getString("funcionario"));
        p.setDataEntrega(rs.getDate("dataEntrega").toLocalDate());
        p.setValorTotal(rs.getDouble("valorTotal"));
        p.setDescricao(rs.getString("descricao"));
        p.setStatus(rs.getString("status"));

        lista.add(p);
    }

    con.close();

    return lista;
}
    
}
