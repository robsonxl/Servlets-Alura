package br.com.alura.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("guilherme.silveira@alura.com.br", new Usuario("guilherme.silveira@alura.com.br","silveira"));
		USUARIOS.put("rodrigo.turini@alura.com.br", new Usuario("rodrigo.turini@alura.com.br","turini"));
		USUARIOS.put("teste@teste.com.br", new Usuario("teste","123"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		Usuario user = null;
		if((USUARIOS.get(email)!= null)&&(senha.equals(USUARIOS.get(email).getSenha()))){
			user = USUARIOS.get(email);
		}
		return user;
	}
}