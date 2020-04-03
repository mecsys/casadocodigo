<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">
		
		<div class="container">
		<h1>Lista de Pedidos</h1>
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
					<td>${pedido.getDataFormatada() }</td>
					<td>${pedido.produtos[0].titulo }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		
	</section>
	
</tags:pageTemplate>
