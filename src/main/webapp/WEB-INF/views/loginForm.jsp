<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:url value="/" var="contextPath" />
	
	<link rel="stylesheet" href="${contextPath}resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${contextPath}resources/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="${contextPath}resources/css/layout-colors.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casa do Código Login</title>
</head>
<body>


	  <header id="layout-header">
		<div class="clearfix">
			<a href="#" id="logo_2"></a>
		</div>
	</header>

	<div class="container" style="height:200px;width:450px; margin-top:50px">


	<form:form Class="form-horizontal" servletRelativeAction="/login" method="post">

		<div cssClass="form-group">
			<label for="email" class="col-sm-2 control-label">Login</label>
		    <div class="col-sm-10">
      			<input class="form-control" id="email" placeholder="Digite seu Email" name="username">
      			<form:errors path="email" />
   			</div>			
		</div>
		
		<div cssClass="form-group">
			<label for="password" class="col-sm-2 control-label">Senha</label>
		    <div class="col-sm-10">
      			<input type="password" class="form-control" id="password" placeholder="Digite sua Senha" name="password">
   			</div>
		</div>

		<div cssClass="form-group">
			<div class="col-sm-10">
      		<button type="submit" class="btn">Logar</button>
   			</div>
		</div>		
	
	</form:form>
</div>


</body>
</html>