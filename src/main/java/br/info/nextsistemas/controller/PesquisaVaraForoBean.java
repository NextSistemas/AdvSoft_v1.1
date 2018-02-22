package br.info.nextsistemas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.info.nextsistemas.dao.VaraForoDAO;
import br.info.nextsistemas.modelo.VaraForo;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaVaraForoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	VaraForoDAO varaForoDAO;

	private List<VaraForo> varaForos = new ArrayList<>();

	private VaraForo varaForoSelecionado;

	public List<VaraForo> getVaraForos() {
		return varaForos;
	}

	public void excluir() {
		try {
			varaForoDAO.excluir(varaForoSelecionado);
			this.varaForos.remove(varaForoSelecionado);
			FacesUtil.addSuccessMessage("Vara/Foro " + varaForoSelecionado.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public VaraForo getVaraForoSelecionado() {
		return varaForoSelecionado;
	}

	public void setVaraForoSelecionado(VaraForo varaForoSelecionado) {
		this.varaForoSelecionado = varaForoSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		varaForos = varaForoDAO.buscarTodos();
	}

}