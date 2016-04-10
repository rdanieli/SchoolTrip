package br.com.trip;

import javax.ejb.Stateless;

@Stateless
public class HelloRestWS {
	public String helloWord(){
		return "Olá mundo.";
	}
}
