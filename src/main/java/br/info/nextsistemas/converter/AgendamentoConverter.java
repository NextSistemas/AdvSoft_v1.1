package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.AgendamentoDAO;
import br.info.nextsistemas.modelo.Agendamento;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Agendamento.class)
public class AgendamentoConverter implements Converter {

	private AgendamentoDAO agendamentoDAO;
	
	public AgendamentoConverter() {
		this.agendamentoDAO = CDIServiceLocator.getBean(AgendamentoDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Agendamento retorno = null;
		
		if (value != null) {
			retorno = this.agendamentoDAO.buscarPeloCodigo(new Long(value));
		}
		
		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Agendamento) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
}
