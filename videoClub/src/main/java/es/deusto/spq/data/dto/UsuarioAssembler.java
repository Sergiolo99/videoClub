package es.deusto.spq.data.dto;

import es.deusto.spq.data.Usuario;

public class UsuarioAssembler {
	
	private static UsuarioAssembler instance;

	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}
	public UsuarioDTO entitytoDTO(Usuario usuario) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellido(usuario.getApellido());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setUsuario(usuario.getUsuario());
		usuarioDTO.setContrasenya(usuario.getContrasenya());
		
		return usuarioDTO;
		
		
	}
	
	public Usuario DTOtoentity(UsuarioDTO usuarioDTO) {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellido(usuarioDTO.getApellido());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setUsuario(usuarioDTO.getUsuario());
		usuario.setContrasenya(usuarioDTO.getContrasenya());
		
		return usuario;
		
		
	}

}
