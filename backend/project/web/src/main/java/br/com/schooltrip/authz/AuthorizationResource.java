package br.com.schooltrip.authz;

import javax.ejb.EJB;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.eng.schooltrip.authz.BasicAuthCredentials;
import com.eng.schooltrip.authz.model.Token;
import com.eng.schooltrip.manager.AuthorizationBean;

@Path("/authz")
public class AuthorizationResource {
	
	@EJB
	private AuthorizationBean authorizationBean;
	
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response login(@HeaderParam("authorization") String auth64) {
		Token t = authorizationBean.login(BasicAuthCredentials.createCredentialsFromHeader(auth64));
		
		if(t != null){
			return Response.ok(t).build();
		}
		
		return Response.status(Status.UNAUTHORIZED).build();
	}

	/**
	 * @param authorizationManager the authorizationManager to set
	 */
	public void setAuthorizationManager(AuthorizationBean authorizationBean) {
		this.authorizationBean = authorizationBean;
	}
}
