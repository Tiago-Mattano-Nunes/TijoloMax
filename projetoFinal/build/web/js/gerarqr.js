var qr = qrcode(10, 'M'); // numero tamanho e letra correcao de erro
qr.addData(Math.random().toString());
qr.make();
document.getElementById('qrcode').innerHTML = qr.createImgTag();

//biblioteca de geração de qrcode

//funcao da pra chamar em quaçquer lugar do codigo