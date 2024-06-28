$("#cep").mask("00000000", {reverse: true});
$("#cvv").mask("000");
$("#numeroC").mask("0000000000000000");
$("#numero").mask("0000");

$(document).ready(function () {
   
    $('#vencimento').mask('00/00', {
        onComplete: function (cep) {
           
            const parts = cep.split('/'); //gera a barrinha
            const mes = parseInt(parts[0], 10); //converte a parte do mes pra numero inteiro
            const ano = parseInt(parts[1], 10); //converte a parte do ano pra numero inteiro

            if (mes < 1 || mes > 12) {
                alert('Mês inválido.');
                $('#vencimento').val('');
            } else if (ano < new Date().getFullYear() % 100) {
                alert('Ano inválido.');
                $('#vencimento').val('');
            }
        }
    });
});

$(document).ready(function () {

    $('#cidade').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z]/, recursive: true}
        }
    });
});

$(document).ready(function () {

    $('#rua').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z]/, recursive: true}
        }
    });
});

$(document).ready(function () {

    $('#estado').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z]/, recursive: true}
        }
    });
});

$(document).ready(function () {

    $('#complemento').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z0-9\s]/, recursive: true}
        }
    });


    $('#complemento').on('input', function () {
        if (this.value.startsWith(' ')) {  //nao pode comecar com espaço
            this.value = this.value.trimStart();
        }
    });
});

$(document).ready(function () {

    $('#nome').mask('A', {
        translation: {
            'A': {pattern: /[A-Za-z\s]/, recursive: true}//aceita letras e espaços
        }
    });

    $('#nome').on('input', function () {//nao pode espaço no começo
        if (this.value.startsWith(' ')) {
            this.value = this.value.trimStart();
        }
    });
});