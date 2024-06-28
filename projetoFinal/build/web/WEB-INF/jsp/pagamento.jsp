<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="pt_BR" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./assets/Imagem_do_WhatsApp_de_2024-06-26_à_s__00.47.52_72c1f895-removebg-preview.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/pagamento.css?v=<?= time() ?>" />
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
                <a href="./Carrinho"><i class="fa-solid fa-chevron-left">Voltar</i></a>
            </div>
            <br><br>

        </header>

        <main>
            <div class="pagamento">
                <h1>Forma de pagamento</h1>
                <c:if test="${not empty carrinhos}">
                    <a href="./CartaoC" class="pagamentoOpcao">
                        <div class="opcao">
                            <i class="icon">💳</i> Cartão de crédito
                        </div>
                    </a>
                    <a href="./CartaoDebito" class="pagamentoOpcao">
                        <div class="opcao">
                            <i class="icon">💵</i> Cartão de débito
                        </div>
                    </a>
                    <a href="./Pix" class="pagamentoOpcao">
                        <div class="opcao">
                            <i class="icon">💰</i> Pix
                        </div>
                    </a>
                </c:if>
            </div>

            <div class="cart1">
                <h1>Carrinho de Compras</h1>
                <c:if test="${not empty carrinhos}">
                    <div class="cart">
                        <div class="cart2">
                            <c:forEach items="${carrinhos}" var="carrinho">
                                <div class="cart3">
                                    <img src="data:image/png;base64,${carrinho.imagemBase64}" alt="${carrinho.nomeCarrinho}">
                                    <div class="itens">
                                        <h2>${carrinho.nomeCarrinho}</h2>
                                        <p>Quantidade: ${carrinho.quantidadeCarrinho}</p>
                                        <p>Descrição:${carrinho.descricaoCarrinho}</p>
                                        <h3><fmt:formatNumber value="${carrinho.precoCarrinho}" type="currency" minFractionDigits="2" maxFractionDigits="2"/></h3>
                                        <p class="price"></p>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="resumo">
                                <h2>Total: </h2>
                                <span><fmt:formatNumber value="${totalPreco}" type="currency" minFractionDigits="2" maxFractionDigits="2"/></span>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${empty carrinhos}">
                    <p>Carrinho vazio.</p>
                </c:if>
            </div>


        </main>


        <footer>
            <p> Todos Os Direitos Reservados de: Tiago Mattano N. ©️ / email: dedentep1@gmail.com</p>

        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.umd.min.js"></script>
    </body>
</html>
