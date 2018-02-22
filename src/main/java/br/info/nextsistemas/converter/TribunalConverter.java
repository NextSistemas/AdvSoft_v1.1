package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.TribunalDAO;
import br.info.nextsistemas.modelo.Tribunal;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Tribunal.class)
public class TribunalConverter implements Converter {

	private TribunalDAO tribunalDAO;
	
	public TribunalConverter() {
		this.tribunalDAO = CDIServiceLocator.getBean(TribunalDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Tribunal retorno = null;

		if (value != null) {
			retorno = this.tribunalDAO.buscarPeloId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long id = ((Tribunal) value).getId();
			String retorno = (id == null ? null : id.toString());
			
			return retorno;
		}
		
		return "";
	}
}
