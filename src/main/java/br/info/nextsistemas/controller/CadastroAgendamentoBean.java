package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.AdvogadoDAO;
import br.info.nextsistemas.modelo.Agendamento;
import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.service.CadastroAgendamentoService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Agendamento agendamento;
	
	private List<Pessoa> pessoas;
	
	@Inject
	private CadastroAgendamentoService cadastroAgendamentoService;

	@Inject
	private AdvogadoDAO advogadoDAO;
	
	public void salvar() {
		try {
			this.cadastroAgendamentoService.salvar(agendamento);
			FacesUtil.addSuccessMessage("Agendamento salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
		this.pessoas = advogadoDAO.buscarTodos();
	}

	private void limpar() {
		this.agendamento = new Agendamento();
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
