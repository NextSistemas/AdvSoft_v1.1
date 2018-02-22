package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.TipoProcessoDAO;
import br.info.nextsistemas.modelo.TipoProcesso;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TipoProcesso.class)
public class TipoProcessoConverter implements Converter {
	private TipoProcessoDAO tipoProcessoDAO;

	public TipoProcessoConverter() {
		this.tipoProcessoDAO = CDIServiceLocator.getBean(TipoProcessoDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String value) {
		TipoProcesso retorno = null;
		if (value != null) {
			retorno = this.tipoProcessoDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((TipoProcesso) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}
		return "";
	}
}
