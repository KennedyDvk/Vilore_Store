<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produto</title>
<%@ include file="header.jsp" %>
</head>
<body>

<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Produtos</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<table class="table  table-striped table-hover" id="table">
			<tr>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Valor</th>		
				<th>Data de Fabricação</th>	
				<th>Categoria</th>	
				<th></th>
			</tr>
			<c:forEach items="${produtos }" var="p">
				<tr>
					<td>${p.nome}</td>
					<td>${p.quantidade}</td>
					<td>${p.valor}</td>
					<td>
						<fmt:formatDate value="${p.dataFabricacao.time }" pattern="dd/MM/yyyy"/>
					</td>
					<td>${p.categoria.nome}</td>
					<td>
						<c:url value="produto" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="codigo" value="${p.codigo }"/>
						</c:url>
						<a href="${link}" class="btn btn-primary btn-xs">Editar</a>
						<button type="button" class="btn btn-danger btn-xs" data-bs-toggle="modal" data-bs-target="#exampleModal"
						onclick="codigoExcluir.value = ${p.codigo}">
    					Excluir
						</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<%@ include file="footer.jsp" %>

  
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <p>Deseja Realmente excluir?</p>
        </div>
        <div class="modal-footer">
      	<form action="produto" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigo" id="codigoExcluir">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
      </div>
    </div>
  </div>
  
  

</body>
</html>