package br.info.nextsistemas.service;

import java.io.Serializable;
import javax.inject.Inject;
import br.info.nextsistemas.dao.TribunalDAO;
import br.info.nextsistemas.modelo.Tribunal;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroTribunalService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TribunalDAO tribunalDAO;
	
	@Transactional
	public void salvar(Tribunal tribunal) throws NegocioException {
		this.tribunalDAO.salvar(tribunal);
	}
}