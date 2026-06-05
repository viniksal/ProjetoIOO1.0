<%@page import="java.util.List"%>
<%@page import="model.Pedido"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
List<Pedido> lista =
(List<Pedido>) request.getAttribute("listaPedidos");
%>

<!doctype html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gráfica</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous"> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="css/style.css">
        <style>
        /*MODAL*/
            .modal-pedido{
                width: 850px;
                max-width: 95%;
                background: #171717;
                color: white;
                border: 1px solid #2b2b2b;
                border-radius: 18px;
                padding: 0;
                box-shadow: 0 20px 60px rgba(0,0,0,.6);
                overflow: hidden;
            }

            .modal-pedido::backdrop{
                background: rgba(0,0,0,.75);
                backdrop-filter: blur(4px);
            }

/* CABEÃALHO */

            .modal-topo{
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 25px 30px;
                border-bottom: 1px solid #2a2a2a;
            }

            .modal-topo h2{
                margin: 0;
                color: #ff6b00;
                font-weight: 600;
            }

            .btn-x{
                background: transparent;
                border: none;
                color: #999;
                font-size: 20px;
            }

            .btn-x:hover{
                color: white;
            }

/* CORPO */

            .modal-pedido form{
                padding: 30px;
            }

            .modal-pedido label{
                    color: #bcbcbc;
                margin-bottom: 8px;
            }

/* INPUTS */
            .input-dark{
                background: #0f0f0f !important;
                border: 1px solid #303030 !important;
                color: white !important;
                height: 50px;
            }

            .input-dark:focus{
                background: #0f0f0f !important;
                border-color: #ff6b00 !important;
                box-shadow: 0 0 0 .2rem rgba(255,107,0,.15) !important;
            }

            textarea.input-dark{
                height: auto;
            }

/* FOOTER */
            .modal-footer-custom{
                display: flex;
                justify-content: flex-end;
                gap: 12px;
                margin-top: 30px;
            }

