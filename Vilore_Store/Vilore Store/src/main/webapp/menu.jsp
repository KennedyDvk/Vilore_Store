<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<nav class="navbar navbar-expand-lg navbar-dark" id="navi">
  
  <a class="navbar-brand"  href="home.jsp">Vilore Products Store</a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
<%@ include file="header.jsp" %>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="produto?acao=abrir-form-cadastro">Novo produto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="produto?acao=listar">Lista Produtos</a>
      </li>
    </ul>
    
  </div>
  <c:if test="${not empty user }">
    		<span class="navbar-text">
	    		${user }
	    		<a href="login" class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
	  	</span>
    </c:if>
</nav>

<c:if test="${empty user }">
	  <span class="navbar-text text-danger" style="margin-right:10px" >
	    ${erro }
	  </span>
	 
	 	
 	<div class="container vh-100 d-flex justify-content-center align-items-center">
      <div class="row">
      	<div class="col">
           <main class="form-signin">  	
			  <form class="form-inline my-2 my-lg-0" action="login" method="post">
			  	 <img class="img-logo " src="./resources/imagem/logo.png" alt="" width="80" height="55">
    			 <h1 class="h6 text-center mb-2 fw-normal">Por Favor, Faca Login</h1>
				 <div class="form-floating mb-3 w-100">
					<input class="form-control" type="text" name="email" placeholder="E-mail">
					<label for="floatingInput">E-mail Address</label>
				</div>
				<div class="form-floating">
					<input class="form-control" type="password" name="senha" placeholder="Senha">
					<label for="floatingPassword">Senha</label>
				</div>
				<div class="checkbox mb-3">
              		<label>
                	<input type="checkbox" value="remember-me"> Lembre-me
              		</label>
              		<a href="#">ainda nao e Membro? Cadastre-se</a>
           		 </div>
           		 
           		 <button class="w-100  btn  btn-warning " id="bt" type="submit">Entrar</button>
            	 <p class="mt-5 mb-3 text-muted">&copy; 2017 2022</p>
			</form>
		  </main>
       </div>
     </div>
   </div>
	
</c:if>
    