package br.com.alura.livraria.servlet;

import br.com.alura.livraria.dao.AutorDao;
import br.com.alura.livraria.factory.ConnectionFactory;
import br.com.alura.livraria.modelo.Autor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {

    private AutorDao dao;

    public AutoresServlet() {
        this.dao = new AutorDao(new ConnectionFactory().getConnection());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("autores", dao.listar());

        req.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        LocalDate nascimento = LocalDate.parse(req.getParameter("nascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String curriculo = req.getParameter("curriculo");

        Autor autor = new Autor(nome, email, nascimento, curriculo);

        dao.cadastrar(autor);

        resp.sendRedirect("autores");
    }
}
