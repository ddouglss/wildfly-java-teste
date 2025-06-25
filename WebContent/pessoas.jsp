<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, model.Pessoa" %>
<html>
<head>
    <title>Lista de Pessoas</title>
</head>
<body>
    <h2>Lista de Pessoas</h2>
    <a href="form.jsp">Cadastrar nova pessoa</a>
    <hr>
    <%
        List<Pessoa> lista = (List<Pessoa>) request.getAttribute("pessoas");
        if (lista != null) {
            for (Pessoa p : lista) {
    %>
        <p><strong><%= p.getNome() %></strong> - <%= p.getIdade() %> anos</p>
    <%
            }
        }
    %>
</body>
</html>
