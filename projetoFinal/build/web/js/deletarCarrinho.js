document.querySelectorAll('[id^="formDelet-"]').forEach(form => {
    form.addEventListener('submit', function (event) {
        var formData = new FormData(this);
        event.preventDefault();
        fetch('enviarFormularioDelete', {
            method: 'POST',
            body: formData
                  
        })
                .then(response => {
                    if (response.ok) {
                        
                        window.location.href = "./Carrinho"; 
                    } else {
                        throw new Error('Erro ao excluir item do carrinho');
                    }
                })
                .catch(error => {
                    console.error('Erro ao excluir item do carrinho:', error);
               
                });
    });
});