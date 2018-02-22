package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.info.nextsistemas.modelo.Tribunal;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class TribunalDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public void salvar(Tribunal tribunal) {
		if(tribunal.getId() == null) {
			em.persist(tribunal);	
		}else{
			em.merge(tribunal);
		}
		
	}

	public Tribunal buscarPeloId(Long id) {
		return em.find(Tribunal.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Tribunal> buscarTodos() {
		return em.createQuery("from Tribunal").getResultList();
	}

	@Transactional
	public void excluir(Tribunal tribunal) throws NegocioException {
		Tribunal tribunalTemp = em.find(Tribunal.class, tribunal.getId());
		em.remove(tribunalTemp);
		em.flush();

	}
}