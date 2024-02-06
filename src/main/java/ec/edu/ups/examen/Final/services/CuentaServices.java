package ec.edu.ups.examen.Final.services;

import ec.edu.ups.examen.Final.business.GestionCuenta;
import ec.edu.ups.examen.Final.model.Cuenta;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cuenta")
public class CuentaServices {

	@Inject
	private GestionCuenta ges;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{origen}/{destino}/{operador}/{monto}")
	public Response transferir(@PathParam("origen") String origen, @PathParam("destino") String destino, @PathParam("operador") String operador, @PathParam("monto") double monto) {
		try {
			Cuenta cuentaOrigen = ges.getCue(origen);
			Cuenta cuentaDestino = ges.getCuenta(destino, operador);
			ges.transferir(cuentaOrigen, cuentaDestino, monto);
			return Response.ok("Exito:" + origen + " " + destino + " " + operador + " " + monto).build();		
		}catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
		}
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getCuenta(@PathParam("id") int id) {
		try {
			return Response.ok(ges.getCuentaPorCliente(id)).build();
		}catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
		}
	}
	
}
