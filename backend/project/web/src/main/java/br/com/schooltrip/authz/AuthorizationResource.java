package br.com.schooltrip.authz;

import javax.ejb.EJB;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eng.schooltrip.authz.BasicAuthCredentials;
import com.eng.schooltrip.authz.model.Token;

@Path("/authz")
public class AuthorizationResource {
	
//	@EJB
//	private AuthorizationManager authorizationManager;
	
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response login(@HeaderParam("Authorization") String auth64) {
//		Token token = BasicAuthCredentials.createCredentialsFromHeader(auth64);
		
		
		return null;
	}

	/**
	 * @param authorizationManager the authorizationManager to set
	 */
//	public void setAuthorizationManager(AuthorizationManager authorizationManager) {
//		this.authorizationManager = authorizationManager;
//	}
}
