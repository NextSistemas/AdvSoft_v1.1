package br.info.nextsistemas.service;

import java.io.Serializable;
import javax.inject.Inject;
import br.info.nextsistemas.dao.ProcessoDAO;
import br.info.nextsistemas.modelo.Processo;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroProcessoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProcessoDAO processoDAO;
	@Transactional
	public void salvar(Processo processo) throws NegocioException {
		this.processoDAO.salvar(processo);
	}
}