package br.info.nextsistemas.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import br.info.nextsistemas.dao.AdvogadoDAO;
import br.info.nextsistemas.dao.GrupoDAO;
import br.info.nextsistemas.modelo.ArquivoAnexo;
import br.info.nextsistemas.modelo.Grupo;
import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.service.CadastroAdvogadoService;
import br.info.nextsistemas.service.NegocioException;
import br.info.nextsistemas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAdvogadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//private ArquivoAnexo arquivoAnexo;

	@Inject
	private CadastroAdvogadoService cadastroAdvogadoService;

	private Pessoa pessoa;

	public void salvar() {
		try {
			this.cadastroAdvogadoService.salvar(pessoa);
			FacesUtil.addSuccessMessage("Advogado(a) salvo com sucesso!");

			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	// metodo para Upload de imagens
	/* public void fileUploadImage(FileUploadEvent event) {
		arquivoAnexo = new ArquivoAnexo();
		try {
			Long codAnexoPessoa = pessoa.getCodigo();
			String codAnexoCaminho = "" + codAnexoPessoa;

			FacesContext context = FacesContext.getCurrentInstance();
			String caminhoArquivo = context.getExternalContext().getRealPath("/resources/images");

			String pastaUpload = caminhoArquivo + "/" + "pessoa/" + codAnexoCaminho;

			// Aqui cria o diretorio caso não exista
			File file = new File(pastaUpload);
			if (!file.exists())
				file.mkdirs();

			byte[] anexo = event.getFile().getContents();
			String caminho = pastaUpload + "/" + event.getFile().getFileName();

			// esse trecho grava a imagem no diretorio
			FileOutputStream fos = new FileOutputStream(caminho);
			fos.write(anexo);
			fos.close();
			FacesUtil.addSuccessMessage("Anexo" + event.getFile().getFileName() + "salvo com sucesso!");

			arquivoAnexo.setCaminho(caminho);
			arquivoAnexo.setNome(event.getFile().getFileName());

			pessoa.getArquivosAnexo().add(arquivoAnexo);
			arquivoAnexo.setPessoa(pessoa);
			salvar();
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Erro no upload da imagem" + e);
		}
	}
	
	// metodo para Upload de arquivos
		public void fileUploadArquivo(FileUploadEvent event) {
			arquivoAnexo = new ArquivoAnexo();
			try {
				Long codAnexoPessoa = pessoa.getCodigo();
				String codAnexoCaminho = "" + codAnexoPessoa;

				FacesContext context = FacesContext.getCurrentInstance();
				String caminhoArquivo = context.getExternalContext().getRealPath("/resources/arquivos");

				String pastaUpload = caminhoArquivo + "/" + "pessoa/" + codAnexoCaminho;

				// Aqui cria o diretorio caso não exista
				File file = new File(pastaUpload);
				if (!file.exists())
					file.mkdirs();

				byte[] anexo = event.getFile().getContents();
				String caminho = pastaUpload + "/" + event.getFile().getFileName();

				// esse trecho grava o arquivo no diretorio
				FileOutputStream fos = new FileOutputStream(caminho);
				fos.write(anexo);
				fos.close();
				FacesUtil.addSuccessMessage("Anexo" + event.getFile().getFileName() + "salvo com sucesso!");

				arquivoAnexo.setCaminho(caminho);
				arquivoAnexo.setNome(event.getFile().getFileName());

				pessoa.getArquivosAnexo().add(arquivoAnexo);
				arquivoAnexo.setPessoa(pessoa);
				salvar();
			} catch (Exception e) {
				FacesUtil.addErrorMessage("Erro no upload da imagem" + e);
			}
		}

	// exibição da imagem
	private List<String> images;
	private String caminho;

	//exibição de arquivos
	private List<String> arquivo;
	
	public String getCaminho() {
		return caminho;
	}

	public void carregaImagem() {
		images = new ArrayList<String>();
		arquivo = new ArrayList<String>();
		
		Long codAnexoPessoa = pessoa.getCodigo();
		Pessoa anexoPessoa = new AdvogadoDAO().buscarPeloCodigo(codAnexoPessoa);
		
		for(ArquivoAnexo arquivos : anexoPessoa.getArquivosAnexo()) {
			if(arquivos.getNome().endsWith("pdf")) {
				arquivo.add(arquivos.getNome());
			}else {
				images.add(arquivos.getNome());
			}
		}
	}

	public List<String> getImages() {
		if (pessoa.getCodigo() != null) {
			carregaImagem();
		}
		return images;
	}

	public List<String> getArquivo() {
		if (pessoa.getCodigo() != null) {
			carregaImagem();
		}
		return arquivo;
	} */

	@PostConstruct
	public void init() {
		this.limpar();
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

}
