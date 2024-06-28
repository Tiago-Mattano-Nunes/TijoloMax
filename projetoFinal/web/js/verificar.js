//aplica mascara e formata os numeros
$("#cpf").mask("00000000000", {reverse: true});
$("#telefone").mask("00000000000");


$(document).ready(function () {

    $('#senha').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z0-9]/, recursive: true}
        }
    });
});

$(document).ready(function () {

    $('#senha2').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z0-9]/, recursive: true}
        }
    });
});


$(document).ready(function () {

    $('#nome').mask('Z', {
        translation: {
            'Z': {pattern: /[A-Za-z]/, recursive: true}
        }
    });
});