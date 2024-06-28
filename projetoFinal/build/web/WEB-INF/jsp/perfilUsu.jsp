<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="pt_BR"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./assets/Imagem_do_WhatsApp_de_2024-06-26_à_s__00.47.52_72c1f895-removebg-preview.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/pusu.css?v=<?= time() ?>" />
        <script src="https://kit.fontawesome.com/446d1f4167.js" crossorigin="anonymous"></script>
    </head>

    <body>



        <header>
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <img src="./assets/Imagem do WhatsApp de 2024-06-26 à(s) 00.47.52_72c1f895.jpg" alt="">

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">


                            <li class="nav-item">

                                <a class="navbar-brand" href="./Index"> <i class="fa-solid fa-house"></i>Home</a>
                            </li>

                            <li class="nav-item">

                                <a class="navbar-brand" aria-current="page" href="./Sobrenos"><i class="fa-solid fa-glasses"></i>Sobre Nós</a>
                            </li>

                            <li class="nav-item dropdown">

                                <a class="navbar-brand dropdown-toggle" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fa-solid fa-hand-point-up"></i>Categorias
                                </a>
                                <ul class="dropdown-menu">
                                    <li><div>                      
                                            <c:forEach items="${categoria}" var="catG"> 
                                                <a  href="./Categoria?id=${catG.idCategoria}"> 
                                                    <option value="${catG.idCategoria}">${catG.nome}</option>
                                                </a>
                                            </c:forEach>
                                        </div></li>                              
                                </ul>

                            </li>

                        </ul>
                        <div class="classi">
                            <a href="./Carrinho"> <i class="fa-solid fa-cart-shopping"></i> </a>
                            <br>
                            <a href="./PerfilUsu"> <i class="fa-solid fa-user"></i> </a>
                        </div>


                        <form class="d-flex" role="search" action="achar" enctype="multipart/form-data"
                              method="post">
                            <input class="form-control me-2" type="search" placeholder="Pesquisar"
                                   aria-label="Pesquisar" name="nomeProdutos">
                            <button class="btn btn-outline-success" type="submit"><i
                                    class="fa-solid fa-magnifying-glass"></i></button>
                        </form>

                    </div>
                </div>
            </nav>
            <br>
            <br>
            <div class="voltar">
                <a href="./Cadastro"><i class="fa-solid fa-chevron-left">LogOut</i></a>
            </div>
            <form action="adms" method="post">
                <button type="submit" class="voltar" name="chamar" value="${usuario.idUsuario}">INÍCIO</button>           
            </form>
            <br> <br>
        </header>

        <main>

            <div class="meio">
                <div class="perfilu">

                    <span>
                        <p>Nome: </p>
                        ${usuario.nome}
                    </span>

                    <span>
                        <p>Email: </p>
                        ${usuario.email}
                    </span>

                    <span>
                        <p>Senha: </p>
                        ${usuario.senha}
                    </span>

                    <span>
                        <p>Telefone: </p>
                        ${usuario.telefone}
                    </span>

                    <span>
                        <p>CPF: </p>
                        ${usuario.cpf}
                    </span>
                </div>
                <br><br><br>


                <div class="enderecos">
                    <c:forEach items="${enderecos}" var="endereco">
                        <div class="enderecosU">

                            <div class="informacoes">
                                <h3>Endereço:</h3>
                                <h2>${endereco.idEndereco}</h2>
                            </div>
                            <div class="informacoes">
                                <h3>Rua:</h3>
                                <h2>${endereco.rua}</h2>
                            </div>
                            <div class="informacoes">
                                <h3>Número:</h3>
                                <h2>${endereco.numero}</h2>
                            </div>
                            <div class="informacoes">
                                <h3>Complemento:</h3>
                                <h2>${endereco.complemento}</h2>
                            </div>
                            <div class="informacoes">
                                <h3>Cidade:</h3>
                                <h2>${endereco.cidade}</h2>
                            </div>
                            <div class="informacoes">
                                <h3>Estado:</h3>
                                <h2>${endereco.estado}</h2>
                            </div>
                            <div class="informacoes">
                                <h3>CEP:</h3>   
                                <h2>${endereco.cep}</h2>
                            </div>
                        </div> 
                    </c:forEach> 
                </div>

                <div class="compras-tudo">
                    <h1>Compras</h1>
                    <div class="compras-1">
                        <div class="comprasu">
                            <c:forEach items="${compras}" var="compra">
                                <div class="compras">                      
                                    <div class="compras-2">
                                        <img src="data:image/png;base64,${compra.imagemBase64}" alt="${compra.nome}">
                                        <h2>${compra.nome}</h2>
                                        <h3>Quantidade:${compra.quantidade}</h3>
                                        <h3> <fmt:formatNumber value="${compra.preco}" type="currency" minFractionDigits="2" maxFractionDigits="2"/></h3>                     
                                        <h3>Descrição: ${compra.descricao}</h3>
                                        <h3>Quantidade<fmt:formatNumber value="${compra.total_preco}" type="currency" minFractionDigits="2" maxFractionDigits="2"/></h3>
                                        <h3>Endereço: ${compra.endereco}</h3>
                                        <p class="preco"> </p>
                                    </div>
                                </div> 
                            </c:forEach> 

                        </div>  
                    </div>
                </div>

            </div>
            <br> <br>







        </main>

        <footer>
            <p> Todos Os Direitos Reservados de: Tiago Mattano N. ©️ / email: dedentep1@gmail.com</p>

        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    </body>
</html>
