package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.InstanciaDAO;
import br.info.nextsistemas.modelo.Instancia;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaInstanciaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	InstanciaDAO instanciaDAO;
	
	private List<Instancia> instancias = new ArrayList<>();
	
	private Instancia instanciaSelecionada;
	
	public List<Instancia> getInstancias(){
		return instancias;
	}
	
	public void excluir() {
		try {
			instanciaDAO.excluir(instanciaSelecionada);
			this.instancias.remove(instanciaSelecionada);
			FacesUtil.addSuccessMessage("Instância " +
			instanciaSelecionada.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Instancia getInstanciaSelecionada() {
		return instanciaSelecionada;
	}

	public void setInstanciaSelecionada(Instancia instanciaSelecionada) {
		this.instanciaSelecionada = instanciaSelecionada;
	}

	@PostConstruct
	public void inicializar() {
		instancias = instanciaDAO.buscarTodos();
	}

}
