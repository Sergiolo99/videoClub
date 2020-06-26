package es.deusto.spq.remote;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import es.deusto.spq.DAO.BDmanager;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.dto.UsuarioAssembler;
import es.deusto.spq.data.dto.UsuarioDTO;

@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class RemoteFacade implements IRemoteFacade{
	private int cont = 0;
	private BDmanager bdmanager = null;
	private Logger logger = Logger.getLogger(RemoteFacade.class.getName());
	
	public RemoteFacade() {
		this.bdmanager = BDmanager.getInstance();
	}
		
private static final long serialVersionUID = 1L;
private static RemoteFacade instance;	
	
	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
			instance = new RemoteFacade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
	
		return instance;
	}
	
 	@POST
 	@Path("/registro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(UsuarioDTO usuarioDTO) {
 		Usuario u = bdmanager.getUsuario(usuarioDTO.getId());
		if (u == null) {
			u = UsuarioAssembler.getInstance().DTOtoentity(usuarioDTO);
			bdmanager.store(u);
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
	@Override
	public List<UsuarioDTO> cogerUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
