package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.AdvogadoAssociadoDAO;
import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAdvogadoAssociadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AdvogadoAssociadoDAO advogadoAssociadoDAO;

	private List<Pessoa> pessoas = new ArrayList<>();

	private Pessoa pessoaSelecionada;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void excluir() {
		try {
			advogadoAssociadoDAO.excluir(pessoaSelecionada);
			this.pessoas.remove(pessoaSelecionada);
			FacesUtil.addSuccessMessage("Advogado(a) Associado(a) " + pessoaSelecionada.getNome() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	@PostConstruct
	public void inicializar() {
		pessoas = advogadoAssociadoDAO.buscarTodos();
	}
}
