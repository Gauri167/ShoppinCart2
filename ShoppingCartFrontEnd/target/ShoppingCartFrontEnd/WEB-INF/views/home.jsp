<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<center>
<h2>Welcome to Shopping Cart</h2>
</center>

<hr color="blue" size="5">

<a href="login">Login</a>
<a href="signUp">Sign-Up</a>

<jsp:include page="product_menu.jsp"></jsp:include>

${welcomeMessage}
${errorMessage}
${categories}
<c:if test="${UserClickedLogin==true}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedSignUp==true}">
<jsp:include page="signUp.jsp"></jsp:include>
</c:if>

</body>
</html>