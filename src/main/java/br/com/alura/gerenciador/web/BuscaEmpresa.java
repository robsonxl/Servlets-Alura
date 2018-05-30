package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class BuscaEmpresa
 */
public class BuscaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
	    String filtro = req.getParameter("filtro");
	    Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
	    req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresas.jsp";
	}
}
