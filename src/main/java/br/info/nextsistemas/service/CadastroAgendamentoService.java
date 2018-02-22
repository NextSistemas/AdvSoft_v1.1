package br.info.nextsistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.info.nextsistemas.dao.AgendamentoDAO;
import br.info.nextsistemas.modelo.Agendamento;
import br.info.nextsistemas.util.jpa.Transactional;

public class CadastroAgendamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendamentoDAO agendamentoDAO;
	
	@Transactional
	public void salvar(Agendamento agendamento) throws NegocioException {
		
		this.agendamentoDAO.salvar(agendamento);
		
	}
}
