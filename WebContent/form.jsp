<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cadastro de Pessoa</title>
</head>
<body>
    <h2>Cadastrar Pessoa</h2>
    <form method="post" action="pessoas">
        Nome: <input type="text" name="nome" required><br>
        Idade: <input type="number" name="idade" required><br>
        <button type="submit">Cadastrar</button>
    </form>
    <a href="pessoas">Ver lista de pessoas</a>
</body>
</html>
