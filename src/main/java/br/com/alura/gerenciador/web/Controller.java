package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FazTudo
 */
@WebServlet("/executa")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		if(tarefa == null){
			throw new IllegalArgumentException("Voce esquece de passar a tarefa");
		}
		try {
			tarefa ="br.com.alura.gerenciador.web." + tarefa;
			Class<?> tipo = Class.forName(tarefa);
			Tarefa instancia;
			instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(req, resp);
			RequestDispatcher dispacher = req.getRequestDispatcher(pagina);
			dispacher.forward(req, resp);
		} catch (InstantiationException | IllegalAccessException  | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
}
