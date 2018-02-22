package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class AdvogadoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public void salvar(Pessoa pessoa) {
		
		if (pessoa.getCodigo() == null) {
			em.persist(pessoa);
		} else {
			em.merge(pessoa);
		}
	}

	public Pessoa buscarPeloCodigo(Long codigo) {
		return em.find(Pessoa.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarTodos() {
		return em.createQuery("from Pessoa where tipoPessoa = 'ADVOGADO'").getResultList();
	}

	@Transactional
	public void excluir(Pessoa pessoa) throws NegocioException {
		pessoa = buscarPeloCodigo(pessoa.getCodigo());
		try {
			em.remove(pessoa);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esse advogado(a) não pode ser excluído!");
		}
	}
}
