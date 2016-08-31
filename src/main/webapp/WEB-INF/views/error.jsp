<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
			
	<section id="index-section" class="container middle">

	<h2>Erro indeterminado. Entre em contato com o administrador do site</h2>

	<c:forEach items="${exception.stackTrace}" var="stk">
		${stk }
	</c:forEach>

	</section>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>