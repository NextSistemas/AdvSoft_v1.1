package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.ComarcaDAO;
import br.info.nextsistemas.modelo.Comarca;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroComarcaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ComarcaDAO comarcaDAO;

	@Transactional
	public void salvar(Comarca comarca) throws NegocioException {
		this.comarcaDAO.salvar(comarca);
	}

}
