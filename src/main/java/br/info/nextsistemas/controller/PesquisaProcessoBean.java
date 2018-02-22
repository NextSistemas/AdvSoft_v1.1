package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.ProcessoDAO;
import br.info.nextsistemas.modelo.Processo;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProcessoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	ProcessoDAO processoDAO;
	
	private List<Processo> processos= new ArrayList<>();
	
	private Processo processoSelecionado;
	
	public List<Processo> getProcessos(){
		return processos;
	}
	
	public void excluir() {
		try {
			processoDAO.excluir(processoSelecionado);
			this.processos.remove(processoSelecionado);
			FacesUtil.addSuccessMessage("Processo do cliente " +
			processoSelecionado.getRequerenteRequerido()+ " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	public Processo getProcessoSelecionado() {
		return processoSelecionado;
	}

	public void setProcessoSelecionado(Processo processoSelecionado) {
		this.processoSelecionado = processoSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		processos = processoDAO.buscarTodos();
	}

}
