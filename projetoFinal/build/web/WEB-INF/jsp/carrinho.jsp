<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./assets/Preview__1_-removebg-preview.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/carrinho.css?v=<?= time() ?>" />
        <script src="https://kit.fontawesome.com/446d1f4167.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <img src="./assets/Preview__1_-removebg-preview.png" alt="">

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
                            <li class="nav-item">

                                <a class="navbar-brand" href="./Cadastro"><i class="fa-solid fa-right-to-bracket"></i>Login</a>
                            </li>
                            <li class="nav-item dropdown">

                                <a class="navbar-brand dropdown-toggle" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fa-solid fa-hand-point-up"></i>Departamentos
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./Categoria?id=1">Frios</a></li>
                                    <li><a class="dropdown-item" href="./Categoria?id=2">Carnes</a></li>
                                    <li><a class="dropdown-item" href="./Categoria?id=3">Bebidas</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>

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
            <br> <br>
        </header>

        <main>
            <div class="enderecos">
                
                
            

                <form action="calcular" enctype="multipart/form-data" method="post" >
                    <h2>Adicionar endereço:</h2>
                    <h2>Estado:</h2>
                    <input type="text" name="estado" id="imagem" required>

                    <h2>Cidade:</h2>
                    <input type="text" name="cidade" required>

                    <h2>Rua:</h2>
                    <input type="text" name="rua" required>

                    <h2>Cep:</h2>
                    <input type="text" name="cep" required>

                    <h2>Número:</h2>
                    <input type="text" name="numero" required>
                    <h2>Complemento:</h2>
                    <input type="text" name="complemento" required>
                    <br>
                    <input type="hidden"  name="id" value="${usuario.idUsuario}">   
                    <input type="submit" value="Enviar" class="bt-comprar" >

                </form>
                <div>         

                    <h3>Já tem um endereço cadastrado?</h3>
                    <select class="custom-select" id="inputGroupSelect01" name="enderecos">
                        <c:forEach items="${enderecos}" var="endereco">
                            <option>Cidade: ${endereco.cidade} / Rua: ${endereco.rua} </option>

                        </c:forEach>
                    </select>
                    <a id="linkVoltar" href="./Pagamento"> <input type="submit" value="Enviar" class="bt-comprar"  ></a>


                </div>

                <br><br><br>
            </div>



            <div class="cart-container">
                <h1>Carrinho de Compras</h1>
                <div class="cart">
                    <div class="cart-items">
                        <c:forEach items="${carrinhos}" var="carrinho">
                            <div class="cart-item">

                                <img src="data:image/png;base64,${carrinho.imagemBase64}" alt="${carrinho.nomeCarrinho}">
                                <div class="item-details">
                                    <h2>${carrinho.nomeCarrinho}</h2>
                                    <p>Quantidade:${carrinho.quantidadeCarrinho}</p>
                                    <h3>R$ ${carrinho.precoCarrinho}</h3>
                                    <p class="price"> </p>
                                </div>

                            </div> </c:forEach> 
                            <div class="resumo">
                                <h2>Resumo</h2>
                                <p>Total: <span> <c:out value="${totalPreco}"/> </span></p>
                        </div>
                    </div>                                
                </div>
            </div> 

        </div>


        <form id="form-comprar" action="enviarb" method="post" enctype="multipart/form-data"
              style="display: none;">
            <input type="hidden" name="idProduto" id="idProduto">
            <input type="hidden" name="descricao" id="descricao">
            <input type="hidden" name="nome" id="nome">
            <input type="hidden" name="preco" id="preco">
            <input type="file" name="imagem" id="imagem">
            <input type="hidden" name="quantidade" id="quantidade">
        </form>
    </main>

    <footer>
        <p> Todos Os Direitos Reservados de: Tiago Mattano Nunes dos Santos ©️</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
    <script src="js/produtos.js"></script>
    <script src="js/enderecos.js"></script>
</body>

</html>