package br.info.nextsistemas.service;

import java.io.Serializable;
import javax.inject.Inject;
import br.info.nextsistemas.dao.VaraForoDAO;
import br.info.nextsistemas.modelo.VaraForo;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroVaraForoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private VaraForoDAO varaForoDAO;
	@Transactional
	public void salvar(VaraForo varaForo) throws NegocioException {
		this.varaForoDAO.salvar(varaForo);
	}
}