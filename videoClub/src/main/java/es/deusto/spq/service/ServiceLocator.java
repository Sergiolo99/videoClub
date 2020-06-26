package es.deusto.spq.service;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


import es.deusto.spq.data.Usuario;
import es.deusto.spq.resources.GetPropertyValues;



public class ServiceLocator {
	
	private Client client;
	private WebTarget webTarget;
	private static Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	
	public ServiceLocator() {
		client = ClientBuilder.newClient();
		webTarget = client.target(cogerUrl());
		
	}
	
	public boolean registrarUsuario(int id, String nombre, String apellido, String email, String usuario, String contrasenya) {
		WebTarget registerUserWebTarget = webTarget.path("server/registro");
		System.out.println(registerUserWebTarget);
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario u = new Usuario();
		u.setId(id);
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setEmail(email);
		u.setUsuario(usuario);
		u.setContrasenya(contrasenya);
		
		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		System.err.println(response);
		if (response != Response.ok().build()) {
			logger.error("Error connecting with the server. Code: " + response.getStatus());
			return false;
		} else {
			logger.info("User correctly registered");
			return true;
		}
		
		
	}
	
	
	
	public static String cogerUrl(){
		GetPropertyValues properties = new GetPropertyValues();
		String url = "";
		
		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return url;
		
	}

}
