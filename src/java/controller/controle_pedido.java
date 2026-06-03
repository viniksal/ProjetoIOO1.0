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

    /*
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");
        
        //alteração futura: substituir para SWITCH AND CASE

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

            try{
                pdao.cadastrar(p);
                //response.sendRedirect("pedidos.jsp?sucesso=1");
                response.sendRedirect("controle_pedido?op=CONSULTAR+TODOS&sucesso=1");
            }catch (ClassNotFoundException | SQLException ex){
                response.getWriter().println(ex.getMessage());
            }
        }else if ("CONSULTAR TODOS".equals(op)){  //teste de inverter
            try{

                PedidoDAO pdao = new PedidoDAO();
                List<Pedido> lista = pdao.consultarTodos();
                request.setAttribute("listaPedidos", lista);
                request.getRequestDispatcher("pedidos.jsp").forward(request, response);

            }catch (ClassNotFoundException | SQLException ex){
                response.getWriter().println(ex.getMessage());
            }
            
        }else if(op.equals("DELETAR")){

            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            Pedido p = new Pedido();
            p.setIdPedido(idPedido);
            
            try{
                PedidoDAO pdao = new PedidoDAO();
                pdao.deletar(p);
                response.sendRedirect("controle_pedido?op=CONSULTAR+TODOS");
                
            }catch(ClassNotFoundException | SQLException ex){
                ex.printStackTrace();
            }

        }
    }
    
    */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // 1. Pegamos o parâmetro e evitamos espaços extras ou letras minúsculas
        String op = request.getParameter("op");
        if (op == null) { 
            op = "CONSULTAR TODOS"; //Se não vier nada, o padrão é listar
        } else {
            op = op.toUpperCase().trim();
        }

        PedidoDAO pdao = new PedidoDAO();

        try {
            if ("CADASTRAR".equals(op)) {
                Pedido p = new Pedido();
                p.setCliente(request.getParameter("cliente"));
                p.setFuncionario(request.getParameter("funcionario"));
                p.setDataEntrega(LocalDate.parse(request.getParameter("data-entrega")));
                p.setValorTotal(Double.parseDouble(request.getParameter("valor-total")));
                p.setDescricao(request.getParameter("descricao"));
                p.setStatus(request.getParameter("status"));

                pdao.cadastrar(p);
                // CORREÇÃO: Redireciona para o Servlet consultar de novo, não para a JSP direto
                response.sendRedirect("controle_pedido?op=CONSULTAR+TODOS&sucesso=1");

            } else if ("DELETAR".equals(op)) {
                int idPedido = Integer.parseInt(request.getParameter("idPedido"));
                Pedido p = new Pedido();
                p.setIdPedido(idPedido);
                pdao.deletar(p);
                response.sendRedirect("controle_pedido?op=CONSULTAR+TODOS");

            }else if(op.equals("ATUALIZAR")){

                Pedido p = new Pedido();

                p.setIdPedido( Integer.parseInt(request.getParameter("idPedido")));
                p.setCliente(request.getParameter("cliente"));
                p.setFuncionario(request.getParameter( "funcionario"));
                p.setDataEntrega( java.time.LocalDate.parse( request.getParameter( "data-entrega")));
                p.setValorTotal(Double.parseDouble(request.getParameter("valor-total")));
                p.setDescricao(request.getParameter("descricao"));
                p.setStatus(request.getParameter("status"));

                PedidoDAO dao = new PedidoDAO();
                dao.atualizar(p);

                response.sendRedirect("controle_pedido?op=CONSULTAR+TODOS&editado=1");
            } else {
                // "CONSULTAR TODOS" ou qualquer outra coisa cai aqui (Padrão de segurança)
                List<Pedido> lista = pdao.consultarTodos();
                request.setAttribute("listaPedidos", lista);
                request.getRequestDispatcher("pedidos.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            // Se der erro, printamos no console do servidor para você ver o que é
            ex.printStackTrace(); 
            response.getWriter().println("Erro no sistema: " + ex.getMessage());
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
