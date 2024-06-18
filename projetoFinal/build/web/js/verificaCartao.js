document.addEventListener('DOMContentLoaded', () => {
    const finalizarBtn = document.getElementById('finalizarBtn');

    finalizarBtn.addEventListener('click', (event) => {
        const nome = document.querySelector('input[name="nome"]').value;
        const numero = document.querySelector('input[name="numero"]').value;
        const cvv = document.querySelector('input[name="cvv"]').value;
        const vencimento = document.querySelector('input[name="vencimento"]').value;

        if (!nome || numero.length !== 16 || cvv.length !== 3 || !vencimento) {
            alert('Por favor, preencha todos os campos corretamente.');
            event.preventDefault(); // Impede o redirecionamento
        } else {
            window.location.href = "./Pagamento"; // Redireciona para a página de pagamento
        }
    });
});
