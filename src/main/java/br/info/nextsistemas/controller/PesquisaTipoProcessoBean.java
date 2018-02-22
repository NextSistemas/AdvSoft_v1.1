package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.TipoProcessoDAO;
import br.info.nextsistemas.modelo.TipoProcesso;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTipoProcessoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	TipoProcessoDAO tipoProcessoDAO;
	
	private List<TipoProcesso> tipoProcessos = new ArrayList<>();
	
	private TipoProcesso tipoProcessoSelecionado;
	
	public List<TipoProcesso> getTipoProcesso(){
		return tipoProcessos;
	}
	
	public void excluir() {
		try {
			tipoProcessoDAO.excluir(tipoProcessoSelecionado);
			this.tipoProcessos.remove(tipoProcessoSelecionado);
			FacesUtil.addSuccessMessage("Tipo de Processo " +
			tipoProcessoSelecionado.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	public TipoProcesso getTipoProcessoSelecionado() {
		return tipoProcessoSelecionado;
	}

	public void setTipoProcessoSelecionado(TipoProcesso tipoProcessoSelecionado) {
		this.tipoProcessoSelecionado = tipoProcessoSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		tipoProcessos = tipoProcessoDAO.buscarTodos();
	}

}
