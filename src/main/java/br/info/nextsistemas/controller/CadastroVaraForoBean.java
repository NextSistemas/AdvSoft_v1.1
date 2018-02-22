package br.info.nextsistemas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.modelo.VaraForo;
import br.info.nextsistemas.service.CadastroVaraForoService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroVaraForoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroVaraForoService cadastroVaraForoService;

	private VaraForo varaForo;

	public void salvar() {

		try {
			this.cadastroVaraForoService.salvar(varaForo);
			FacesUtil.addSuccessMessage("Vara/Foro Gravado com Sucesso!");

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
		this.varaForo = new VaraForo();
	}

	public VaraForo getVaraForo() {
		return varaForo;
	}

	public void setVaraForo(VaraForo varaForo) {
		this.varaForo = varaForo;
	}

}
