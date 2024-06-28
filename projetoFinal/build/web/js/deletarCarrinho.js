//Requisicao de exclusao.
// Seleciona todos os elementos que têm um ID "formDelet-" , faz uma requisicao pra excluir do carrinho.
document.querySelectorAll('[id^="formDelet-"]').forEach(form => {
    //adiciona listener pro submit
    form.addEventListener('submit', function (event) {
        // Cria um FormData a partir do formulário enviado
        var formData = new FormData(this); // é uma API, permite criar objetos que representam conjuntos de  chave/valor,  podem ser enviados em uma requisição HTTP
        event.preventDefault();

//metodo, faz requisisao pra deletar carrinho no post
        fetch('deletarCarrinho', {
            method: 'POST',
            body: formData
        })
     //resposta
        .then(response => {
 //verifica se foi bem sucedido           
            if (response.ok) {

                window.location.href = "./Carrinho"; 
            } else {
                
                throw new Error('Erro ao excluir');
            }
        })
        
        //captura erro durante o fetch e exibe a msg
        .catch(error => {
           
            console.error('Erro ao excluir:', error);
        });
    });
});
//solicita uma requisicao para deletar um item do carrinho