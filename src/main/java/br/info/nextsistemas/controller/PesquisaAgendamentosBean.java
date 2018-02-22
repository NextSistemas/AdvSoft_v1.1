package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.AgendamentoDAO;
import br.info.nextsistemas.modelo.Agendamento;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAgendamentosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AgendamentoDAO agendamentoDAO;

	private List<Agendamento> agendamentos = new ArrayList<>();

	private Agendamento agendamentoSelecionado;

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void excluir() {
		try {
			agendamentoDAO.excluir(agendamentoSelecionado);
			this.agendamentos.remove(agendamentoSelecionado);
			FacesUtil.addSuccessMessage("Agendamento " 
			+ agendamentoSelecionado.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Agendamento getAgendamentoSelecionado() {
		return agendamentoSelecionado;
	}

	public void setAgendamentoSelecionado(Agendamento agendamentoSelecionado) {
		this.agendamentoSelecionado = agendamentoSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		agendamentos = agendamentoDAO.buscarTodos();
	}
}
