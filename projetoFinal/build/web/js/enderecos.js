document.getElementById('linkVoltar').addEventListener('click', function (event) {
    var selectElement = document.getElementById('inputGroupSelect01');
    if (selectElement.options.length === 0) {
        event.preventDefault(); // Impede a navegação
        alert('Nenhum endereço cadastrado. Por favor, adicione um endereço antes de prosseguir.');
    }
});