package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.InstanciaDAO;
import br.info.nextsistemas.modelo.Instancia;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Instancia.class)
public class InstanciaConverter implements Converter {

	private InstanciaDAO instanciaDAO;

	public InstanciaConverter() {
		this.instanciaDAO = CDIServiceLocator.getBean(InstanciaDAO.class);
		
	}
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String value) {
		Instancia retorno = null;
		if (value != null) {
			retorno = this.instanciaDAO.BuscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Instancia) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}