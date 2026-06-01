const dataAtual = document.getElementById("dataAtual");

const hoje = new Date();

dataAtual.innerText = hoje.toLocaleDateString("pt-BR", {
    weekday: "long",
    year: "numeric",
    month: "long",
    day: "numeric"
});
