package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import model.Pessoa;

@WebServlet("/pessoas")
public class PessoaServlet extends HttpServlet {
    private PessoaDAO dao = new PessoaDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            int idade = Integer.parseInt(req.getParameter("idade"));

            dao.salvar(new Pessoa(nome, idade));
            resp.sendRedirect("pessoas");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<Pessoa> pessoas = dao.listar();
            req.setAttribute("pessoas", pessoas);
            RequestDispatcher rd = req.getRequestDispatcher("pessoas.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

