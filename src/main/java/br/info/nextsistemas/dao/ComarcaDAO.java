package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.info.nextsistemas.modelo.Comarca;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class ComarcaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void salvar(Comarca comarca) {
		em.merge(comarca);
	}

	public Comarca buscarPeloCodigo(Long codigo) {
		return em.find(Comarca.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Comarca> buscarTodos() {
		return em.createQuery("from Comarca").getResultList();
	}

	@Transactional
	public void excluir(Comarca comarca) throws NegocioException {
		Comarca comarcaTemp = em.find(Comarca.class, comarca.getCodigo());
		em.remove(comarcaTemp);
		em.flush();
	}
}