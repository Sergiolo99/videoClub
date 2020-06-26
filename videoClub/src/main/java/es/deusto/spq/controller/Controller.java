package es.deusto.spq.controller;


import es.deusto.spq.service.ServiceLocator;

public class Controller {
	public ServiceLocator serviceLocator;
	
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean registrarUsuario(int id, String nombre, String apellido, String email, String usuario, String contrasenya) {
		return serviceLocator.registrarUsuario(id, nombre, apellido, email, usuario, contrasenya);
		
	}
	
	
	
	
	
	

	

}
