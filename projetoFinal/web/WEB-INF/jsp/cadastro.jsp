<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./assets/Imagem_do_WhatsApp_de_2024-06-26_à_s__00.47.52_72c1f895-removebg-preview.png">
        <link rel="stylesheet" href="./styles/cadastro.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
              integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/446d1f4167.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="content first-content">
                <div class="first-column">

                    <h2 class="title title-primary">Bem Vindo de Volta!</h2>

                    <p class="description description-primary">por favor, faça o login</p>
                    <button id="signin" class="btn btn-primary">Cadastro</button>
                </div>    
                <div class="second-column">
                    <h2 class="title title-second">Fazer Login</h2>

                    <p class="description description-second">Preencha os campos:</p>
                    <form action="logar" class="form" enctype="multipart/form-data" method="get">   

                        <label class="label-input" for="">
                            <i class="fa-regular fa-envelope"></i>
                            <input type="email" id="email" name="email" placeholder="Email" required>
                        </label>

                        <label class="label-input" for="">
                            <i class="fa-solid fa-lock"></i>
                            <input type="password" id="senha" name="senha" placeholder="Senha" maxlength="12" maxrequired>
                        </label>


                        <button class="btn btn-second" type="submit">Logar</button>        
                    </form>
                </div>
            </div>
            <div class="content second-content">
                <div class="first-column">
                    <h2 class="title title-primary">Bem Vindo!</h2>

                    <button id="signup" class="btn btn-primary">login</button>
                </div>
                <div class="second-column">
                    <h2 class="title title-second">Por favor, cadastre-se</h2>

                    <p class="description description-second">Preencha os campos:</p>    
                    <form action="criar" class="form" enctype="multipart/form-data" method="post">
                        <label class="label-input" for="">
                            <i class="fa-solid fa-user"></i>
                            <input name="nome" id="nome" placeholder="Nome" required>
                        </label>
                        <label class="label-input" for="">
                            <i class="fa-solid fa-id-card"></i>
                            <input name="cpf" id="cpf" placeholder="000.000.000-00" maxlength="11" minlength="11" required>
                        </label>
                        <label class="label-input" for="">
                            <i class="fa-solid fa-phone"></i>
                            <input name="telefone" id="telefone" placeholder="Telefone" maxlength="11" minlength="11" required >
                        </label>
                        <label class="label-input" for="">
                            <i class="fa-regular fa-envelope"></i>
                            <input type="email" id="email"  name="email" placeholder="Email" required>
               </label>

                        <label class="label-input" for="">
                            <i class="fa-solid fa-lock"></i>
                            <input type="password" id="senha2" name="senha" placeholder="min 8 carac" minlength="8" maxlength="12"  required>
                        </label>

                       
                        <button  type="submit"class="btn btn-second">Cadastrar</button>
                    </form>
                </div>
            </div> 
        </div>
        <script src="js/cadastro.js"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
        <script src="js/verificar.js"></script>
    </body>
</html>
