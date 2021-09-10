<%--
  Created by IntelliJ IDEA.
  User: Bazilio
  Date: 2021-09-02
  Time: 7:49 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Autores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="container">

<h1 class="text-center">CADASTRO DE AUTOR</h1>
<form action="<c:url value="autores"/>" method="POST">
    <div class="form-group">
        <label for="nome">Nome</label>
        <input name="nome" id="nome" type="text" class="form-control">
    </div>
    <div class="form-group">
        <label for="email">E-mail</label>
        <input name="email" id="email" type="email" class="form-control">
    </div>
    <div class="form-group">
        <label for="nascimento">Nascimento</label>
        <input name="nascimento" id="nascimento" type="text" class="form-control">
    </div>
    <div class="form-group">
        <label for="curriculo">Curriculo</label>
        <input name="curriculo" id="curriculo" type="text" class="form-control">
    </div>

    <input type="submit" value="Cadastrar" class="mt-2 btn-primary">
</form>

<h1 class="text-center">LISTA DE AUTORES</h1>
<table class="table table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th>NOME</th>
        <th>E-MAIL</th>
        <th>DATA DE NASCIMENTO</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${autores}" var="a">
        <tr>
            <td>${a.nome}</td>
            <td>${a.email}</td>
            <td>${a.nascimento}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
