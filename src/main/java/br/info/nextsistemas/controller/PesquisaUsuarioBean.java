package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.UsuarioDAO;
import br.info.nextsistemas.modelo.Usuario;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	/**
	 * EDNELSON RODRIGUES
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioDAO usuarioDAO;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private Usuario usuarioSelecionado;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void excluir() {
		try {
			usuarioDAO.excluir(usuarioSelecionado);
			this.usuarios.remove(usuarioSelecionado);
			FacesUtil.addSuccessMessage("Usuário " + usuarioSelecionado.getNome() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		usuarios = usuarioDAO.buscarTodos();
	}
	
	public void buscarUsuarioComGrupos() {
		usuarioSelecionado = usuarioDAO.buscarUsuarioComGrupos(usuarioSelecionado.getCodigo());
	}
}
