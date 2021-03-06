package it.kongaImplementation.actions.esempi;

import it.kongaImplementation.dto.KUser;
import it.kongaImplementation.flusso.KBaseAction;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
	@Result(name="go_home", type="tiles", location="konga.tiles.home")
})
public class ACT_Home extends KBaseAction
{
	private static final long serialVersionUID = -7251065121878532439L;

	@Action(value="/home")
	public String home() throws Exception
	{
		KUser utente = getUser();
		String msgUtente = "utente con accesso di tipo : "+ utente.getAccessLevel().getDescription();	
		System.out.println( msgUtente );
		return "go_home";
	}
}//EO ACT_Home
