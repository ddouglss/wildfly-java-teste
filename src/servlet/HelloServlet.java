package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome = req.getParameter("nome");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<h2>Olá, " + nome + "! Seja bem-vindo </h2>");
	}

}
