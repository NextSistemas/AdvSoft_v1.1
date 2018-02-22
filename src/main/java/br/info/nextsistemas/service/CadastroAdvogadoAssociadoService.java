package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.AdvogadoAssociadoDAO;
import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.modelo.TipoPessoa;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroAdvogadoAssociadoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AdvogadoAssociadoDAO advogadoAssociadoDAO;

	@Transactional
	public void salvar(Pessoa pessoa) throws NegocioException {
		if (pessoa.getTipoPessoa() == null || pessoa.getTipoPessoa().equals(null)) {
			pessoa.setTipoPessoa(TipoPessoa.ADVOGADO_ASSOCIADO);
			
		}
		this.advogadoAssociadoDAO.salvar(pessoa);

	}
}
