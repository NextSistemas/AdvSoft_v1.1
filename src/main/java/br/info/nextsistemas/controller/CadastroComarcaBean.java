package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.InstanciaDAO;
import br.info.nextsistemas.modelo.Comarca;
import br.info.nextsistemas.modelo.Instancia;
import br.info.nextsistemas.service.CadastroComarcaService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroComarcaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroComarcaService cadastroComarcaService;

	private Comarca comarca;

	public void salvar() {
		try {
			this.cadastroComarcaService.salvar(comarca);
			FacesUtil.addSuccessMessage("Comarca salva com sucesso!");

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
		this.comarca = new Comarca();
	}

	public Comarca getComarca() {
		return comarca;
	}

	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}

}
