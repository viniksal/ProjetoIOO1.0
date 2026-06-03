package controller;

import dao.PedidoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
import java.util.List;

@WebServlet("/controle_pedido")
public class controle_pedido extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");

        if(op.equals("CADASTRAR")){
            Pedido p = new Pedido();
            p.setCliente(request.getParameter("cliente"));
            p.setFuncionario(request.getParameter("funcionario"));
            p.setDataEntrega(
                    LocalDate.parse(request.getParameter("data-entrega"))
            );

            p.setValorTotal(
                 Double.parseDouble(request.getParameter("valor-total"))
            );
            p.setDescricao(request.getParameter("descricao"));
            p.setStatus(request.getParameter("status"));
            PedidoDAO pdao = new PedidoDAO();

            try {
                pdao.cadastrar(p);
                response.sendRedirect("pedidos.jsp?sucesso=1");
            } catch (ClassNotFoundException | SQLException ex) {
                response.getWriter().println(ex.getMessage());
            }
        }else if ("CONSULTAR TODOS".equals(op)) {
            try {

                PedidoDAO pdao = new PedidoDAO();
                List<Pedido> lista = pdao.consultarTodos();
                request.setAttribute("listaPedidos", lista);
                request.getRequestDispatcher("pedidos.jsp").forward(request, response);

            } catch (ClassNotFoundException | SQLException ex) {
                response.getWriter().println(ex.getMessage());

            }
        }
    }
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }
}
