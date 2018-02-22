package br.info.nextsistemas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.modelo.Grupo;
import br.info.nextsistemas.service.CadastroGrupoService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable {

	/**
	 * EDNELSON RODRIGUES
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroGrupoService cadastroGrupoService;
	
	private Grupo grupo;
	
	public void salvar() {
		try {
			this.cadastroGrupoService.salvar(grupo);
			FacesUtil.addSuccessMessage("Grupo salvo com sucesso!");

			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}

	private void limpar() {
		this.grupo = new Grupo();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
