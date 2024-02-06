package ec.edu.ups.examen.Final.services;

import ec.edu.ups.examen.Final.business.GestionCliente;
import ec.edu.ups.examen.Final.model.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class ClienteServices {

	@Inject
	private GestionCliente ges;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Cliente cliente) {
		try {
			ges.crear(cliente);
			return Response.ok(cliente).build();
		}catch (Exception e) {
			return Response.status(Response.Status.NOT_MODIFIED).entity(cliente).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{dni}")
	public Response getCliente(@PathParam("dni") String dni) {
		try {
			ges.getCliente(dni);
			return Response.ok(ges.getCliente(dni)).build();
		}catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("jefe")
	public Response getJefe() {
		try {
			ges.getJefe();
			return Response.ok(ges.getJefe()).build();
		}catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("lista")
	public Response getAll() {
		try {
			ges.getAll();
			return Response.ok(ges.getAll()).build();
		}catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
		}
	}
	
	
	
}
