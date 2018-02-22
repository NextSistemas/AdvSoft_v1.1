package br.info.nextsistemas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.info.nextsistemas.dao.ProcessoDAO;
import br.info.nextsistemas.modelo.Processo;
import br.info.nextsistemas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Processo.class)
public class ProcessoConverter implements Converter {

	private ProcessoDAO processoDAO;
	
	public ProcessoConverter() {
		this.processoDAO = CDIServiceLocator.getBean(ProcessoDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Processo retorno = null;

		if (value != null) {
			retorno = this.processoDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long id = ((Processo) value).getCodigo();
			String retorno = (id == null ? null : id.toString());
			
			return retorno;
		}
		
		return "";
	}
}
