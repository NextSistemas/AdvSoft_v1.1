package br.info.nextsistemas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.modelo.Tribunal;
import br.info.nextsistemas.service.CadastroTribunalService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroTribunalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroTribunalService cadastroTribunalService;

	private Tribunal tribunal;

	public void salvar() {

		try {
			this.cadastroTribunalService.salvar(tribunal);
			FacesUtil.addSuccessMessage("Tribunal salvo com sucesso!");

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
		this.tribunal = new Tribunal();
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

}
