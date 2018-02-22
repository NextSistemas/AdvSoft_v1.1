package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.ColaboradorDAO;
import br.info.nextsistemas.modelo.Colaborador;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaColaboradorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ColaboradorDAO colaboradorDAO;

	private List<Colaborador> colaborador = new ArrayList<>();

	private Colaborador colaboradorSelecionada;

	public List<Colaborador> getColaborador() {
		return colaborador;
	}

	public void excluir() {
		try {
			colaboradorDAO.excluir(colaboradorSelecionada);
			this.colaborador.remove(colaboradorSelecionada);
			FacesUtil.addSuccessMessage(
					"Colaborador(ra) " + colaboradorSelecionada.getNome() + " excluído com sucesso!");
			inicializar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Colaborador getColaboradorSelecionada() {
		return colaboradorSelecionada;
	}

	public void setColaboradorSelecionada(Colaborador colaboradorSelecionada) {
		this.colaboradorSelecionada = colaboradorSelecionada;
	}

	@PostConstruct
	public void inicializar() {
		colaborador = colaboradorDAO.buscarTodos();
	}

}
