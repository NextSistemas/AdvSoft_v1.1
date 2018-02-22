package br.info.nextsistemas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.modelo.Instancia;
import br.info.nextsistemas.service.CadastroInstanciaService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroInstanciaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroInstanciaService cadastroInstanciaService;

	private Instancia instancia;

	public void salvar() {
		try {
			this.cadastroInstanciaService.salvar(instancia);
			FacesUtil.addSuccessMessage("Instancia salva com sucesso!");

			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		this.instancia = new Instancia();
	}

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}

}