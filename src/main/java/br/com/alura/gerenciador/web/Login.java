package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login  extends HttpServlet{
 	private static final long serialVersionUID = -3796313427747926879L;
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("password");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		if(usuario == null){
			writer.println("<hmtl><body>usuario ou senha invalido</body></hmtl>");
		}else{
			req.getSession().setAttribute("usuarioLogado", usuario);;
			writer.println("<hmtl><body>Usuario Logado</body></hmtl>");
		}
	}

}
