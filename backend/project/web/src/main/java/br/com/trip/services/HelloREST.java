package br.com.trip.services;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.trip.HelloRestWS;

@Path("/hello")
public class HelloREST {
	
	@EJB
	HelloRestWS restWS;

	@GET
	public String hello(){
		return restWS.helloWord();
	}
}
