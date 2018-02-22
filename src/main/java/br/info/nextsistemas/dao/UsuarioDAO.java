package br.info.nextsistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.modelo.Usuario;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jpa.Transactional;

public class UsuarioDAO implements Serializable {

	/**
	 * EDNELSON RODRIGUES
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public void salvar(Usuario usuario) {

		if (usuario.getCodigo() == null && usuario.getGrupos() == null) {
			em.persist(usuario);
		} else {
			em.merge(usuario);
		}
	}

	public Usuario buscarPeloCodigo(Long codigo) {
		return em.find(Usuario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		return em.createQuery("from Usuario").getResultList();
	}

	@Transactional
	public void excluir(Usuario usuario) throws NegocioException {
		usuario = buscarPeloCodigo(usuario.getCodigo());
		try {
			em.remove(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esse usuário não pode ser excluído!");
		}
	}

	public Usuario porEmail(String email) {
		Usuario usuario = null;

		try {
			usuario = this.em.createQuery("from Usuario where lower(email) = :email", Usuario.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum encontrado com o e-mail informado
		}

		return usuario;
	}

	public Usuario buscarUsuarioComGrupos(Long codigo) {
		return (Usuario) em.createQuery("select u from Usuario u JOIN u.grupos g where u.codigo = ?")
				.setParameter(1, codigo).getSingleResult();
	}
}
