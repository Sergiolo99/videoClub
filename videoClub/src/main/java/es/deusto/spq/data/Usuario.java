package es.deusto.spq.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {
	
	private static final long serialVersionUID = 1L;
	@PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	public static int id;
	
	private String nombre;
	private String apellido;
	private String email;
	private String usuario;
	private String contrasenya;
	
	
	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id= id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public Usuario(int id, String nombre, String apellido, String email, String usuario, String contrasenya) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellido = "";
		this.email = "";
		this.usuario = "";
		this.contrasenya = "";
	}

	
	
	@Override
	public String toString() {
		return "Usuario=" + usuario + "Nombre=" + nombre + ", Apellido=" + apellido;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
