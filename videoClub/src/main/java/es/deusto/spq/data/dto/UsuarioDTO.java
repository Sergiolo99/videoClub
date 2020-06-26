package es.deusto.spq.data.dto;

import java.io.Serializable;


public class UsuarioDTO implements Serializable{
	
	
		private static final long serialVersionUID =1L;

		private int id;
		private String nombre;
		private String apellido;
		private String email;
		private String usuario;
		private String contrasenya;
		
		
		public int getId() {
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


		public UsuarioDTO(int id, String nombre, String apellido, String email, String usuario, String contrasenya) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.usuario = usuario;
			this.contrasenya = contrasenya;
		}
		
		public UsuarioDTO() {
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

}
