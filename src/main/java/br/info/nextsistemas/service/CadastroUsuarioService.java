package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.UsuarioDAO;
import br.info.nextsistemas.modelo.Usuario;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {

	/**
	 * EDNELSON RODRIGUES
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Transactional
	public void salvar(Usuario usuario) throws NegocioException {
		
		this.usuarioDAO.salvar(usuario);

	}
}
