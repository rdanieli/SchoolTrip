package br.com.schooltrip.authz;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.eng.framework.authz.BasicAuthCredentials;
import com.eng.framework.authz.model.Token;
import com.eng.framework.infra.RNException;
import com.eng.schooltrip.manager.AuthorizationBean;

@Path("/authz")
public class AuthorizationResource {
	
	@EJB
	private AuthorizationBean authorizationBean;
	
	@Path("/oi")
	@GET
	public String oi() {
		return "Estou ativo.";
	} 
	
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response login(@HeaderParam("authorization") String auth64) {
		try {
			Token t = authorizationBean.login(BasicAuthCredentials.createCredentialsFromHeader(auth64));
			
			if(t != null){
				return Response.ok(t).build();
			}
		} catch (RNException | EJBException e) {
			Response.ok(e.getMessage()).status(Status.UNAUTHORIZED).build();
		}
		
		return Response.status(Status.UNAUTHORIZED).build();
	}

	public AuthorizationBean getAuthorizationBean() {
		return authorizationBean;
	}

	public void setAuthorizationBean(AuthorizationBean authorizationBean) {
		this.authorizationBean = authorizationBean;
	}
}
