<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:url value="/" var="contextPath" />

<link rel="stylesheet"
	href="${contextPath}resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${contextPath}resources/css/bootstrap-theme.min.css">

<meta charset=UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais -
	Casa do Código</title>
</head>

<body>

	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa
				do Código</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${s:mvcUrl('PC#listar').build() }">Lista de
						Produtos</a></li>
				<%-- 				<li><a href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a></li> --%>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	</nav>

	<div class="container">
	
		<h3>Cadastro de Usuário</h3>
	
		<form:form class="form-horizontal" action="${s:mvcUrl('UC#criaUsuario').build()}" method="post">

			<div class="form-group">
				<label class="control-label col-sm-2 ">
					<s:message code="usuario.email" />:
				</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" name="email"></input>
				</div> 
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2 "> 
					<s:message code="usuario.nome" />:
				</label> 
				<div class="col-sm-5">
					<input type="text" class="form-control" name="nome"></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2 ">
					<s:message code="usuario.senha" />:
				</label> 
				<div class="col-sm-5">
					<input type="password" class="form-control" name="senha"></input>
				</div>
			</div>
			
			<div class="form-group">
			<label class="control-label col-sm-2 ">
					<s:message	code="usuario.confirmar.senha" />:
				</label> 
				<div class="col-sm-5">
					<input type="password" class="form-control" name="senha"></input>
				</div>
			</div>
				
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">
					<s:message code="usuario.cadastrar" />
				</button>
			</div>
		</div>

		</form:form>
	</div>
</body>
</html>
