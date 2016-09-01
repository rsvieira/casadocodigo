<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<%-- 	<form action="cadastrar" method="post"> --%>

	<%-- 	<form:form action="cadastrar" method="post" commandName="produto"> --%>

	<!-- 	bizarro isso -->

	<div class="container">

		<h2>Adicionar Livro</h2>

		<form:form action="${s:mvcUrl('PC#cadastrar').build()}" method="post"
			commandName="produto" enctype="multipart/form-data"
			cssClass="form-horizontal">

			<dir class="form-group">
				<label class="col-sm-1">Título</label>
				<div class="col-sm-6">
					<form:input path="titulo" cssClass="form-control" />
					<br />
					<form:errors path="titulo" />
				</div>
			</dir>

			<dir class="form-group">
				<label class="col-sm-1">Descrição</label>
				<div class="col-sm-6">
					<form:textarea path="descricao" cssClass="form-control" />
					<br />
					<form:errors path="descricao" />
				</div>
			</dir>

			<dir class="form-group">
				<label class="col-sm-1">Páginas</label>
				<div class="col-sm-6">
					<form:input path="paginas" cssClass="form-control" />
					<br />
					<form:errors path="paginas" />
				</div>
			</dir>

			<dir class="form-group">
				<label class="col-sm-1">Data Lançamento</label>
				<div class="col-sm-6">
					<form:input path="dataLancamento" cssClass="form-control" />
					<br />
					<form:errors path="dataLancamento" />
					<br />
				</div>
			</dir>

			<div id="foreach" style="padding-left: 40px;">
				<c:forEach items="${listPrecos}" var="preco" varStatus="status">
					<div class="form-group">
						<label class="col-sm-1">${preco}</label>
						<div class="col-sm-6">
							<form:input path="precos[${status.index}].valor"
								cssClass="form-control" />
							<form:hidden value="${preco}"
								path="precos[${status.index}].tipoPreco" />
						</div>
						<br />
					</div>
				</c:forEach>
			</div>

<!-- 			<div style="padding-left: 40px;"> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label class="col-sm-1">Súmario</label> -->
<!-- 					<div class="col-sm-6"> -->
<!-- 						<input type="file" name="sumario" class="form-control" /> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

			<br />
			<br />
			<div style="padding-left: 40px;">
				<div class="form-group" style="padding-left: 300px;">
					<button type="submit" class="btn btn-default">Cadastrar</button>
				</div>
			</div>

		</form:form>

	</div>

</body>
</html>
