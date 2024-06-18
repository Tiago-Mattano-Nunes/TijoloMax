
document.addEventListener("DOMContentLoaded", function () {
    const carrinho = document.getElementById("carrinho");
    const btnAbrir = document.getElementById("btn-abrir-carrinho");
    const btnFechar = document.getElementById("fechar-carrinho");

  

    
});
document.querySelectorAll('.btn-comprar').forEach(btn => {
    btn.addEventListener('click', function () {
        var idProdutos = this.getAttribute('data-id');
        var idUsuario = this.getAttribute('data-idusuario');
        var descricao = this.getAttribute('data-descricao');
        var nome = this.getAttribute('data-nome');
        var preco = this.getAttribute('data-preco');
        var imagens = this.getAttribute('data-imagem');

        // Pegue o valor do input quantidade
        var select = document.getElementById('qtdP');
        var quantidade = select ? select.value : 1; // valor padrão 1 se o select não for encontrado
        
       


        // Crie um novo objeto FormData
        var formData = new FormData();

        // Adicione os dados do produto ao FormData
        formData.append('idProduto', idProdutos);
        formData.append('idUsuario', idUsuario);
        formData.append('descricao', descricao);
        formData.append('nome', nome);
        formData.append('preco', preco);
        formData.append('quantidade', quantidade);



        // Crie um Blob a partir do base64 da imagem
        var byteCharacters = atob(imagens);
        var byteNumbers = new Array(byteCharacters.length);
        for (var i = 0; i < byteCharacters.length; i++) {
            byteNumbers[i] = byteCharacters.charCodeAt(i);
        }
        var byteArray = new Uint8Array(byteNumbers);
        var blob = new Blob([byteArray], {type: 'image/png'});

        // Adicione a imagem ao FormData
        formData.append('imagem', blob, 'imagem.png');

        // Envie o FormData
        fetch('enviarFormulario', {
            method: 'POST',
            body: formData
        })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Ocorreu um erro ao enviar o formulário.');
                    } else {
                        alert('Adicionado ao carrinho.');
                    }
                })
                .catch(error => {
                    console.error('Erro:', error);
                });
    });
});

