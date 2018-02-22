package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.info.nextsistemas.modelo.VaraForo;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class VaraForoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public void salvar(VaraForo varaForo) {
		if (varaForo.getId() == null) {
			em.persist(varaForo);

		} else {
			em.merge(varaForo);
		}

	}

	public VaraForo buscarPeloId(Long id) {
		return em.find(VaraForo.class, id);

	}
	@SuppressWarnings("unchecked")
	public List<VaraForo> buscarTodos() {
		return em.createQuery("from VaraForo").getResultList();
	}

	@Transactional
	public void excluir(VaraForo varaForo) throws NegocioException {
		VaraForo varaForoTemp = em.find(VaraForo.class, varaForo.getId());
		em.remove(varaForoTemp);
		em.flush();

	}

}