package es.deusto.spq.remote;

import java.util.List;

import javax.ws.rs.core.Response;

import es.deusto.spq.data.dto.UsuarioDTO;

public interface IRemoteFacade {
	public Response registrarUsuario(UsuarioDTO usuarioDTO);
	public List<UsuarioDTO> cogerUsuario();

}
