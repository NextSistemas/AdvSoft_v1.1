package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.ClienteDAO;
import br.info.nextsistemas.modelo.Pessoa;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pessoa.class)
public class ClienteConverte implements Converter {

	ClienteDAO clienteDAO;

	public ClienteConverte() {
		this.clienteDAO = CDIServiceLocator.getBean(ClienteDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;

		if (value != null) {
			retorno = this.clienteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Pessoa) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}
}
