package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.TribunalDAO;
import br.info.nextsistemas.modelo.Tribunal;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTribunalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	TribunalDAO tribunalDAO;

	private List<Tribunal> tribunais = new ArrayList<>();

	private Tribunal tribunalSelecionado;

	public List<Tribunal> getTribunais() {
		return tribunais;
	}

	public void excluir() {
		try {
			tribunalDAO.excluir(tribunalSelecionado);
			this.tribunais.remove(tribunalSelecionado);
			FacesUtil.addSuccessMessage("" + tribunalSelecionado.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Tribunal getTribunalSelecionado() {
		return tribunalSelecionado;
	}

	public void setTribunalSelecionado(Tribunal tribunalSelecionado) {
		this.tribunalSelecionado = tribunalSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		tribunais = tribunalDAO.buscarTodos();
	}

}