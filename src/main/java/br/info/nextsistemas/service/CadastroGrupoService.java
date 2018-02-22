package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.GrupoDAO;
import br.info.nextsistemas.modelo.Grupo;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroGrupoService implements Serializable {

	/**
	 * EDNELSON RODRIGUES
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoDAO grupoDAO;
	
	@Transactional
	public void salvar(Grupo grupo) throws NegocioException {
		
		this.grupoDAO.salvar(grupo);

	}
}
