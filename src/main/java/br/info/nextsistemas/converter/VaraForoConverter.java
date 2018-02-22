package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.VaraForoDAO;
import br.info.nextsistemas.modelo.VaraForo;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = VaraForo.class)
public class VaraForoConverter implements Converter {

	private VaraForoDAO varaForoDAO;
	
	public VaraForoConverter() {
		this.varaForoDAO = CDIServiceLocator.getBean(VaraForoDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		VaraForo retorno = null;

		if (value != null) {
			retorno = this.varaForoDAO.buscarPeloId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long id = ((VaraForo) value).getId();
			String retorno = (id == null ? null : id.toString());
			
			return retorno;
		}
		
		return "";
	}
}
