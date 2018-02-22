package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.GrupoDAO;
import br.info.nextsistemas.modelo.Grupo;
import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.service.CadastroAdvogadoAssociadoService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAdvogadoAssociadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Grupo> grupos;

	@Inject
	private GrupoDAO grupoDAO;

	@Inject
	private CadastroAdvogadoAssociadoService cadastroAdvogadoAssociadoService;

	private Pessoa pessoa;

	public void salvar() {
		try {
			this.cadastroAdvogadoAssociadoService.salvar(pessoa);
			FacesUtil.addSuccessMessage("Advogado(a) Associado(a) salvo com sucesso!");

			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.grupos = grupoDAO.buscarTodos();
	}

	private void limpar() {
		this.pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

}
