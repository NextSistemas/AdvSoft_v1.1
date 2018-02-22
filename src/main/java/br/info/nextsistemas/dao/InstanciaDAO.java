package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.info.nextsistemas.modelo.Instancia;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class InstanciaDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void salvar(Instancia instancia) {
		em.merge(instancia);
	}
	public Instancia BuscarPeloCodigo(Long codigo) {
		return em.find(Instancia.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Instancia> buscarTodos() {
		return em.createQuery("from Instancia").getResultList();
	}

	@Transactional
	public void excluir(Instancia instancia) throws NegocioException {
		Instancia instanciaTemp = em.find(Instancia.class, instancia.getCodigo());
		em.remove(instanciaTemp);
		em.flush();
	}
}
