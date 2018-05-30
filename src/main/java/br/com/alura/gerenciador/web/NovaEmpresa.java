package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns ="/novaEmpresa")
public class NovaEmpresa  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Empresa em = new Empresa(nome);
		new EmpresaDAO().adiciona(em);
		req.setAttribute("empresa",em);
		req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp").forward(req, resp);

	}
}
