document.querySelectorAll('.btn-comprar').forEach(btn => {
    btn.addEventListener('click', function () {
        //obtem os atributos
        var idProduto = this.getAttribute('data-id');
        var idUsuario = this.getAttribute('data-idusuario');
        var descricao = this.getAttribute('data-descricao');
        var nome = this.getAttribute('data-nome');
        var preco = this.getAttribute('data-preco');
        var imagens = this.getAttribute('data-imagem');


//quantidade do produto e estoque
        var selectQuantidade = this.closest('.product-details').querySelector('#qtdP');
        var quantidade = selectQuantidade ? parseInt(selectQuantidade.value) : null;
        var inputInvissivel = this.closest('.product-details').querySelector('#inputIvissivel');
        var quantidadeEstoque = parseInt(inputInvissivel.value);
   
   //verifica se a quantidade 
        if (quantidade > quantidadeEstoque) {
            alert("Produto em falta. A quantidade máxima é:" + quantidadeEstoque);
            return;
        }

        var formData = new FormData();

        formData.append('idProduto', idProduto);
        formData.append('idUsuario', idUsuario);
        formData.append('descricao', descricao);
        formData.append('nome', nome);
        formData.append('preco', preco);
        formData.append('quantidade', quantidade);

        var byteC = atob(imagens);
        var byteN = new Array(byteC.length);
        for (var i = 0; i < byteC.length; i++) {
            byteN[i] = byteC.charCodeAt(i);
        }
        var byteArray = new Uint8Array(byteN);
        var blob = new Blob([byteArray], {type: 'image/png'});

        formData.append('imagem', blob, 'imagem.png');

        fetch('enviarFormulario', {
            method: 'POST',
            body: formData
        })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Ocorreu um erro ao enviar o formulário.');
                    }

                    alert("Item adicionado no carrinho");
                    location.reload();
                })
                .catch(error => {
                    console.error('Erro:', error);
                });
    });
});
//Veirifica a quantidade e manda pro carrinho