<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">
	
	<div class="container">
		<br />
	    <a href="${s:mvcUrl('UC#form').build()}">Novo usuário</a>
		<h1>Lista de Usuarios</h1>
		<p> ${sucesso} </p>
		<p> ${falha} </p>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Roles</th>
				<th></th>
			</tr>
			<c:forEach items="${usuarios }" var="usuario">
				<tr>
					<td>${usuario.nome }</a> </td>
					<td>${usuario.email }</td>
					<td>
						<c:forEach items="${usuario.getRoles() }" var="role">
							${role.getAuthority() }, 
						</c:forEach>
					</td>
					<td><a href="${s:mvcUrl('UC#editar').build()}">Editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
		
	</section>
	
</tags:pageTemplate>