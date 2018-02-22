package br.info.nextsistemas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.modelo.Colaborador;
import br.info.nextsistemas.service.CadastroColaboradorService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroColaboradorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroColaboradorService cadastroColaboradorService;
	
	private Colaborador colaborador;
	
	public void salvar() {
		try {
			this.cadastroColaboradorService.salvar(colaborador);
			FacesUtil.addSuccessMessage("Colaborador salvo com sucesso!");
			
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
		this.colaborador = new Colaborador();
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}
