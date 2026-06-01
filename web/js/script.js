//Código para data 
const dataAtual = document.getElementById("dataAtual");

const hoje = new Date();

dataAtual.innerText = hoje.toLocaleDateString("pt-BR", {
    weekday: "long",
    year: "numeric",
    month: "long",
    day: "numeric"
});

//Cógido do popup (modal) de adicionar pedidos
/*
const modal = document.getElementById('modalAdicionar');
        const btnAbrir = document.getElementById('abrirModal');
        const btnFechar = document.getElementById('fecharModal');

        // Abre o modal ao clicar no botão de abertura
        btnAbrir.addEventListener('click', () => {
            modal.showModal();
        });

        // Fecha o modal ao clicar no botão de fechamento
        btnFechar.addEventListener('click', () => {
            modal.close();
        });

        // Opcional: Fecha o modal se o usuário clicar no fundo escuro (fora do modal)
        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.close();
            }
        });*/
