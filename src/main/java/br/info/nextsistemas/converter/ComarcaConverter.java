package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.ComarcaDAO;
import br.info.nextsistemas.modelo.Comarca;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Comarca.class)
public class ComarcaConverter implements Converter {

	private ComarcaDAO comarcaDAO;

	public ComarcaConverter() {
		this.comarcaDAO = CDIServiceLocator.getBean(ComarcaDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String value) {
		Comarca retorno = null;
		if (value != null) {
			retorno = this.comarcaDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Comarca) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}
		return "";
	}
}