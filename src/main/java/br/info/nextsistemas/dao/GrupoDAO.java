package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.info.nextsistemas.modelo.Grupo;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class GrupoDAO implements Serializable {

	/**
	 * EDNELSON RODRIGUES
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void salvar(Grupo grupo) {

		if (grupo.getCodigo() == null) {
			em.persist(grupo);
		} else {
			em.merge(grupo);
		}
	}
	
	public Grupo buscarPeloCodigo(Long codigo) {
		return em.find(Grupo.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Grupo> buscarTodos() {
		return em.createQuery("from Grupo").getResultList();
	}
	
	@Transactional
	public void excluir(Grupo grupo) throws NegocioException {
		grupo = buscarPeloCodigo(grupo.getCodigo());
		try {
			em.remove(grupo);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esse grupo não pode ser excluído!");
		}
	}
}