/* BOTÃO SALVAR */
            .btn-salvar{
                background: #ff6b00;
                color: white;
                border: none;
                padding: 12px 24px;
                border-radius: 10px;
                transition: .3s;
            }

            .btn-salvar:hover{
                background: #ff7f1f;
                color: white;
                transform: translateY(-2px);
                box-shadow: 0 0 15px rgba(255,107,0,.25);
            }  
            
            /* Container Principal dos Filtros */
            .filter-container {
                background-color: #141414; /* Fundo escuro do card */
                border: 1px solid #222222;
                border-radius: 12px;
                padding: 24px;
                margin-bottom: 25px;
            }

            /* TÃ­tulo da SeÃ§Ã£o */
            .filter-title {
                color: #9e9e9e;
                font-size: 12px;
                font-weight: bold;
                letter-spacing: 1.5px;
                margin-bottom: 20px;
                text-transform: uppercase;
            }

            /* Labels dos Inputs */
            .form-label-custom {
                color: #9e9e9e;
                font-size: 14px;
                margin-bottom: 8px;
                display: block;
            }

            /* CustomizaÃ§Ã£o dos Inputs e Selects */
            .form-select-custom, 
            .form-control-custom {
                display: block;
                width: 100%;
                padding: 12px 16px;
                font-size: 14px;
                color: #9e9e9e;
                background-color: #1a1a1a; /* Fundo ligeiramente mais claro que o container */
                border: 1px solid #2d2d2d;
                border-radius: 8px;
                appearance: none; /* Remove seta padrÃ£o do select para customizar se quiser */
                transition: border-color 0.15s ease-in-out;
            }

            
            .form-select-custom:focus, 
            .form-control-custom:focus {
                outline: none;
                border-color: #ff7a1a; /* Borda laranja ao focar */
                color: #ffffff;
            }

            /* Estilizaçap específica para o input date (icone do calendario) */
            .form-control-custom::-webkit-calendar-picker-indicator {
                filter: invert(0.6); 
                cursor: pointer;
            }

            /* Alinhamento dos BotÃµes */
            .filter-actions {
                display: flex;
                justify-content: flex-end;
                gap: 15px;
                margin-top: 24px;
            }

            /* BotÃ£o Limpar */
            .btn-clear {
                background: transparent;
                color: #ffffff;
                border: 1px solid #2d2d2d;
                border-radius: 8px;
                padding: 10px 30px;
                font-size: 14px;
                cursor: pointer;
                transition: background 0.2s;
            }

            .btn-clear:hover {
                background-color: #1a1a1a;
            }

            /* BotÃ£o Laranja */
            .btn-search {
                background-color: #ff5500; /* Laranja idÃªntico ao da imagem */
                color: #ffffff;
                border: none;
                border-radius: 8px;
                padding: 10px 35px;
                font-size: 14px;
                font-weight: 500;
                cursor: pointer;
                transition: background-color 0.2s;
            }

            .btn-search:hover {
                background-color: #e04b00;
            }
            
        </style>
    </head>
   
    <body>
        <div class="wrapper">

    <!-- SIDEBAR -->
    <aside class="sidebar">

        <div class="logo-area">
            <h2>GRÁFICA</h2>
            <p>Sistema Inteligente</p>
        </div>

        <nav class="nav flex-column menu">
            <!--ð ð ð¥ ð¨-->
            <a class="nav-link" href="home.html">
                Dashboard
            </a>

            <a class="nav-link active" href="controle_pedido?op=CONSULTAR+TODOS">
                Pedidos
            </a>

            <a class="nav-link" href="#">
                Clientes
            </a>

            <a class="nav-link" href="#">
               Produtos
            </a>

        </nav>

        <div class="user-box">
            <small>Usuário</small>
            <h6>Carlos Lima</h6>
            <span>Atendente</span>
        </div>

    </aside>

    <!-- CONTEÃDO -->
    <main class="content">
        <!-- HEADER -->
        <div class="topbar">

            <h1>Pedidos</h1>

            <button class="btn btn-lg btn-novo-pedido" id="abrirModal">+ Novo Pedido</button>

            <dialog id="modalAdicionar" class="modal-pedido">
                <div class="modal-topo">
                    <h2>Novo Pedido</h2>
                        <button class="btn-x" id="fecharModal">
                            <i class="bi bi-x-lg"></i>
                        </button>
                </div>

                <form action="controle_pedido" method="POST">
                    <input type="hidden" name="idPedido" id="idPedido">
                    <div class="row g-3">

                        <div class="col-md-6">
                            <label class="form-label">Cliente</label>
                            <input type="text" class="form-control input-dark" name="cliente" id="cliente">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Funcionário</label>
                            <input type="text" class="form-control input-dark" name="funcionario" id="funcionario">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Data de Entrega</label>
                            <input type="date" class="form-control input-dark" name="data-entrega" id="dataEntrega">
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Valor Total</label>
                            <input type="number" step="0.01" class="form-control input-dark" name="valor-total" id="valorTotal">
                        </div>

                        <div class="col-12">
                            <label class="form-label">Descrição</label>
                            <textarea rows="4" class="form-control input-dark" name="descricao" id="descricao"></textarea>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label">Status</label>

                            <select class="form-select input-dark" name="status" id="status">
                                <option>Orçamento</option>
                                <option>Em Produção</option>
                                <option>Pronto</option>
                                <option>Entregue</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="modal-footer-custom">
                        <button type="button" class="btn btn-outline-secondary" id="cancelarModal"> Cancelar </button>
                        <button type="submit" name="op" value="CADASTRAR" id="btnSalvar" class="btn btn-salvar">Salvar Pedido</button>
                    </div>
                </form>
            </dialog>
        </div> <!--fecha a div topbar-->
    
        <form action="controle_pedido" method="get" name="op">
            <div class="row g-0 mb-4">

                <!--
                <div class="filter-container">
                    <p class="filter-title">FILTROS</p>

                    <div class="row g-3">
                        <div class="col-12 col-md-6 col-lg-3">
                            <label class="form-label-custom">Cliente</label>
                            <input type="text" class="form-control input-dark" name="clienteBuscar" placeholder="Digite o cliente">
                        </div>

                        <div class="col-12 col-md-6 col-lg-3">
                            <label class="form-label-custom">Status</label>
                                <select class="form-select input-dark" name="statusBuscar">
                                    <option>Orçamento</option>
                                    <option>Em Produção</option>
                                    <option>Pronto</option>
                                    <option>Entregue</option>
                                </select>
                        </div>

                        <div class="col-12 col-md-6 col-lg-3">
                            <label class="form-label-custom">Funcionário</label>
                                <input type="text" class="form-control input-dark" name="funcionarioBuscar">
                        </div>

                        <div class="col-12 col-md-6 col-lg-3">
                            <label class="form-label-custom">Data final</label>
                            <input type="date" class="form-control input-dark" name="dataBuscar">
                        </div>
                    </div>

                    <div class="filter-actions">
                        <button type="button" class="btn-clear">Limpar</button>
                        <button type="button" class="btn-search">Buscar</button>
                    </div>
                </div> -->
        </form>

        <!-- TABELA -->
                               
        <div class="card tabela-card">

            <div class="card-header">
                PEDIDOS RECENTES
            </div>

            <div class="table-responsive">

                <table class="table table-dark align-middle">

                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Cliente</th>
                            <th>Funcionário</th>
                            <th>Entrega</th>
                            <th>Total</th>
                            <th>Status</th>
                        </tr>
                    </thead>

                    <tbody>

                        <%
                        if(lista != null){
                            for(Pedido p : lista){
                        %>

                            <tr>

                                <td><%= p.getIdPedido() %></td>

                                <td><%= p.getCliente() %></td>

                                <td><%= p.getFuncionario() %></td>

                                <td><%= p.getDataEntrega() %></td>

                                <td>
                                    <span class="badge bg-warning text-dark">
                                        <%= p.getStatus() %>
                                    </span>
                                </td>

                                <td>
                                    R$ <%= String.format("%.2f", p.getValorTotal()) %>
                                </td>

                                <td>

                                    <button
                                        type="button"
                                        class="btn btn-sm btn-outline-light visualizar"
                                        data-id="<%= p.getIdPedido() %>">
                                        👁
                                    </button>

                                    <button
                                        type="button"
                                        class="btn btn-sm btn-outline-primary editar"
                                        data-id="<%= p.getIdPedido() %>"
                                        data-cliente="<%= p.getCliente() %>"
                                        data-funcionario="<%= p.getFuncionario() %>"
                                        data-data="<%= p.getDataEntrega() %>"
                                        data-valor="<%= p.getValorTotal() %>"
                                        data-descricao="<%= p.getDescricao() %>"
                                        data-status="<%= p.getStatus() %>">

                                        ✏

                                    </button>

                                    <!--<a
                                        href="controle_pedido?op=DELETAR&idPedido=<%= p.getIdPedido() %>"
                                        onclick="return confirm('Deseja realmente excluir este pedido?');">

                                        <button class="btn btn-sm btn-outline-danger" name="op">🗑</button>

                                    </a>-->
                                    <a href="controle_pedido?op=DELETAR&idPedido=<%= p.getIdPedido() %>"
                                        class="btn btn-sm btn-outline-danger"
                                        onclick="return confirm('Deseja realmente excluir este pedido?');">
                                         🗑
                                    </a>

                                </td>

                            </tr>

                        <%
                            }
                        }
                        %>

                        </tbody>

                    </table>

                </div>

            </div>
        </div>

            </main>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
        <script>
            const modal = document.getElementById("modalAdicionar");

            document.getElementById("abrirModal").addEventListener("click", () => {
                modal.showModal();
            });

            document.getElementById("fecharModal").addEventListener("click", () => {
                modal.close();
            });

            document.getElementById("cancelarModal").addEventListener("click", () => {
                modal.close();
                    });
            //Fecha o modal se o usuário clicar no fundo escuro (fora do modal)
            modal.addEventListener('click', (e) => {  //aqui estou testando esse método de função
                if (e.target === modal) {
                    modal.close();
                }
            });
            
         //pós cadastro e edição
            const params = new URLSearchParams(window.location.search);

            if(params.get("sucesso") === "1"){
                alert("Pedido cadastrado com sucesso!");
                window.history.replaceState({}, document.title, window.location.pathname); // Remove ?sucesso=1 da URL sem recarregar a pÃ¡gina
            }
            if(params.get("editado") === "1"){

                alert("Pedido atualizado com sucesso!");

                window.history.replaceState( {}, document.title, window.location.pathname);
            }
            
        //modal editar
        document.querySelectorAll(".editar").forEach(botao => {

            botao.addEventListener("click", function(){

                modal.showModal();

                document.getElementById("idPedido").value = this.dataset.id;
                document.getElementById("cliente").value = this.dataset.cliente;
                document.getElementById("funcionario").value = this.dataset.funcionario;
                document.getElementById("dataEntrega").value = this.dataset.data;
                document.getElementById("valorTotal").value = this.dataset.valor;
                document.getElementById("descricao").value = this.dataset.descricao;
                document.getElementById("status").value = this.dataset.status;
            
                const btn = document.getElementById("btnSalvar");

                btn.innerHTML = "Atualizar Pedido";
                btn.value = "ATUALIZAR";

            });

        });
            
        </script>
    </body>
</html>
