package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.TipoProcessoDAO;
import br.info.nextsistemas.modelo.TipoProcesso;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroTipoProcessoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoProcessoDAO tipoProcessoDAO;
	
	@Transactional
	public void salvar(TipoProcesso tipoProcesso ) throws NegocioException {
		this.tipoProcessoDAO.salvar(tipoProcesso);
	}

}
