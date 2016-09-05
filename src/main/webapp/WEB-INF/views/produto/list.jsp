<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css">

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
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa do Código</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
<%-- 				<li><a href="${s:mvcUrl('PC#listar').build() }">Lista de Produtos</a></li> --%>
				<li><a href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	</nav>

	<dir class="container">

		<h2>Lista de Produtos</h2>

		<div style="margin-bottom: 15px">
			<label style="color: red">${message}</label>
		</div>

		<table
			class="table table-border table-striped table-bordered table-hover table-condensed">
			<tr style="background: lightgray;">
				<th>Título</th>
				<th>Descrição</th>
				<th>Páginas</th>
			</tr>

			<c:forEach items="${listaProdutos}" var="produto">
				<tr>
					<td><a
						href="${s:mvcUrl('PC#detalhar').arg(0,produto.id).build() }">${produto.titulo}</a>
					</td>
					<td>${produto.descricao}</td>
					<td>${produto.paginas}</td>
				</tr>
			</c:forEach>

		</table>

	</dir>
</body>
</html>