<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.bean.Produtos" %>
<%@ page import="model.DAO.ProdutosDAO" %>
<%@ page import="model.bean.Cadastro" %>
<%@ page import="model.DAO.CadastroDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="pt_BR" />
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./assets/Imagem_do_WhatsApp_de_2024-06-26_à_s__00.47.52_72c1f895-removebg-preview.png">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/446d1f4167.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./styles/pUnico.css">
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css"> 
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
                <a href="./Index"><i class="fa-solid fa-chevron-left">Voltar</i></a>
            </div>
        </header>
        <br>
        <main>
            <p>Sobre o Produto:</p>
            <div class="container">
                <c:forEach items="${produtos}" var="produto">
                    <div id="produto_${produto.idProdutos}" class="product">
                        <div class="product-images">
                            <img id="mainImage" src="data:image/png;base64,${produto.imagemBase64}" alt="Imagem Principal">

                        </div>
                        <div class="product-details">
                            <h2 class="nomeProduto"> ${produto.nomeProdutos}  </h2>
                            <p>${produto.descricao}</p>
                            <div class="price">
                                <p><fmt:formatNumber value="${produto.preco}" type="currency" minFractionDigits="2" maxFractionDigits="2" /></p>
                            </div>

                            <div class="qtdP">
                                <p>Quantidade</p>
                                <select id="qtdP" required>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                            </div>
                            <input id="inputIvissivel" type="hidden" value="${produto.quantidade}">

                            <div class="actions">
                                <button class="btn-comprar" type="submit" data-id="${produto.idProdutos}" data-descricao="${produto.descricao}" data-nome="${produto.nomeProdutos}" data-preco="${produto.preco}" data-idusuario="${abacate}" data-imagem="${produto.imagemBase64}"
                                        data-quantidade=1 id="comprar">
                                    <i class="fa-solid fa-basket-shopping"></i>ADICIONAR AO CARRINHO</button>
                            </div>
                        </div>
                    </div>

                </c:forEach>
                <form id="form-comprar" action="enviarFormulario" method="post" enctype="multipart/form-data" style="display: none;">
                    <input type="hidden" name="idProduto" id="idProduto">
                    <input type="hidden" name="descricao" id="descricao">
                    <input type="hidden" name="nome" id="nome">
                    <input type="hidden" name="preco" id="preco">
                    <input type="file" name="imagem" id="imagem">
                    <input type="hider" name="quantidade" id="quantidade">

                </form>
            </div>
        </main>



        <br><br>

        <footer>
            <p> Todos Os Direitos Reservados de: Tiago Mattano N. ©️ / email: dedentep1@gmail.com</p>

        </footer>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>      
        <script src="js/produtos.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>

</html>