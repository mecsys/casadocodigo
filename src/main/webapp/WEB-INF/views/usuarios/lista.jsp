<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">
	
	<a href="/casadocodigo/usuarios/form">Novo usuário</a>
	
	<div class="container">
		<h1>Lista de Usuarios</h1>
		<p> ${sucesso} </p>
		<p> ${falha} </p>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Nome</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${usuarios }" var="usuario">
				<tr>
					<td>${usuario.nome }</a> </td>
					<td>${usuario.email }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		
	</section>
	
</tags:pageTemplate>