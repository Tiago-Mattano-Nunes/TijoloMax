$(document).ready(function () {
    $('#nome').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z0-9]/, recursive: true}
        }
    });
});

//letra e espaço
$(document).ready(function () {
    $('#nomeP').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z0-9 ]/, recursive: true}
        }
    });

    $('#nomeP').on('input', function () {
        var value = $(this).val();
        if (value.startsWith(' ')) {
            $(this).val(value.trimStart());
        }
    });
});

//numero e ponto
$(document).ready(function () {
    $('#valor').mask('00000.00', {reverse: true});
});

//nomero e letra 
$(document).ready(function () {
    $('#descricao').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z0-9\s\/\\]/, recursive: true}
        }
    });

    $('#descricao').on('input', function () {
        if (this.value.startsWith(' ')) {  // nao pode começar com espaço
            this.value = this.value.trimStart();
        }
    });
});



//só numero
$('#quantidade').mask('00000', {reverse: true});

//mascaras
//reverse é de traz pra frente
//recursive me deixa escrever