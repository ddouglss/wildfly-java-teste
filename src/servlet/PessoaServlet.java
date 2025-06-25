package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Pessoa;
import repository.Agenda;

@WebServlet("/pessoas")
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
		req.setAttribute("pessoas", lista);
		RequestDispatcher dispatcher = req.getRequestDispatcher("pessoas.jsp");
		dispatcher.forward(req, resp);
	}

}
