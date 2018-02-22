package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.info.nextsistemas.modelo.Colaborador;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class ColaboradorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public void salvar(Colaborador colaborador) {
			em.merge(colaborador);
	}

	public Colaborador buscarPeloCodigo(Long codigo) {
		return em.find(Colaborador.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> buscarTodos() {
		return em.createQuery("from Colaborador").getResultList();
	}

	@Transactional
	public void excluir(Colaborador colaboradorSelecionada) throws NegocioException {
		Colaborador colaboradorTemp = em.find(Colaborador.class, colaboradorSelecionada.getCodigo());
		em.remove(colaboradorTemp);
		em.flush();
	}

}
