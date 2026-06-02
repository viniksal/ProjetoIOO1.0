package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import util.conexao;

public class UsuarioDAO {
    /*
    public Usuario consultarById(Usuario u) throws ClassNotFoundException, SQLException {
        Connection con = conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos where id = ?");
        comando.setInt(1, u.getIdUsuario());
        
        ResultSet rs = comando.executeQuery();
        
        Usuario usu = new Usuario();
        if (rs.next()){
            usu.setIdUsuario(rs.getInt("id"));
            usu.setEmail(rs.getString("email"));
            usu.setSenha(rs.getString("Senha"));
        }        
        return usu;
    }*/


    public boolean validarLogin(Usuario u) throws ClassNotFoundException, SQLException {

        Connection con = conexao.getConexao();

        PreparedStatement comando = con.prepareStatement("SELECT * FROM db_grafica.tb_login WHERE email = ? AND senha = ?");

        comando.setString(1, u.getEmail());
        comando.setString(2, u.getSenha());

        ResultSet rs = comando.executeQuery();

        boolean encontrou = rs.next();

        rs.close();
        comando.close();
        con.close();

        return encontrou;
    }
}
