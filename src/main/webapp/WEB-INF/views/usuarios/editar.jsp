<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="index-section" class="container middle">
	
	<div class="container">
		<h1>Cadastro de Permissões para ${usuario.nome} }</h1>
		<p> ${sucesso} </p>
		<p> ${falha} </p>
	
		<p>Permissoes:
		
			<form:form action="${s:mvcUrl('UC#updateRoles').build() }" method="post"> 
			
			<c:forEach items="${usuario.getRoles() }" var="role">
				<form:checkbox path="role.getNome()"/>
				<label>role.getNome()</label>
			</c:forEach>
			
			<button type="submit" class="btn btn-primary">Atualizar</button>
			</form:form>
			
		</p>
	</div>
		
	</section>
	
</tags:pageTemplate>