package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.InstanciaDAO;
import br.info.nextsistemas.modelo.Instancia;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroInstanciaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private InstanciaDAO instanciaDAO;
	
	@Transactional
	public void salvar(Instancia instancia ) throws NegocioException {
		this.instanciaDAO.salvar(instancia);
	}

}
