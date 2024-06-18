<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.min.css" rel="stylesheet" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./assets/Preview__1_-removebg-preview.png">
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
            <br><br>

        </header>

        <main>



            <div class="container py-5">

                <!-- For demo purpose -->
                <div class="row mb-4">
                    <div class="col-lg-8 mx-auto text-center">
                        <h1 class="display-4">Bootstrap 4 credit card form</h1>
                        <p class="lead mb-0">Easily build a well-structured credit card form using Bootstrap 4</p>
                        <p class="lead">Snippet by <a href="https://bootstrapious.com/snippets">Bootstrapious</a></p>
                    </div>
                </div>
                <!-- End -->


                <div class="row">
                    <div class="col-lg-7 mx-auto">
                        <div class="bg-white rounded-lg shadow-sm p-5">
                            <!-- Credit card form tabs -->
                            <ul role="tablist" class="nav bg-light nav-pills rounded-pill nav-fill mb-3">
                                <li class="nav-item">
                                    <a data-toggle="pill" href="#nav-tab-card" class="nav-link active rounded-pill">
                                        <i class="fa fa-credit-card"></i>
                                        Credit Card
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a data-toggle="pill" href="#nav-tab-paypal" class="nav-link rounded-pill">
                                        <i class="fa fa-paypal"></i>
                                        Paypal
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a data-toggle="pill" href="#nav-tab-bank" class="nav-link rounded-pill">
                                        <i class="fa fa-university"></i>
                                        Bank Transfer
                                    </a>
                                </li>
                            </ul>
                            <!-- End -->


                            <!-- Credit card form content -->
                            <div class="tab-content">

                                <!-- credit card info-->
                                <div id="nav-tab-card" class="tab-pane fade show active">
                                    <p class="alert alert-success">Some text success or error</p>
                                    <form role="form">
                                        <div class="form-group">
                                            <label for="username">Full name (on the card)</label>
                                            <input type="text" name="username" placeholder="Jason Doe" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="cardNumber">Card number</label>
                                            <div class="input-group">
                                                <input type="text" name="cardNumber" placeholder="Your card number" class="form-control" required>
                                                <div class="input-group-append">
                                                    <span class="input-group-text text-muted">
                                                        <i class="fa fa-cc-visa mx-1"></i>
                                                        <i class="fa fa-cc-amex mx-1"></i>
                                                        <i class="fa fa-cc-mastercard mx-1"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-8">
                                                <div class="form-group">
                                                    <label><span class="hidden-xs">Expiration</span></label>
                                                    <div class="input-group">
                                                        <input type="number" placeholder="MM" name="" class="form-control" required>
                                                        <input type="number" placeholder="YY" name="" class="form-control" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="form-group mb-4">
                                                    <label data-toggle="tooltip" title="Three-digits code on the back of your card">CVV
                                                        <i class="fa fa-question-circle"></i>
                                                    </label>
                                                    <input type="text" required class="form-control">
                                                </div>
                                            </div>



                                        </div>
                                        <button type="button" class="subscribe btn btn-primary btn-block rounded-pill shadow-sm"> Confirm  </button>
                                    </form>
                                </div>
                                <!-- End -->

                                <!-- Paypal info -->
                                <div id="nav-tab-paypal" class="tab-pane fade">
                                    <p>Paypal is easiest way to pay online</p>
                                    <p>
                                        <button type="button" class="btn btn-primary rounded-pill"><i class="fa fa-paypal mr-2"></i> Log into my Paypal</button>
                                    </p>
                                    <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                    </p>
                                </div>
                                <!-- End -->

                                <!-- bank transfer info -->
                                <div id="nav-tab-bank" class="tab-pane fade">
                                    <h6>Bank account details</h6>
                                    <dl>
                                        <dt>Bank</dt>
                                        <dd> THE WORLD BANK</dd>
                                    </dl>
                                    <dl>
                                        <dt>Account number</dt>
                                        <dd>7775877975</dd>
                                    </dl>
                                    <dl>
                                        <dt>IBAN</dt>
                                        <dd>CZ7775877975656</dd>
                                    </dl>
                                    <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                    </p>
                                </div>
                                <!-- End -->
                            </div>
                            <!-- End -->

                        </div>
                    </div>
                </div>
            </div>


            <div class="payment-container">
                <h1>Forma de pagamento</h1>
                <a href="./CartaoC">
                    <div class="payment-option">  

                        <div class="option-left">
                            <i class="icon">💳</i> Cartão de crédito

                        </div>

                    </div>
                </a>
                <a href="./CartaoDebito"> 
                    <div class="payment-option">
                        <div class="option-left">
                            <i class="icon">💵</i> Cartão de débito 

                        </div>
                    </div>
                </a>  
                <a href="./Pix">   
                    <div class="payment-option">
                        <div class="option-left">
                            <i class="icon">💰</i> Pix                      
                        </div>          
                    </div>
                </a> 

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

        </main>


        <footer>
            <p> Todos Os Direitos Reservados de: Tiago Mattano Nunes dos Santos ©️</p>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.umd.min.js"></script>
        <script src="js/pagamento.js"></script>
    </body>
</html>
