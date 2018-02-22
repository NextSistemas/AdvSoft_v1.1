package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.info.nextsistemas.modelo.TipoProcesso;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class TipoProcessoDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void salvar(TipoProcesso tipoProcesso) {
		em.merge(tipoProcesso);
	}

	public TipoProcesso buscarPeloCodigo(Long codigo) {
		return em.find(TipoProcesso.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<TipoProcesso> buscarTodos() {
		return em.createQuery("from TipoProcesso").getResultList();
	}

	@Transactional
	public void excluir(TipoProcesso tipoProcesso) throws NegocioException {
		TipoProcesso tipoProcessoTemp = em.find(TipoProcesso.class, tipoProcesso.getCodigo());
		em.remove(tipoProcessoTemp);
		em.flush();
	}
}