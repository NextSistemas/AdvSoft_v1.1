package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.ComarcaDAO;
import br.info.nextsistemas.modelo.Comarca;
import br.info.nextsistemas.modelo.Instancia;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaComarcaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ComarcaDAO comarcaDAO;
	
	private Instancia instancia;

	private List<Comarca> comarcas = new ArrayList<>();

	private Comarca comarcaSelecionada;

	public List<Comarca> getComarcas() {
		return comarcas;
	}

	public void excluir() {
		try {
			comarcaDAO.excluir(comarcaSelecionada);
			this.comarcas.remove(comarcaSelecionada);
			FacesUtil.addSuccessMessage("Comarca " + comarcaSelecionada.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Comarca getComarcaSelecionada() {
		return comarcaSelecionada;
	}

	public void setComarcaSelecionada(Comarca comarcaSelecionada) {
		this.comarcaSelecionada = comarcaSelecionada;
	}

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}

	@PostConstruct
	public void inicializar() {
		comarcas = comarcaDAO.buscarTodos();
	}

}
