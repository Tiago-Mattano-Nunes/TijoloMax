<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./assets/Preview__1_-removebg-preview.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/sobrenos.css" />       
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
                           
                            <li class="nav-item dropdown">

                                <a class="navbar-brand dropdown-toggle" href="#" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fa-solid fa-hand-point-up"></i>Departamentos
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
                            <a href="./Carrinho?id=${usuario.idUsuario}"> <i class="fa-solid fa-cart-shopping"></i> </a>
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

            <br> 
            <br>
        </header>   

        <main>
            <p>
                Bem-vindo ao TijoloMax, seu destino online para uma experiência de compras excepcional. Desde a nossa fundação, buscamos revolucionar a forma como você compra e interage com o mundo dos produtos e serviços.

                No TijoloMax, entendemos que a vida é movida pela conveniência e pela busca incessante por excelência. É por isso que nos dedicamos a oferecer uma plataforma que não apenas simplifica sua jornada de compras, mas também a enriquece com opções diversificadas e oportunidades emocionantes.
            </p>
        </main>

        <footer>
            <p> Todos Os Direitos Reservados de: Tiago Mattano Nunes dos Santos ©️ / email: dedentep1@gmail.com</p>

        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    </body>
</html>
