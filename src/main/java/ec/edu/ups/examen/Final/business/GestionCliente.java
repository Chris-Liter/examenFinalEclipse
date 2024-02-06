package ec.edu.ups.examen.Final.business;

import java.util.List;

import ec.edu.ups.examen.Final.dao.ClienteDAO;
import ec.edu.ups.examen.Final.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCliente {

	
	@Inject
	private ClienteDAO dao;
	
	public void crear(Cliente cliente ) {
		dao.crear(cliente);
	}
	
	public Cliente getCliente(String dni) {
		return dao.getCliente(dni);
	}
	
	public Cliente getJefe() {
		return dao.getJefe();
	}
	
	public List<Cliente> getAll(){
		return dao.getAll();
	}
}
