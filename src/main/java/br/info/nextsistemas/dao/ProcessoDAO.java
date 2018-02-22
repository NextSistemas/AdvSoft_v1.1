package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.info.nextsistemas.modelo.Processo;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class ProcessoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public void salvar(Processo processo) {
		em.persist(processo);
	}

	public Processo buscarPeloCodigo(Long codigo) {
		return em.find(Processo.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<Processo> buscarTodos() {
		return em.createQuery("from Processo").getResultList();
	}

	@Transactional
	public void excluir(Processo processo) throws NegocioException {
		Processo processoTemp = em.find(Processo.class, processo.getCodigo());
		em.remove(processoTemp);
		em.flush();
	}
}