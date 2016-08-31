<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:url value="/" var="contextPath" />
	  <meta charset="utf-8"/>
		  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
		<link rel="icon"
			href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979"
			type="image/ico" />
		<link href="https://plus.googlecom/108540024862647200608"
			rel="publisher"/>
		<title>Livros de Java, SOA, Android, iPhone, Ruby on Rails e
			muito mais - Casa do Código</title>
		<link href="${contextPath}resources/css/cssbase-min.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
			rel='stylesheet'/>
		<link href="${contextPath}resources/css/fonts.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/fontello-ie7.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/fontello-embedded.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/fontello.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/style.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/layout-colors.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/responsive-style.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/guia-do-programador-style.css" 
			rel="stylesheet" type="text/css"  media="all"  />
	    <link href="${contextPath}resources/css/produtos.css" 
	    	rel="stylesheet" type="text/css"  media="all"  />
		<link rel="canonical" href="http://www.casadocodigo.com.br/" />	
		<link href="${contextPath}resources/css/book-collection.css"
				rel="stylesheet" type="text/css" media="all" />
</head>
<body>

  <header id="layout-header">
	  
		<div class="clearfix container">
			<a href="${s:mvcUrl('HC#index').build() }" id="logo"></a>
			<div id="header-content">
				<nav id="main-nav">
					<ul class="clearfix">
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="${s:mvcUrl('PC#listar').build() }" rel="nofollow">
								<label style="font-size:18px">Lista de produtos</label> 
							</a>
						</li>
						<li><a href="${s:mvcUrl('PC#form').build() }" rel="nofollow">
								<label style="font-size:18px">Cadastrar Livro</label>
							</a>
						</li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li>
							<a href="${s:mvcUrl('CCC#itens').build()}" rel="nofollow"> 
                                <label style="font-size:18px">
									<s:message code="menu.carrinho" arguments="${carrinhoCompras.quantidade}"/>
								</label>
                            </a>
						</li>
					</security:authorize>	
						<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">
								<label style="font-size:18px">Sobre Nós</label>
							</a>
						</li>
						<li><a href="?locale=pt" rel="nofollow">
								<label style="font-size:18px">
								<s:message code="menu.pt"/>
								</label>
							</a>
						</li>
						<li><a href="?locale=en_US" rel="nofollow">
								<label style="font-size:18px">
								<s:message code="menu.en"/>
								</label>
							</a>
						</li>
					<security:authorize access="isAuthenticated()">	
						<li><a href="#">
								<security:authentication var="usuario" property="principal"/>
								<label style="font-size:18px">
									${usuario.username}
								</label>	
							</a>
						</li>
						<li><a href="${s:mvcUrl('LC#logout').build() }">
								<label style="font-size:18px">
									Sair
								</label>	
							</a>
						</li>
					</security:authorize>	
					</ul>
				</nav>
			</div>
		</div>
	</header>
	
	<nav class="categories-nav">
		<ul class="container">
			<li class="category"><a href="http://www.casadocodigo.com.br">
				<s:message code="navegacao.categoria.home"/></a></li>
			<li class="category"><a href="/collections/livros-de-agile">
				<s:message code="navegacao.categoria.agile"/></a></li>
			<li class="category"><a href="/collections/livros-de-front-end">
				<s:message code="navegacao.categoria.front_end"/></a></li>
			<li class="category"><a href="/collections/livros-de-games">
				<s:message code="navegacao.categoria.games"/></a></li>
			<li class="category"><a href="/collections/livros-de-java">
				<s:message code="navegacao.categoria.java"/></a></li>
			<li class="category"><a href="/collections/livros-de-mobile">
				<s:message code="navegacao.categoria.mobile"/></a></li>
			<li class="category"><a
				href="/collections/livros-desenvolvimento-web">
				<s:message code="navegacao.categoria.web"/></a></li>
			<li class="category"><a href="/collections/outros">
				<s:message code="navegacao.categoria.outros"/></a></li>
		</ul>
	</nav>