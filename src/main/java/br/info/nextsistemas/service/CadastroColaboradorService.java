package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.ColaboradorDAO;
import br.info.nextsistemas.modelo.Colaborador;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroColaboradorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ColaboradorDAO colaboradorDAO;

	@Transactional
	public void salvar(Colaborador colaborador) throws NegocioException {

		this.colaboradorDAO.salvar(colaborador);
	}

}
