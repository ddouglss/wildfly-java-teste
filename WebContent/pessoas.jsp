<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Pessoas</title>
</head>
<body>
    <h1>Pessoas cadastradas</h1>
    <table border="1">
        <tr><th>ID</th><th>Nome</th><th>Idade</th></tr>
        <c:forEach var="p" items="${pessoas}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nome}</td>
                <td>${p.idade}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Adicionar Pessoa</h2>
    <form action="pessoas" method="post">
        Nome: <input type="text" name="nome" required />
        Idade: <input type="number" name="idade" required />
        <input type="submit" value="Adicionar" />
    </form>
</body>
</html>
