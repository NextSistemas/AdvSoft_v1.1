package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.AdvogadoDAO;
import br.info.nextsistemas.dao.ComarcaDAO;
import br.info.nextsistemas.dao.TipoProcessoDAO;
import br.info.nextsistemas.modelo.Comarca;
import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.modelo.Processo;
import br.info.nextsistemas.modelo.TipoProcesso;
import br.info.nextsistemas.service.CadastroProcessoService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProcessoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroProcessoService cadastroProcessoService;
	
	private List<TipoProcesso> tipoProcessos;
	
	@Inject
	TipoProcessoDAO tipoProcessoDAO;
	
	@Inject
	AdvogadoDAO advogadoDAO;
	
	@Inject
	ComarcaDAO comarcaDAO;

	private Processo processo;
	
	private List<Pessoa> pessoas;
	
	private List<Comarca> comarcas;

	public void salvar() {

		try {
			this.cadastroProcessoService.salvar(processo);
			FacesUtil.addSuccessMessage("Processo salvo com Sucesso!");

			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.tipoProcessos = tipoProcessoDAO.buscarTodos();
		this.pessoas = advogadoDAO.buscarTodos();
		this.comarcas = comarcaDAO.buscarTodos();
	}

	private void limpar() {
		this.processo = new Processo();
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<TipoProcesso> getTipoProcessos() {
		return tipoProcessos;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public List<Comarca> getComarcas() {
		return comarcas;
	}

}
