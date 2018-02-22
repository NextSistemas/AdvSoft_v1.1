package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.info.nextsistemas.modelo.Agendamento;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class AgendamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void salvar(Agendamento agendamento) {
		em.merge(agendamento);
	}
	
	public Agendamento buscarPeloCodigo(Long codigo) {
		return em.find(Agendamento.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Agendamento> buscarTodos(){
		return em.createQuery("from Agendamento").getResultList();
	}
	
	@Transactional
	public void excluir(Agendamento agendamento) throws NegocioException {
		Agendamento agendamentoTemp = em.find(Agendamento.class, agendamento.getCodigo());
		em.remove(agendamentoTemp);
		em.flush();
 	}
}
