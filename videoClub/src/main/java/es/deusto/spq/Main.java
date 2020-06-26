package es.deusto.spq;


import es.deusto.spq.controller.Controller;
import es.deusto.spq.service.ServiceLocator;
import es.deusto.spq.ventanas.RegistroUsuario;

public class Main {
    
    public static void main(String[] args) {
    	
    	ServiceLocator servicelocator = new ServiceLocator();
		Controller controller = new Controller(servicelocator);

    	RegistroUsuario registro = new RegistroUsuario(controller);
		registro.setVisible(true);
    	
    }
}

