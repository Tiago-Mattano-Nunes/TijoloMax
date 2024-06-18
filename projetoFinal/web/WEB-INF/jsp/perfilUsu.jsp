<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <div class="cart-enderecos">

                            <div class="item-enderecos">
                                <h3>Endereço:</h3>
                                <h2>${endereco.idEndereco}</h2>
                            </div>
                            <div class="item-enderecos">
                                <h3>Rua:</h3>
                                <h2>${endereco.rua}</h2>
                            </div>
                            <div class="item-enderecos">
                                <h3>Número:</h3>
                                <h2>${endereco.numero}</h2>
                            </div>
                            <div class="item-enderecos">
                                <h3>Complemento:</h3>
                                <h2>${endereco.complemento}</h2>
                            </div>
                            <div class="item-enderecos">
                                <h3>Cidade:</h3>
                                <h2>${endereco.cidade}</h2>
                            </div>
                            <div class="item-enderecos">
                                <h3>Estado:</h3>
                                <h2>${endereco.estado}</h2>
                            </div>
                            <div class="item-enderecos">
                                <h3>CEP:</h3>   
                                <h2>${endereco.cep}</h2>
                            </div>
                        </div> 
                    </c:forEach> 
                </div>

            </div>
            <br> <br>
            <div class="cart-container">
                <h1>Pedidos:</h1>
                <div class="cart">
                    <div class="cart-items">
                        <c:forEach items="${compras}" var="compra">
                            <div class="cart-item">                      
                                <div class="item-details">
                                    <h2>${compra.nome}</h2>
                                    <p>Quantidade:${compra.quantidade}</p>
                                    <h3>R$ ${compra.preco}</h3>
                                    <p class="price"> </p>
                                </div>
                            </div> 
                        </c:forEach> 
                            <div class="resumo">
                                <h2>Resumo</h2>
                                <p>Total: <span> <c:out value="${totalPreco}"/> </span></p>
                        </div>
                    </div>                                
                </div>
            </div>


        </main>

        <footer>
            <p> Todos Os Direitos Reservados de: Tiago Mattano Nunes dos Santos ©️</p>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    </body>
</html>