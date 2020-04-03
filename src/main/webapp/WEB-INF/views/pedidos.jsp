<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">
		
		<div class="container">
		<h1>Lista de Pedidos atuais</h1>
		<p> ${sucesso} </p>
		<p> ${falha} </p>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>Valor</th>
				<th>Data Pedido</th> 
				<th>Titulos</th>
			</tr>
			<c:forEach items="${pedidos }" var="pedido">
				<tr>
					<td>${pedido.id }</td>
					<td>${pedido.valor }</td>
					<td><fmt:formatDate value="${pedido.data.time }" pattern="dd/MM/yy"/></td>
					<td>
						<c:forEach items="${pedido.produtos }" var="produto">
							${produto.titulo }, 
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		
	</section>
	
</tags:pageTemplate>
