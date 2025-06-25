package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Pessoa;
import repository.Agenda;

public class PessoaServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		String nome = req.getParameter("nome");
		int idade = Integer.parseInt(req.getParameter("idade"));
		
		Pessoa novaPessoa = new Pessoa(nome, idade);
		Agenda.adicionar(novaPessoa);
		
		resp.sendRedirect("pessoas");	
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		List<Pessoa> lista =Agenda.listar();
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<h1>Lista de Pessoas</h1>");
	    resp.getWriter().println("<form method='post'>");
	    resp.getWriter().println("Nome: <input name='nome'><br>");
	    resp.getWriter().println("Idade: <input name='idade' type='number'><br>");
	    resp.getWriter().println("<button type='submit'>Adicionar</button>");
	    resp.getWriter().println("</form><hr>");
	    
	    	for (Pessoa p : lista) {
	    		resp.getWriter().println("<p>" + p.getNome() + "-" + p.getIdade() + " anos</p>");
	    	}
		
	}

}
