package it.kongaImplementation.interceptors;

import it.konga.framework.kObjects.KAbstract_User;
import it.kongaImplementation.flusso.IStandardResults;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/** Interceptor che si preoccupa di controllare se esiste l'utente in sessione */ 
public class KInterceptorCheckAccess  implements Interceptor
{
	private static final long serialVersionUID = -4209884179941225475L;

	@Override
	public void destroy() {
		clearSessionUser();
	}

	@Override
	public void init() {
		System.out.println("init check access interceptor");
		clearSessionUser();
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		KAbstract_User user = (KAbstract_User) (session.get( KAbstract_User.getSessionID() ));

		if (user == null)
		{
			System.out.println("validazione accesso fallita - forward pagina accesso non consentito");
			return IStandardResults.RESULT_FORBIDDEN;
		}
		return invocation.invoke();
	}
	
	private void clearSessionUser()
	{
		ActionContext cntx = ActionContext.getContext();
		if (cntx == null) return;
		Map<String, Object> session = cntx.getSession();
		if(session == null) return;
		session.remove(KAbstract_User.getSessionID());
	}

}//EO KInterceptor_CheckAutorization
