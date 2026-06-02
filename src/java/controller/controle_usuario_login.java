package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "controle_usuario_login", urlPatterns = {"/controle_usuario_login"})
public class controle_usuario_login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario u = new Usuario();

        u.setEmail(email);
        u.setSenha(senha);

        UsuarioDAO udao = new UsuarioDAO();

        try{
            boolean loginValido = udao.validarLogin(u);

            
            if (loginValido) {
                response.sendRedirect("home.html");
            } else {
                request.setAttribute("mensagem", "E-mail ou senha inválidos");
                request.getRequestDispatcher("pedidos.html").forward(request, response);
            }
            
            /*
            if (loginValido) {
                response.sendRedirect("home.html");
            } else {
                response.getWriter().println("LOGIN INVALIDO");
            }
            */
            
        }catch (ClassNotFoundException | SQLException ex) {
            request.setAttribute("mensagem", ex.getMessage());
            request.getRequestDispatcher("Pedido.html").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
