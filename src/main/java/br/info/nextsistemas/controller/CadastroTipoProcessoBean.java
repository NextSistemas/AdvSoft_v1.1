package br.info.nextsistemas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.modelo.TipoProcesso;
import br.info.nextsistemas.service.CadastroTipoProcessoService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroTipoProcessoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroTipoProcessoService cadastroTipoProcessoService;

	private TipoProcesso tipoProcesso;

	public void salvar() {
		try {
			this.cadastroTipoProcessoService.salvar(tipoProcesso);
			FacesUtil.addSuccessMessage("Tipo de Processo salvo com sucesso!");

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
		this.tipoProcesso = new TipoProcesso();
	}

	public TipoProcesso getTipoProcesso() {
		return tipoProcesso;
	}

	public void setTipoProcesso(TipoProcesso tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
	}

}
