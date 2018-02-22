package br.info.nextsistemas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "processo")
public class Processo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String requerenteRequerido;
	private String idProcesso;
	private TipoProcesso tipoProcesso;
	private Pessoa pessoa;
	private Tribunal tribunal;
	private Comarca comarca;
	private VaraForo varaForo;
	private Instancia instancia;
	private String observacao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "REQUERENTE_REQUERIDO", nullable = false, length = 45)
	public String getRequerenteRequerido() {
		return requerenteRequerido;
	}

	public void setRequerenteRequerido(String requerenteRequerido) {
		this.requerenteRequerido = requerenteRequerido;
	}

	@Column(name = "ID_PROCESSO", length = 30)
	public String getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(String idProcesso) {
		this.idProcesso = idProcesso;
	}

	@ManyToOne
	public Comarca getComarca() {
		return comarca;
	}

	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}

	@ManyToOne
	public TipoProcesso getTipoProcesso() {
		return tipoProcesso;
	}

	public void setTipoProcesso(TipoProcesso tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
	}

	@ManyToOne
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@ManyToOne
	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	@ManyToOne
	public VaraForo getVaraForo() {
		return varaForo;
	}

	public void setVaraForo(VaraForo varaForo) {
		this.varaForo = varaForo;
	}

	@ManyToOne
	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}

	@Column(name = "OBSERVACAO", length = 150)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
