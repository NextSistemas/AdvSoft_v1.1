package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.ColaboradorDAO;
import br.info.nextsistemas.modelo.Colaborador;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Colaborador.class)
public class ColaboradorConverter implements Converter {
	
	private ColaboradorDAO colaboradorDAO;
	
	public ColaboradorConverter() {
		this.colaboradorDAO = CDIServiceLocator.getBean(ColaboradorDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Colaborador retorno = null;
		
		if (value != null) {
			retorno = this.colaboradorDAO.buscarPeloCodigo(new Long(value));
		}
		
		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Long codigo = ((Colaborador) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
